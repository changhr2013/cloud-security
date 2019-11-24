package com.changhr.cloud.securtiy.demo.exception;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super(id + " user not exist");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
