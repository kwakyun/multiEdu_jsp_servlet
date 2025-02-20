package org.example.web12_hr_dept_job_emp.emp;


import java.util.List;

public class EmpPage {
    public int cpage(){
        EmpService service = new EmpService();
        int endPage = (int) Math.ceil(service.selectCount()/10.0);
        System.out.println("endPage =" + endPage);
        return endPage;
    }

    public List<EmpVO> spage(int page, int limit){
        EmpService service = new EmpService();
        return service.selectPage(page,limit);
    }
}
