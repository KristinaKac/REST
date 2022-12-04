package ru.netology.demo1.model;

import java.util.List;

public class User {
    private String userName;
    private String password;
    List<Authorities> authorities;

    public User(String userName, String password, List<Authorities> authorities){
        this.userName=userName;
        this.password=password;
        this.authorities=authorities;
    }

    public String getUser() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }
}
