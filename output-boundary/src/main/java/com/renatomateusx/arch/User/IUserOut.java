package com.renatomateusx.arch.User;

import com.renatomateusx.arch.User.dto.UserOut;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
@Component
@RefreshScope
public interface IUserOut {
    UserOut findByUUID(UUID id);
    UserOut findByUsername(UserOut user);
    void saveUser(UserOut user);
    List<UserOut> getAll();
}
