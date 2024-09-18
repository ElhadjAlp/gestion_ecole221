package com.ism.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;
    private boolean active;
    private Client client;

    public User() {
        this.active = true;
    }

    public User(String name, String surname, String login, String password, String role) {
        this();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}