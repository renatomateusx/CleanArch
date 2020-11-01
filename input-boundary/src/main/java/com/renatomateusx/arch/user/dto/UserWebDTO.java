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

    public UserWebDTO(UUID id){
        this.id  = id;
    }


}
