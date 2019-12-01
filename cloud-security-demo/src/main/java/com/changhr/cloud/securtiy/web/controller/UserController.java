package com.changhr.cloud.securtiy.web.controller;

import com.changhr.cloud.securtiy.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author changhr
 */
@RestController
public class UserController {

    @GetMapping("/user")
    @JsonView(User.UserSimpleView.class)
    public List<User> queryUser() {

        ArrayList<User> users = new ArrayList<User>() {
            {
                add(new User("1", "Tom", "123"));

                add(new User("2", "Jerry", "456"));

                add(new User("3", "Marry", "789"));
            }
        };
        return users;
    }

    @GetMapping("/user/{userId:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getUserInfo(@PathVariable("userId") String userId) {
//        if (true) {
//            throw new UserNotExistException(userId);
//        }
        System.out.println("invoke user get info");
        return new User("1", "Tom", "123456");
    }

    @PostMapping("/user")
    public User create(@Valid @RequestBody User user) {
        System.out.println(user);
        user.setId("1");
        return user;
    }

    @PutMapping("/user/{userId:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String message = fieldError.getField() + " " + fieldError.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user);
        return user;
    }

    @DeleteMapping("/user/{userId:\\d+}")
    public Boolean delete(@PathVariable("userId") String userId) {
        System.out.println(userId);
        return true;
    }
}
