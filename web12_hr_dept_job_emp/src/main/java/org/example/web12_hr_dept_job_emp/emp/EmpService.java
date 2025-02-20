package org.example.web12_hr_dept_job_emp.emp;

import java.util.List;

public class EmpService  {

    private EmpDAO dao = new EmpDAOimpl();

    public int insert(EmpVO vo) {
        return dao.insert(vo);
    }


    public int update(EmpVO vo) {
        return dao.update(vo);
    }


    public int delete(EmpVO vo) {
        return dao.delete(vo);
    }


    public EmpVO selectOne(EmpVO vo) {
        return dao.selectOne(vo);
    }


    public List<EmpVO> selectAll() {
        return dao.selectAll();
    }


    public List<EmpVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }
}
