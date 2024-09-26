package com.kdu.jpa.service;

import com.kdu.jpa.dao.ShiftRepository;
import com.kdu.jpa.entity.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    @Autowired
    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public void saveShift(Shift shift) {
        shiftRepository.save(shift);
    }

    public List<Shift> findTop3ShiftsByDateRange(Date startDate, Date endDate) {
        return shiftRepository.findTop3ShiftsByDateRange(startDate, endDate);
    }
}
