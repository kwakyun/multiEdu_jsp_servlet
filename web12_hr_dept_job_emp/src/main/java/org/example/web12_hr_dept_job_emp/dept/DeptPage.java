package org.example.web12_hr_dept_job_emp.dept;

import java.util.List;

public class DeptPage {

    public int cpage(){
        DeptService service = new DeptService();
        int endPage = (int) Math.ceil(service.selectCount()/10.0);
        System.out.println("endPage =" + endPage);
        return endPage;
    }

    public List<DeptVO> spage(int page, int limit){
        DeptService service = new DeptService();
        return service.selectPage(page,limit);
    }




}
