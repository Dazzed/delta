package com.delta.cru.cnfg;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@Configuration
@MappedTypes(value = { EmpPhVo.class,EmpNmeVo.class })
@MapperScan("com.delta.cru.dao.mapper")
@ComponentScan("com.delta.cru")
public class CmnCnfg extends WebMvcConfigurerAdapter {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CnfgReader cnfgReader;

    @Autowired
    private Environment env;
    
    @Autowired
    private DataSource dataSource;
    

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(getOrigs())
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("X-Auth-Token", "Content-Type", "Accept", "TransactionId",
                        "applicationVersionNum", "apiResourceName", "applicationDeviceOsName",
                        "Authorization", "applicationDeviceMacAdr", "applicationName",
                        "apiConsumerRecordText", "applicationOwnerCode", "networkIpAdr",
                        "applicationDeviceName", "requestedEmployeeId", "apiRequestUtcTs",
                        "employeeId")
                .exposedHeaders("Content-Type", "Accept", "TransactionId").allowCredentials(false)
                .maxAge(4800);
    }

    public String[] getOrigs() {
        String[] allOrigs = null;
        if (CollectionUtils.isEmpty(cnfgReader.getAllowedOrigins())) {
            allOrigs = new String[1];
            allOrigs[0] = "*";
        } else {
            allOrigs = new String[cnfgReader.getAllowedOrigins().size()];
            for (int i = 0; i < cnfgReader.getAllowedOrigins().size(); i++) {
                allOrigs[i] = cnfgReader.getAllowedOrigins().get(i);
            }
        }
        return allOrigs;
    }


    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        log.info("DataSource Transaction Manager");
        return transactionManager;
    }

    @Bean
    public SqlSessionFactory sessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.delta.cru.domn");
        bean.setMapperLocations(new Resource[] { new ClassPathResource("EmpMapper.xml"),
                new ClassPathResource("EmpSPMapper.xml"), new ClassPathResource("LogMapper.xml")
                , new ClassPathResource("EventsMapper.xml") });
        log.info("SqlSessionFactory :", env.getActiveProfiles());
        return bean.getObject();
    }

    @Bean
    @Profile(value = { "test" })
    public DataSource jndiDataSourceTest() {
        log.info("DvlDataSource Test");
        return DataSourceBuilder.create().username(cnfgReader.getUsrNme())
                .password(cnfgReader.getPswd()).url(cnfgReader.getUrl())
                .driverClassName("oracle.jdbc.driver.OracleDriver").build();
    }
    
}
