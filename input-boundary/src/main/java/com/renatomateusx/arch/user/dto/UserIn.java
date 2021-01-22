package com.renatomateusx.arch.user.dto;

import java.util.List;
import java.util.UUID;

public class UserIn {

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

    public UserIn(UUID id, String user_name){
        this.id = id;
        this.user_name = user_name;
    }

    public UserWebDTO toWebDTO(){
        return new UserWebDTO(this.id, this.user_name);
    }

    public List<UserWebDTO> toWebDTOList(List<UserIn> listIn){
        return (List<UserWebDTO>) listIn.stream().map(userOut -> userOut.toWebDTO());
    }

}
