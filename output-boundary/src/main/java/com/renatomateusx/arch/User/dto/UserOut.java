package com.renatomateusx.arch.User.dto;

import java.util.UUID;

public class UserOut {
    public UserOut(Long id, UUID id_user, String user_name){
        this.id = id;
        this.id_user = id_user;
        this.user_name = user_name;
    }

    private Long id;
    private String user_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    private UUID id_user;
}
