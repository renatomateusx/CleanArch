package com.renatomateusx.arch;

import com.renatomateusx.arch.user.IUser;
import com.renatomateusx.arch.user.dto.RequestUserWebDTO;
import com.renatomateusx.arch.user.dto.UserIn;
import com.renatomateusx.arch.user.dto.UserWebDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/user")
@Api(value = "Users")
class UserController {
    public UserController(){}
    @Autowired
    private IUser user;

    @ApiOperation(value = "Get User by Id")
    @GetMapping("/{id}")
    public ResponseEntity<UserWebDTO> getUser(@PathVariable UUID id){
        return ResponseEntity.ok(user.getUserById(id).toWebDTO());
    }
    @ApiOperation(value = "Save user")
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody RequestUserWebDTO requestUserWebDTO){
        user.save(requestUserWebDTO.toInput());
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @ApiOperation(value = "Get All Users")
    @GetMapping("/all")
    public ResponseEntity<List<UserIn>> getAll(){
        return ResponseEntity.ok(user.getAll());
    }
}
