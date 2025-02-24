package org.example.web12_hr_dept_job_emp.emp;

import java.util.List;

public interface EmpDAO {
    public int insert(EmpVO vo);
    public int update(EmpVO vo);
    public int delete(EmpVO vo);
    public EmpVO selectOne(EmpVO vo);
    public List<EmpVO> selectAll();
    public List<EmpVO> searchList(String searchKey,String searchWord);


}
