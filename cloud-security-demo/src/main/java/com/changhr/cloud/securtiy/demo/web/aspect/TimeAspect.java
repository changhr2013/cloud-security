package com.changhr.cloud.securtiy.demo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.changhr.cloud.securtiy.demo.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[aspect] time aspect start");
        long start = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("[aspect] " + arg);
        }
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("[aspect] aspect time=[" + (end - start) + "]");
        System.out.println("[aspect] time aspect end");
        return object;
    }
}
