package com.renatomateusx.user;

import com.renatomateusx.user.dto.RequestUserWebDTO;
import com.renatomateusx.user.dto.UserIn;

public interface IUser {
    UserIn getUserById(RequestUserWebDTO requestUserWebDTO);
}
