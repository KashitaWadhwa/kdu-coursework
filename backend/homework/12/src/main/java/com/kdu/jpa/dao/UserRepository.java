package com.kdu.jpa.dao;

import com.kdu.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Page<User> findAll(Pageable pageable);

    @Modifying
    @Query(value = "UPDATE users SET username = :username, time_zone = :timeZone WHERE id = :userId", nativeQuery = true)
    int updateUserDetails(UUID userId, String username, String timeZone);
}
