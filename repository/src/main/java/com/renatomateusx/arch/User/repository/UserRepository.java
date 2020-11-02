package com.renatomateusx.arch.User.repository;

import com.renatomateusx.arch.User.dto.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUUID(UUID id_user);
    UserEntity findByUsername(String user_name);
}
