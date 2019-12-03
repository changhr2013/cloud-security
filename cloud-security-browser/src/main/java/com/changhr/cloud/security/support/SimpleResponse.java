package com.changhr.cloud.security.support;

/**
 * @author changhr2013
 * @date 2019/12/4
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public SimpleResponse() {
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
