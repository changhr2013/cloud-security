package com.changhr.cloud.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author changhr2013
 * @date 2019/12/4
 */
@ConfigurationProperties(prefix = "simple.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
