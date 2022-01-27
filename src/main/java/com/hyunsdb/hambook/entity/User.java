package com.hyunsdb.hambook.entity;

import com.hyunsdb.hambook.constant.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    private String name;

    private String email;

    private String password;

    private String picture;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User update(String name,String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    @Builder
    public User(Long uid, String name, String email, String password, String nickname, String picture, Role role) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.role = role;
    }
}
