package com.renatomateusx.arch.User;

import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserRepositoryImpl implements IUserOut {
    private UserRepository userRepo;
    @Autowired
    UserRepositoryImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserOut findByUUID(UserOut user) {
        return userRepo.findByUUID(user.getId_user()).toUserOut();
    }

    @Override
    public UserOut findByUsername(UserOut user) {
        return userRepo.findByUsername(user.getUser_name()).toUserOut();
    }

    @Override
    public void saveUser(UserOut user) {
        //userRepo.save(user)
    }
}
