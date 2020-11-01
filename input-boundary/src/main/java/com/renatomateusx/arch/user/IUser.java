package com.renatomateusx.arch.user;

import com.renatomateusx.arch.user.dto.UserIn;

public interface IUser {
    UserIn getUserById(UserIn requestUserIn);
}
