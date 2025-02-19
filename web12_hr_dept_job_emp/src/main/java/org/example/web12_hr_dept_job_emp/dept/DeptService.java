package org.example.web12_hr_dept_job_emp.dept;

import java.util.List;

public class DeptService implements DeptDAO {
    DeptDAO dao = new DeptDAOimpl();

    public int insert(DeptVO vo) {
        return dao.insert(vo);
    }


    public int update(DeptVO vo) {
        return dao.update(vo);
    }


    public int delete(DeptVO vo) {
        return dao.delete(vo);
    }


    public DeptVO selectOne(DeptVO vo) {
        return dao.selectOne(vo);
    }


    public List<DeptVO> selectAll() {
        return dao.selectAll();
    }


    public List<DeptVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }
    public int selectCount () {
        return dao.selectCount();
    }

    @Override
    public List<DeptVO> selectPage(int page, int limit) {
        return dao.selectPage(page,limit);
    }
}
