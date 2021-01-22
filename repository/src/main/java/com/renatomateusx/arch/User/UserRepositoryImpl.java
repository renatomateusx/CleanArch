package com.renatomateusx.arch.User;

import com.renatomateusx.arch.User.dto.UserEntity;
import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserRepositoryImpl implements IUserOut {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserOut findByUUID(UUID id) {
        return userRepo.findById(id).toUserOut();
    }

    @Override
    public UserOut findByUsername(UserOut user) {
        return userRepo.findByName(user.getUser_name()).toUserOut();
    }

    @Override
    public void saveUser(UserOut user) {
        UserEntity userE = new UserEntity();
        userE.setId(user.getId());
        userE.setName(user.getUser_name());
        userRepo.save(userE);
    }

    @Override
    public List<UserOut> getAll() {
        List<UserEntity> userE = userRepo.findAll();
        return userE.stream()
                .map(user -> new UserOut(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }
}
