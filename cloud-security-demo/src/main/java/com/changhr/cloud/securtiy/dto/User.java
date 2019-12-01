package com.changhr.cloud.securtiy.dto;

import com.changhr.cloud.securtiy.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * User 类
 *
 * @author changhr
 * @date 2019/6/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public interface UserSimpleView {
    }

    public interface UserDetailView extends UserSimpleView {
    }

    @JsonView(UserSimpleView.class)
    private String id;

    @MyConstraint(message = "这是一个测试")
    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须是过去的时间")
    @JsonView(UserSimpleView.class)
    private Date birthday;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
