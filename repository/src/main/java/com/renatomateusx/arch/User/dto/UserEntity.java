package com.renatomateusx.arch.User.dto;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue
    private Long id_u;

    @NotNull
    @Column(name = "id")
    private UUID id;

    @NotNull
    @Column(name = "name")
    private String name;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String user_name) {
        this.name = user_name;
    }

    public UserOut toUserOut(){
        return new UserOut(this.getId(), this.getName());
    }
}
