package com.renatomateusx.user.dto;

import java.util.UUID;

public class RequestUserWebDTO {

    private UUID id_usuario;
    public RequestUserWebDTO(UUID id){
        this.id_usuario = id;
    }

    public RequestUserWebDTO toInput(){
        return UserIn(this.id_usuario);
    }

}
