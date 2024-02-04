package com.kdu.dao;

import com.kdu.model.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRegisterRepository extends JpaRepository<House,Long> {
}
