package com.renatomateusx.arch.ports;

import com.renatomateusx.arch.User.dto.UserOut;
import com.renatomateusx.arch.user.dto.UserIn;
import com.renatomateusx.arch.user.dto.UserWebDTO;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@ConstructorBinding
public class UserAdapter{


    public UserOut toOutput(UserIn user){
        return new UserOut(user.getId(), user.getUser_name());
    }

    public List<UserIn> toInputList(List<UserOut> listOut){
        return listOut.stream().map(this::toInput).collect(Collectors.toList());
    }
    public UserIn toInput(UserOut user){
        return new UserIn(user.getId(), user.getUser_name());
    }


}
