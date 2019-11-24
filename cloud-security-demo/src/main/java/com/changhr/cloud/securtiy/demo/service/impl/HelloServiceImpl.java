package com.changhr.cloud.securtiy.demo.service.impl;

import com.changhr.cloud.securtiy.demo.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author changhr2013
 * @date 2019/11/20
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        return "hello " + name;
    }
}
