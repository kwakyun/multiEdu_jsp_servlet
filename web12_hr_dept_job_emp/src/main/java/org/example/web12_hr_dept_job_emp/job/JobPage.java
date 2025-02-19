package org.example.web12_hr_dept_job_emp.job;

import java.util.List;

public class JobPage {


    public int cpage(){
        JobService service = new JobService();
        int endPage = (int) Math.ceil(service.selectCount()/10.0);
        System.out.println("endPage =" + endPage);
        return endPage;
    }

    public List<JobVO> spage(int page, int limit){
        JobService service = new JobService();
        return service.selectPage(page,limit);
    }
}
