package org.example.web12_hr_dept_job_emp.emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpVO {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String hire_date;
    private String job_id;
    private double salary;
    private double commission_pct;
    private int manager_id;
    private int department_id;




}
