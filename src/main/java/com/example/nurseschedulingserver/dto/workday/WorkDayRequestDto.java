package com.example.nurseschedulingserver.dto.workday;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkDayRequestDto {
    private List<Date> workDate;
    private String month;
    private String year;
}
