package com.renatomateusx.arch.User.dto;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class UserEntity {


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private UUID id_user;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @NotNull
    private String user_name;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }



    public UserOut toUserOut(){
        return new UserOut(this.getId(), this.getUser_name(), this.getId_user());
    }
}
