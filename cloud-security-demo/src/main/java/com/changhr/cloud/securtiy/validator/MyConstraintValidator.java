package com.changhr.cloud.securtiy.validator;

import com.changhr.cloud.securtiy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author changhr2013
 * @date 2019/11/20
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("My Validator Init.");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println(helloService.greeting("tom"));
        System.out.println(value);
        return false;
    }
}
