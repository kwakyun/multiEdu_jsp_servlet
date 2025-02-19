package org.example.web12_hr_dept_job_emp.dept;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeptVO {
    private int department_id;
    private String department_name;
    private int manager_id;
    private int location_id;


}
