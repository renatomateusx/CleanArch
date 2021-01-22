package com.renatomateusx.arch.ticket.dto;

import java.util.UUID;

public class TicketRequestWebDTO {

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



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String name;
    private String status;
    private String email;
    private String subject;
    private String message;

    public TicketRequestWebDTO(String email, String name, String status, String subject, String message){
        this.email  = email;
        this.name = name;
        this.status = status;
        this.subject = subject;
        this.message = message;
    }

    public TicketIn toInput(){
        return new TicketIn(UUID.randomUUID(), this.name, this.email, this.subject, this.message, this.status);
    }


}
