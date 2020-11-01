package com.renatomateusx.arch;

import com.renatomateusx.arch.user.IUser;
import com.renatomateusx.arch.user.dto.UserWebDTO;
import com.renatomateusx.arch.user.dto.RequestUserWebDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
class UserController {
    private IUser user;
    @Autowired
    public UserController(IUser user){
        this.user = user;
    }


    @PostMapping("/post")
    public ResponseEntity<UserWebDTO> getUser(@RequestBody RequestUserWebDTO requestUserWebDTO){
        return ResponseEntity.ok(user.getUserById(requestUserWebDTO.toInput()).toWebDTO());
    }
}
