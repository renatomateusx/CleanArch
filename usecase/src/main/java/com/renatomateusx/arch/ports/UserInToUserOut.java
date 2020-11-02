package com.renatomateusx.arch.ports;

import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.user.dto.UserIn;

import java.util.UUID;


public class UserInToUserOut extends UserOut{
    public UserInToUserOut(Long id, UUID id_user, String user_name) {
        super(id, id_user, user_name);
    }

    public UserOut toOutput(UserIn user){
        return new UserOut(user.getId(), user.getId_user(), user.getUser_name());
    }

}
