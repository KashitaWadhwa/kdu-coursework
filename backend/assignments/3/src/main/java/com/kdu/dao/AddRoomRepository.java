package com.kdu.dao;

import com.kdu.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRoomRepository extends JpaRepository<Room,Long> {
}
