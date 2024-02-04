package com.kdu.dao;

import com.kdu.model.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserModel,Long> {

    @Query
    Optional<UserModel> findByUsername(String username);


}
