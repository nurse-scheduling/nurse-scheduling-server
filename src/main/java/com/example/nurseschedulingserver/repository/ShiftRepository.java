package com.example.nurseschedulingserver.repository;

import com.example.nurseschedulingserver.dto.shift.ShiftDto;
import com.example.nurseschedulingserver.entity.shift.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, String> {
    @Query(nativeQuery = true ,
            value = "SELECT shifts.id as id, shifts.start_date as startDate, shifts.end_date as endDate, shifts.nurse_id as nurseId, " +
                    "nurses.first_name as nurseFirstName, nurses.last_name as nurseLastName " +
                    "FROM shifts " +
                    "INNER JOIN nurses " +
                    "ON shifts.nurse_id = nurses.id " +
                    "WHERE shifts.nurse_id = ?1 " +
                    "AND EXTRACT(MONTH FROM shifts.start_date) = ?2 " +
                    "AND EXTRACT(YEAR FROM shifts.start_date) = ?3 "
    )
    List<ShiftDto> findShiftsByNurseId(String nurseId, String month, String year);

}