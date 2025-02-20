package org.example.web12_hr_dept_job_emp.job;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/j_insert.do","/j_insertOK.do","/j_update.do","/j_updateOK.do",
        "/j_delete.do","/j_deleteOK.do","/j_selectOne.do","/j_selectAll.do",
        "/j_searchList.do"})
public class JobController extends HttpServlet {

    private JobService service = new JobService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("======================");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/j_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("job/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/j_insertOK.do")){
            String job_id = request.getParameter("job_id");
            String job_title = request.getParameter("job_title");
            String min_salary = request.getParameter("min_salary");
            String max_salary = request.getParameter("max_salary");
            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            vo.setJob_title(job_title);
            vo.setMin_salary(Integer.parseInt(min_salary));
            vo.setMax_salary(Integer.parseInt(max_salary));

            System.out.println(vo);

            int result = service.insert(vo);
            System.out.println("insert result:"+result);
            if(result == 1){
                response.sendRedirect("j_selectAll.do");
            }else{
                response.sendRedirect("j_insert.do");
            }
        }else if(sPath.equals("/j_selectAll.do")){

            List<JobVO> vos = service.selectAll();

            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/j_selectOne.do")){

            String job_id = request.getParameter("job_id");

            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            System.out.println(vo);

            JobVO vo2 = service.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("job/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/j_update.do")){

            String job_id = request.getParameter("job_id");
            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            System.out.println(vo);

            JobVO vo2 = service.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("job/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/j_updateOK.do")){
            String job_id = request.getParameter("job_id");
            String job_title = request.getParameter("job_title");
            String min_salary = request.getParameter("min_salary");
            String max_salary = request.getParameter("max_salary");
            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            vo.setJob_title(job_title);
            vo.setMin_salary(Integer.parseInt(min_salary));
            vo.setMax_salary(Integer.parseInt(max_salary));
            System.out.println(vo);

            int result = service.update(vo);
            System.out.println("update result:"+result);
            if(result == 1){
                response.sendRedirect("j_selectOne.do?job_id="+job_id);
            }else{
                response.sendRedirect("j_update.do?job_id="+job_id);
            }
        }else if(sPath.equals("/j_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("job/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/j_deleteOK.do")){
            String job_id = request.getParameter("job_id");
            JobVO vo = new JobVO();
            vo.setJob_id(job_id);
            System.out.println(vo);

            int result = service.delete(vo);
            System.out.println("delete result:"+result);
            if(result == 1){
                response.sendRedirect("j_selectAll.do");
            }else{
                response.sendRedirect("j_delete.do?job_id="+job_id);
            }
        }else if(sPath.equals("/j_searchList.do")){

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<JobVO> vos = service.searchList(searchKey, searchWord);

            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
            rd.forward(request,response);
        }


    }//end doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}