package org.example.web12_hr_dept_job_emp.dept;

import java.util.List;

public interface DeptDAO {

    public int insert(DeptVO vo);
    public int update(DeptVO vo);
    public int delete(DeptVO vo);
    public DeptVO selectOne(DeptVO vo);
    public List<DeptVO> selectAll();
    public List<DeptVO> searchList(String searchKey,String searchWord);

}
