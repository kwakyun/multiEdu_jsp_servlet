package org.example.web12_hr_dept_job_emp.job;


import java.util.List;

public class JobService implements JobDAO {

    JobDAO dao = new JobDAOimpl();
    @Override
    public int insert(JobVO vo) {
        return dao.insert(vo);
    }

    @Override
    public int update(JobVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(JobVO vo) {
        return dao.delete(vo);
    }

    @Override
    public JobVO selectOne(JobVO vo) {
        return dao.selectOne(vo);
    }

    @Override
    public List<JobVO> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<JobVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey,searchWord);
    }

    @Override
    public int selectCount() {
        return dao.selectCount();
    }

    @Override
    public List<JobVO> selectPage(int page, int limit) {
        return dao.selectPage(page,limit);
    }
}
