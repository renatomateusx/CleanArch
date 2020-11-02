package com.renatomateusx.arch.user.dto;

import org.springframework.boot.context.properties.ConstructorBinding;


import java.util.UUID;
@ConstructorBinding
public class RequestUserWebDTO {

    public UUID getId_user() {
        return id;
    }

    public void setId_user(UUID id_user) {
        this.id = id_user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    private UUID id;
    private String user_name;
    public RequestUserWebDTO(){}

    public UserIn toInput(){
        return new UserIn(this.id, this.user_name);
    }

}
