package org.example.web12_hr_dept_job_emp.job;

import org.example.web12_hr_dept_job_emp.dept.DeptDAO;
import org.example.web12_hr_dept_job_emp.dept.DeptDAOimpl;

import java.util.List;

public class JobService {

    private JobDAO dao = new JobDAOimpl();

    public int insert(JobVO vo) {
        return dao.insert(vo);
    }

    
    public int update(JobVO vo) {
        return dao.update(vo);
    }

    
    public int delete(JobVO vo) {
        return dao.delete(vo);
    }

    
    public JobVO selectOne(JobVO vo) {
        return dao.selectOne(vo);
    }

    
    public List<JobVO> selectAll() {
        return dao.selectAll();
    }

    
    public List<JobVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }
}
