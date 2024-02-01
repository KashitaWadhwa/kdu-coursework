package com.kdu.jpa.dao;

import com.kdu.jpa.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, UUID> {

    @Query("SELECT s FROM Shift s " +
            "WHERE s.dateStart = :dateStart " +
            "AND s.dateEnd = :dateEnd " +
            "ORDER BY s.name ASC " +
            "LIMIT 3")
    List<Shift> findTop3ShiftsByDateRange(
            @Param("dateStart") Date startDate,@Param("dateEnd") Date endDate
    );

}
