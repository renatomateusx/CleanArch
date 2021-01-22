package com.renatomateusx.arch.User.dto;

import java.util.UUID;

public class UserOut {
    public UserOut(UUID id, String user_name){
        this.id = id;
        this.user_name = user_name;
    }

    private UUID id;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
