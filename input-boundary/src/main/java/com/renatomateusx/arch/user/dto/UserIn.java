package com.renatomateusx.arch.user.dto;

import java.util.UUID;

public class UserIn {
    private UUID id;

    public UserIn(UUID id){
        this.id  = id;
    }

    public UserWebDTO toWebDTO(){
        return new UserWebDTO(this.id);
    }

}
