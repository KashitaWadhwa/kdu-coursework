package com.kdu.dao;

import com.kdu.model.entity.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister,Long> {

    @Query
    Optional<UserRegister> findByUsername(String username);


}
