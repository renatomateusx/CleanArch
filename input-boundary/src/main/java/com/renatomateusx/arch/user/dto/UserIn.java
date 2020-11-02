package com.renatomateusx.arch.user.dto;

import java.util.UUID;

public class UserIn {
    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

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

    private UUID id_user;
    private Long id;
    private String user_name;

    public UserIn(Long id, UUID id_user, String user_name){
        this.id = id;
        this.id_user = id_user;
        this.user_name = user_name;
    }

    public UserWebDTO toWebDTO(){
        return new UserWebDTO(this.id_user);
    }

}
