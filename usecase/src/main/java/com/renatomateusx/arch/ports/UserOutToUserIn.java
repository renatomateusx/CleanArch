package com.renatomateusx.arch.ports;

import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.user.dto.UserIn;

import java.util.UUID;


public abstract class UserOutToUserIn {
    public UserIn toInput(UserOut user){
        return new UserIn(user.getId(), user.getId_user(), user.getUser_name());
    }
}
