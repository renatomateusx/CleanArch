package com.renatomateusx.arch.ticket.dto;
import java.util.UUID;

public class TicketIn {

    private UUID id;
    private String name;
    private String email;
    private String subject;
    private String message;
    private String status;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public TicketIn(UUID id, String name, String email, String subject, String message, String status){
        this.id = id;
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.status = status;
    }

    public TicketWebDTO toWebDTO(){
        return new TicketWebDTO(this.id, this.name, this.status);
    }

}
