package com.kdu.dao;

import com.kdu.model.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeviceRegisterRepository extends JpaRepository<Device,Long> {
    @Query
    Optional<Device> findByKickstonId(String kickstonId);
}
