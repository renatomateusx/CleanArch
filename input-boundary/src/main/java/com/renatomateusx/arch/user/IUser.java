package com.renatomateusx.arch.user;

import com.renatomateusx.arch.user.dto.UserIn;

import java.util.List;
import java.util.UUID;

public interface IUser {
    UserIn getUserById(UUID id);
    void save(UserIn user);
    List<UserIn> getAll();
    String getConfig();
}
