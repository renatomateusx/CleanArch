package com.renatomateusx.arch;

import com.renatomateusx.arch.User.IUserOut;
import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.ports.UserInToUserOut;
import com.renatomateusx.arch.ports.UserOutToUserIn;
import com.renatomateusx.arch.user.IUser;
import com.renatomateusx.arch.user.dto.UserIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UserUseCase implements IUser {
    public UserUseCase(){    }

    private IUserOut userOut;
    private UserInToUserOut userInOut;
    private UserOutToUserIn userOutIn;
    @Autowired
    UserUseCase(IUserOut iuser, UserInToUserOut userInOut, UserOutToUserIn userOutIn){
        this.userOut = iuser;
        this.userInOut = userInOut;
        this.userOutIn = userOutIn;
    }


    @Override
    public UserIn getUserById(UserIn requestUserIn) {
        return userOutIn.toInput(userOut.findByUsername(userInOut.toOutput(requestUserIn)));
    }
}
