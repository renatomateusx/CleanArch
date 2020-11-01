package com.renatomateusx.arch;

import com.renatomateusx.arch.user.IUser;
import com.renatomateusx.arch.user.dto.UserIn;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
class UserUseCase implements IUser {
    public UserUseCase(){    }


    @Override
    public UserIn getUserById(UserIn requestUserIn) {
        return new UserIn(UUID.randomUUID());
    }
}
