package org.example.web12_hr_dept_job_emp.job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobVO {
    private String job_id;
    private String job_title;
    private double min_salary;
    private double max_salary;
}
