package com.renatomateusx.arch.User.repository;

import com.renatomateusx.arch.User.dto.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findById(UUID id_user);
    UserEntity findByName(String user_name);
    List<UserEntity> findAll();
}
