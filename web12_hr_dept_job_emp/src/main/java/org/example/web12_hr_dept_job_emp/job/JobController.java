package org.example.web12_hr_dept_job_emp.job;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Collections;
import java.util.List;



    @WebServlet({"/j_insert.do", "/j_selectAll.do", "/j_selectOne.do",
            "/j_update.do", "/j_delete.do", "/j_searchList.do", "/j_insertOK.do"
            , "/j_updateOK.do", "/j_deleteOK.do"})
    public class JobController extends HttpServlet {

        private JobService service = new JobService();

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            System.out.println("=======================");

            String sPath = request.getServletPath();
            System.out.println(sPath);

            if (sPath.equals("/j_insert.do")) {
                RequestDispatcher rd = request.getRequestDispatcher("job/insert.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_selectAll.do")) {

                //end page 값 설정
                JobPage jpage = new JobPage();
                request.setAttribute("cpage", jpage.cpage());


                String limit = request.getParameter("limit");
                if (limit == null) {
                    limit = "10";
                }
                List<JobVO> sPageVos = jpage.spage(1, Integer.parseInt(limit));
                request.setAttribute("spageVos", sPageVos);

                if (request.getParameter("spage") != "1" && request.getParameter("spage") != null) {
                    String strSpage = (String) request.getParameter("spage");
                    sPageVos = jpage.spage(Integer.parseInt(strSpage), Integer.parseInt(limit));
                    Collections.reverse(sPageVos);
                    request.setAttribute("spageVos", sPageVos);
                    request.setAttribute("spage", strSpage);
                }

                List<JobVO> vos = service.selectAll();
                request.setAttribute("vos", vos);


                RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_selectOne.do")) {

                String job_id = request.getParameter("job_id");
                System.out.println(job_id);

                JobVO vo = new JobVO();
                vo.setJob_id(job_id);

                JobVO vo2 = service.selectOne(vo);

                request.setAttribute("vo2", vo2);

                RequestDispatcher rd = request.getRequestDispatcher("job/selectOne.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_update.do")) {
                String job_id = request.getParameter("job_id");
                System.out.println(job_id);

                JobVO vo = new JobVO();
                vo.setJob_id(job_id);

                JobVO vo2 = service.selectOne(vo);

                request.setAttribute("vo2", vo2);

                RequestDispatcher rd = request.getRequestDispatcher("job/update.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_delete.do")) {
                RequestDispatcher rd = request.getRequestDispatcher("job/delete.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_searchList.do")) {
                String searchKey = request.getParameter("searchKey");
                String searchWord = request.getParameter("searchWord");
                System.out.println(searchKey);
                System.out.println(searchWord);

                List<JobVO> vos = service.searchList(searchKey, searchWord);
                Collections.reverse(vos);
                request.setAttribute("vos", vos);

                RequestDispatcher rd = request.getRequestDispatcher("job/selectAll.jsp");
                rd.forward(request, response);
            } else if (sPath.equals("/j_insertOK.do")) {
                String job_id = request.getParameter("job_id");
                String job_title = request.getParameter("job_title");
                double min_salary = Double.parseDouble(request.getParameter("min_salary"));
                double max_salary = Double.parseDouble(request.getParameter("max_salary"));

                System.out.println(job_id);
                System.out.println(job_title);
                System.out.println(min_salary);
                System.out.println(max_salary);

                JobVO vo = new JobVO();
                vo.setJob_id(job_id);
                vo.setJob_title(job_title);
                vo.setMin_salary(min_salary);
                vo.setMax_salary(max_salary);

                int result = service.insert(vo);
                System.out.println("insert result : " + result);

                if (result == 1) {
                    System.out.println("insert successed...");
                    response.sendRedirect("index.do");
                } else {
                    System.out.println("insert failed...");
                    response.sendRedirect("m_insert.do");
                }

            } else if (sPath.equals("/j_updateOK.do")) {

                String job_id = request.getParameter("job_id");
                String job_title = request.getParameter("job_title");
                double min_salary = Double.parseDouble(request.getParameter("min_salary"));
                double max_salary = Double.parseDouble(request.getParameter("max_salary"));

                System.out.println(job_id);
                System.out.println(job_title);
                System.out.println(min_salary);
                System.out.println(max_salary);

                JobVO vo = new JobVO();
                vo.setJob_id(job_id);
                vo.setJob_title(job_title);
                vo.setMin_salary(min_salary);
                vo.setMax_salary(max_salary);


                int result = service.update(vo);
                System.out.println("update result : " + result);

                if (result == 1) {
                    System.out.println("update successed...");
                    response.sendRedirect("j_selectOne.do?job_id=" + job_id);
                } else {
                    System.out.println("update failed...");
                    response.sendRedirect("j_update.do?job_id=" + job_id);
                }

            } else if (sPath.equals("/j_deleteOK.do")) {
                String job_id = request.getParameter("job_id");
                System.out.println(job_id);

                JobVO vo = new JobVO();
                vo.setJob_id(job_id);

                int result = service.delete(vo);
                System.out.println("delete result : " + result);

                if (result == 1) {
                    System.out.println("delete successed...");
                    response.sendRedirect("index.do");
                } else {
                    System.out.println("delete failed...");
                    response.sendRedirect("j_delete.do?job_id=" + job_id);
                }

            }

        }//end doGet()....

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            doGet(request, response);
        }//end doPost()...
    }
