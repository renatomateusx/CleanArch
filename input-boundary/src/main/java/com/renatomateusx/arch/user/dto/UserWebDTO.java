package com.renatomateusx.arch.user.dto;

import java.util.UUID;

public class UserWebDTO {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private UUID id;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    private String user_name;

    public UserWebDTO(UUID id, String user_name){
        this.id  = id;
        this.user_name = user_name;
    }


}
