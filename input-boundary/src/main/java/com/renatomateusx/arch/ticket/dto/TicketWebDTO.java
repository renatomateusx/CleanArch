package com.renatomateusx.arch.ticket.dto;

import java.util.UUID;

public class TicketWebDTO {


    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String name;
    private String status;

    public TicketWebDTO(UUID id, String name, String status){
        this.id  = id;
        this.name = name;
        this.status = status;
    }


}
