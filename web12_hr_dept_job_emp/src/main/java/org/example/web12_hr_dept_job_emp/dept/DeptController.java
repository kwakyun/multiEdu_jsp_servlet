package org.example.web12_hr_dept_job_emp.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet({"/d_insert.do", "/d_selectAll.do", "/d_selectOne.do",
        "/d_update.do", "/d_delete.do", "/d_searchList.do", "/d_insertOK.do"
        , "/d_updateOK.do", "/d_deleteOK.do"})
public class DeptController extends HttpServlet {

    private DeptService service = new DeptService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("=======================");

        String sPath = request.getServletPath();
        System.out.println(sPath);

        if (sPath.equals("/d_insert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("dept/insert.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_selectAll.do")) {

            //end page 값 설정
            DeptPage mpage = new DeptPage();
            request.setAttribute("cpage", mpage.cpage());

            //selectPage 값 얻어서 설정
            String limit = request.getParameter("limit");
            if(limit == null){
                limit = "10";
            }
            List<DeptVO> sPageVos = mpage.spage(1,Integer.parseInt(limit));
            request.setAttribute("spageVos", sPageVos);

            if(request.getParameter("spage") != "1" && request.getParameter("spage") != null){
                String strSpage = (String) request.getParameter("spage");
                sPageVos = mpage.spage(Integer.parseInt(strSpage),Integer.parseInt(limit));
                Collections.reverse(sPageVos);
                request.setAttribute("spageVos", sPageVos);
                request.setAttribute("spage", strSpage);
            }

            List<DeptVO> vos = service.selectAll();
            request.setAttribute("vos", vos);


            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_selectOne.do")) {

            int department_id = request.getParameter("department_id") == null ? 0 : Integer.parseInt(request.getParameter("department_id"));
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            DeptVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectOne.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_update.do")) {
            int department_id = request.getParameter("department_id") == null ? 0 : Integer.parseInt(request.getParameter("department_id"));
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            DeptVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/update.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("dept/delete.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<DeptVO> vos = service.searchList(searchKey, searchWord);
            Collections.reverse(vos);
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/d_insertOK.do")) {
            int department_id = request.getParameter("department_id") == null ? 0 : Integer.parseInt(request.getParameter("department_id"));
            String department_name = request.getParameter("department_name");
            int manager_id = request.getParameter("manager_id") == null ? 0 : Integer.parseInt(request.getParameter("manager_id"));
            int location_id = request.getParameter("location_id") == null ? 0 : Integer.parseInt(request.getParameter("location_id"));
            System.out.println(department_id);
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);
            vo.setDepartment_name(department_name);
            vo.setManager_id(manager_id);
            vo.setLocation_id(location_id);

            int result = service.insert(vo);
            System.out.println("insert result : " + result);

            if (result == 1) {
                System.out.println("insert successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("m_insert.do");
            }

        } else if (sPath.equals("/d_updateOK.do")) {

            int department_id = request.getParameter("department_id") == null ? 0 : Integer.parseInt(request.getParameter("department_id"));
            String department_name = request.getParameter("department_name");
            int manager_id = request.getParameter("manager_id") == null ? 0 : Integer.parseInt(request.getParameter("manager_id"));
            int location_id = request.getParameter("location_id") == null ? 0 : Integer.parseInt(request.getParameter("location_id"));
            System.out.println(department_id);
            System.out.println(department_name);
            System.out.println(manager_id);
            System.out.println(location_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);
            vo.setDepartment_name(department_name);
            vo.setManager_id(manager_id);
            vo.setLocation_id(location_id);


            int result = service.update(vo);
            System.out.println("update result : " + result);

            if (result == 1) {
                System.out.println("update successed...");
                response.sendRedirect("d_selectOne.do?department_id=" + department_id);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("d_update.do?department_id=" + department_id);
            }

        } else if (sPath.equals("/d_deleteOK.do")) {
            int department_id = request.getParameter("department_id") == null ? 0 : Integer.parseInt(request.getParameter("department_id"));
            System.out.println(department_id);

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(department_id);

            int result = service.delete(vo);
            System.out.println("delete result : " + result);

            if (result == 1) {
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("d_delete.do?department_id=" + department_id);
            }

        }

    }//end doGet()....

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}