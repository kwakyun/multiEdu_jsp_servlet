package org.example.web12_hr_dept_job_emp.emp;

import java.util.List;

public class EmpService implements EmpDAO {
    EmpDAO dao = new EmpDAOimpl();
    @Override
    public int insert(EmpVO vo) {
        return dao.insert(vo);
    }

    @Override
    public int update(EmpVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(EmpVO vo) {
        return dao.delete(vo);
    }

    @Override
    public EmpVO selectOne(EmpVO vo) {
        return dao.selectOne(vo);
    }

    @Override
    public List<EmpVO> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<EmpVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey,searchWord);
    }
}
