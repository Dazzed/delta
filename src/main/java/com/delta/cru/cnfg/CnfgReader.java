package com.delta.cru.cnfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@PropertySource(value = "file:${config.location}BsPrdTmpltSvcRst.properties")
public class CnfgReader {
    private List<String> allowedOrigins = new ArrayList<>();
    private String url = null;
    private String usrNme = null;
    private String pswd = null;
    private String jndiNme = null;
    private String logMqUrl = null;

    public String getLogMqUrl() {
		return logMqUrl;
	}

	public void setLogMqUrl(String logMqUrl) {
		this.logMqUrl = logMqUrl;
	}

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsrNme() {
        return usrNme;
    }

    public void setUsrNme(String usrNme) {
        this.usrNme = usrNme;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getJndiNme() {
        return jndiNme;
    }

    public void setJndiNme(String jndiNme) {
        this.jndiNme = jndiNme;
    }
    
    public boolean getLookup() {
        return true;
    }
    
    

}
