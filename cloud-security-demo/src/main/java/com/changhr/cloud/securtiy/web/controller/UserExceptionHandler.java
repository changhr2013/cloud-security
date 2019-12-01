package com.changhr.cloud.securtiy.web.controller;

import com.changhr.cloud.securtiy.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public Map<String , Object> handlerUserNotExistException(UserNotExistException e){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", "500");
        resultMap.put("message", "用户不存在");
        return resultMap;
    }
}
