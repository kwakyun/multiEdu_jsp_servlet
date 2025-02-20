package org.example.web12_hr_dept_job_emp.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/d_insert.do","/d_insertOK.do","/d_update.do","/d_updateOK.do",
        "/d_delete.do","/d_deleteOK.do","/d_selectOne.do","/d_selectAll.do",
        "/d_searchList.do"})
public class DeptController extends HttpServlet {

    private DeptService service = new DeptService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("======================");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/d_insert.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/insert.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_insertOK.do")){
            String department_id = request.getParameter("department_id");
            String department_name = request.getParameter("department_name");
            String manager_id = request.getParameter("manager_id");
            String location_id = request.getParameter("location_id");
            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));
            vo.setDepartment_name(department_name);
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setLocation_id(Integer.parseInt(location_id));
            System.out.println(vo);

            int result = service.insert(vo);
            System.out.println("insert result:"+result);
            if(result == 1){
                response.sendRedirect("d_selectAll.do");
            }else{
                response.sendRedirect("d_insert.do");
            }
        }else if(sPath.equals("/d_selectAll.do")){

            List<DeptVO> vos = service.selectAll();

            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_selectOne.do")){

            String department_id = request.getParameter("department_id");

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));

            DeptVO vo2 = service.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectOne.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_update.do")){

            String department_id = request.getParameter("department_id");

            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));

            DeptVO vo2 = service.selectOne(vo);
            System.out.println(vo2);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("dept/update.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_updateOK.do")){
            String department_id = request.getParameter("department_id");
            String department_name = request.getParameter("department_name");
            String manager_id = request.getParameter("manager_id");
            String location_id = request.getParameter("location_id");
            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));
            vo.setDepartment_name(department_name);
            vo.setManager_id(Integer.parseInt(manager_id));
            vo.setLocation_id(Integer.parseInt(location_id));
            System.out.println(vo);

            int result = service.update(vo);
            System.out.println("update result:"+result);
            if(result == 1){
                response.sendRedirect("d_selectOne.do?department_id="+department_id);
            }else{
                response.sendRedirect("d_update.do?department_id="+department_id);
            }
        }else if(sPath.equals("/d_delete.do")){
            RequestDispatcher rd = request.getRequestDispatcher("dept/delete.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/d_deleteOK.do")){
            String department_id = request.getParameter("department_id");
            DeptVO vo = new DeptVO();
            vo.setDepartment_id(Integer.parseInt(department_id));

            int result = service.delete(vo);
            System.out.println("delete result:"+result);
            if(result == 1){
                response.sendRedirect("d_selectAll.do");
            }else{
                response.sendRedirect("d_delete.do?department_id="+department_id);
            }
        }else if(sPath.equals("/d_searchList.do")){

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<DeptVO> vos = service.searchList(searchKey, searchWord);

            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("dept/selectAll.jsp");
            rd.forward(request,response);
        }


    }//end doGet

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}