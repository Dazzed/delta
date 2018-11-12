package com.delta.cru;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jndi.JndiObjectFactoryBean;
import com.delta.cru.cnfg.CnfgReader;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableAspectJAutoProxy
public class Application extends SpringBootServletInitializer {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CnfgReader cnfgReader;

	private static final Class<Application> applicationClass = Application.class;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(applicationClass);
		System.setProperty("CRU_APP_RUN_MODE", "BOOT");
		application.run(args);
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.setProperty("CRU_APP_RUN_MODE", "WAR");
		return application.sources(applicationClass);
	}

	@Bean(destroyMethod = "")
	@ConditionalOnProperty(value = "CRU_APP_RUN_MODE", havingValue = "WAR")
	public DataSource jndiDataSrc() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName(cnfgReader.getJndiNme());
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(false);// NEVER OVERRIDE IT IN BOOT MODE
		bean.afterPropertiesSet();
		DataSource dataSource = (DataSource) bean.getObject();
		log.info("Looked up and found : ", cnfgReader.getJndiNme());
		return dataSource;
	}

	@Bean(destroyMethod = "")
	@ConditionalOnProperty(value = "CRU_APP_RUN_MODE", havingValue = "BOOT")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
		bean.setJndiName("java:comp/env/" + cnfgReader.getJndiNme());
		bean.setProxyInterface(DataSource.class);
		bean.setLookupOnStartup(cnfgReader.getLookup());
		bean.afterPropertiesSet();
		DataSource dataSource = (DataSource) bean.getObject();
		log.info("Looked up and found : java:comp/env/", cnfgReader.getJndiNme());
		return dataSource;
	}
	
	@Bean
	@ConditionalOnProperty(value = "CRU_APP_RUN_MODE", havingValue = "BOOT")
	public TomcatEmbeddedServletContainerFactory tomcatFactory() {
		return new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}

			@Override
			protected void postProcessContext(Context context) {
				ContextResource resource = new ContextResource();
				resource.setName(cnfgReader.getJndiNme());
				resource.setType(DataSource.class.getName());
				resource.setProperty("driverClassName", "oracle.jdbc.OracleDriver");
				resource.setProperty("url", cnfgReader.getUrl());
				resource.setProperty("username", cnfgReader.getUsrNme());
				resource.setProperty("password", cnfgReader.getPswd());
				context.getNamingResources().addResource(resource);
				log.info("BsPrdTmpltSvcRst running from embedded container " + cnfgReader.getJndiNme()
						+ " configured programatically");
			}
		};
	}
}
