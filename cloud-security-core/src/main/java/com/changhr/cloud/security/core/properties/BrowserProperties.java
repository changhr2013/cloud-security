package com.changhr.cloud.security.core.properties;

/**
 * @author changhr2013
 * @date 2019/12/3
 */
public class BrowserProperties {

    private String loginPage = "/simple-signIn.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
