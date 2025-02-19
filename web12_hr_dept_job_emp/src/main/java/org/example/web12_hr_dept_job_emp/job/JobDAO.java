package org.example.web12_hr_dept_job_emp.job;

import org.example.web12_hr_dept_job_emp.dept.DeptVO;

import java.util.List;

public interface JobDAO {
    public int insert(JobVO vo);
    public int update(JobVO vo);
    public int delete(JobVO vo);
    public JobVO selectOne(JobVO vo);
    public List<JobVO> selectAll();
    public List<JobVO>  searchList(String searchKey, String searchWord);

    public int selectCount();
    public List<JobVO> selectPage(int page, int limit);
}
