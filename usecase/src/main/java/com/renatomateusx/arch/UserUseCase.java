package com.renatomateusx.arch;

import com.renatomateusx.arch.User.IUserOut;
import com.renatomateusx.arch.ports.UserAdapter;
import com.renatomateusx.arch.user.IUser;
import com.renatomateusx.arch.user.dto.UserIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class UserUseCase implements IUser {
    public UserUseCase(){    }
    @Autowired
    private IUserOut userOut;
    @Autowired
    private UserAdapter userAdapter;


    @Override
    public UserIn getUserById(UUID id) {
        return userAdapter.toInput(userOut.findByUUID(id));
    }

    @Override
    public void save(UserIn user) {
        userOut.saveUser(userAdapter.toOutput(user));
    }

    @Override
    public List<UserIn> getAll() {
        return userAdapter.toInputList(userOut.getAll());
    }
}
