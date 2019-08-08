package com.ecoop.ecoopgateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ServerProperties
 * @Description TODO
 * @Author crazy
 * @Date 2019-08-07 19:26
 * @Version 1.0
 **/
@ConfigurationProperties("filter")
public class ServerProperties {

    private String zsuserUrl;

    private List<String> authUrl;

    public void setZsuserUrl(String zsuserUrl) {
        this.zsuserUrl = zsuserUrl;
    }

    public void setAuthUrl(List<String> authUrl) {
        this.authUrl = authUrl;
    }

    public List<String> getAuthUrl() {
        return authUrl;
    }

    public String getZsuserUrl() {
        return zsuserUrl;
    }
}
