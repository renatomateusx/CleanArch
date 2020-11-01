package com.renatomateusx.arch.user.dto;

import org.springframework.boot.context.properties.ConstructorBinding;


import java.util.UUID;
@ConstructorBinding
public class RequestUserWebDTO {

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    private UUID id_user;
    public RequestUserWebDTO(){}

    public UserIn toInput(){
        return new UserIn(this.id_user);
    }

}
