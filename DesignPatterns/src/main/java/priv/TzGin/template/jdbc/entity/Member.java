package priv.TzGin.template.jdbc.entity;

import lombok.Data;

@Data
public class Member {

    private String username;
    private String password;
    private String nickname;
    private int age;
    private String addr;
}
