package com.renatomateusx.arch.User;

import com.renatomateusx.arch.User.dto.UserOut;

import java.util.UUID;

public interface IUserOut {
    UserOut findByUUID(UserOut user);
    UserOut findByUsername(UserOut user);
    void saveUser(UserOut user);
}
