package org.example.web12_hr_dept_job_emp.emp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet({"/e_insert.do", "/e_selectAll.do", "/e_selectOne.do",
        "/e_update.do", "/e_delete.do", "/e_searchList.do", "/e_insertOK.do"
        , "/e_updateOK.do", "/e_deleteOK.do"})
public class EmpController extends HttpServlet {
    private EmpService service = new EmpService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("=======================");

        String sPath = request.getServletPath();
        System.out.println(sPath);

        if (sPath.equals("/e_insert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("emp/insert.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_selectAll.do")) {

            //end page 값 설정
            EmpPage epage = new EmpPage();
            request.setAttribute("cpage", epage.cpage());

            //selectPage 값 얻어서 설정
            String limit = request.getParameter("limit");
            if(limit == null){
                limit = "10";
            }
            List<EmpVO> sPageVos = epage.spage(1,Integer.parseInt(limit));
            request.setAttribute("spageVos", sPageVos);

            if(request.getParameter("spage") != "1" && request.getParameter("spage") != null){
                String strSpage = (String) request.getParameter("spage");
                sPageVos = epage.spage(Integer.parseInt(strSpage),Integer.parseInt(limit));
                Collections.reverse(sPageVos);
                request.setAttribute("spageVos", sPageVos);
                request.setAttribute("spage", strSpage);
            }

            List<EmpVO> vos = service.selectAll();
            request.setAttribute("vos", vos);


            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_selectOne.do")) {

            int employee_id = request.getParameter("employee_id") == null ? 0 : Integer.parseInt(request.getParameter("employee_id"));
            System.out.println(employee_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);

            EmpVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectOne.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_update.do")) {
            int employee_id = request.getParameter("employee_id") == null ? 0 : Integer.parseInt(request.getParameter("employee_id"));
            System.out.println(employee_id);

            EmpVO vo = new EmpVO();
            vo.setDepartment_id(employee_id);

            EmpVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("emp/update.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("emp/delete.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<EmpVO> vos = service.searchList(searchKey, searchWord);
            Collections.reverse(vos);
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("emp/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/e_insertOK.do")) {
            int employee_id = request.getParameter("employee_id") == null ? 0 : Integer.parseInt(request.getParameter("employee_id"));
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone_number = request.getParameter("phone_number");
            String hire_date = request.getParameter("hire_date");
            String job_id = request.getParameter("job_id");
            double salary = Double.parseDouble(request.getParameter("salary")) == 0 ? 0 : Double.parseDouble(request.getParameter("salary"));
            double commission_pct = Double.parseDouble(request.getParameter("commission_pct")) == 0 ? 0 : Double.parseDouble(request.getParameter("commission_pct"));
            int manager_id =  Integer.parseInt(request.getParameter("manager_id")) == 0 ? 0 : Integer.parseInt(request.getParameter("manager_id"));
            int department_id = Integer.parseInt(request.getParameter("department_id")) == 0 ? 0 : Integer.parseInt(request.getParameter("department_id"));

            System.out.println(employee_id);
            System.out.println(first_name);
            System.out.println(last_name);
            System.out.println(email);
            System.out.println(phone_number);
            System.out.println(hire_date);
            System.out.println(job_id);
            System.out.println(salary);
            System.out.println(commission_pct);
            System.out.println(manager_id);
            System.out.println(department_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);
            vo.setFirst_name(first_name);
            vo.setLast_name(last_name);
            vo.setEmail(email);
            vo.setPhone_number(phone_number);
            vo.setHire_date(hire_date);
            vo.setJob_id(job_id);
            vo.setSalary(salary);
            vo.setCommission_pct(commission_pct);
            vo.setManager_id(manager_id);
            vo.setDepartment_id(department_id);


            int result = service.insert(vo);
            System.out.println("insert result : " + result);

            if (result == 1) {
                System.out.println("insert successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("e_insert.do");
            }

        } else if (sPath.equals("/e_updateOK.do")) {
            int employee_id = request.getParameter("employee_id") == null ? 0 : Integer.parseInt(request.getParameter("employee_id"));
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String phone_number = request.getParameter("phone_number");
            String hire_date = request.getParameter("hire_date");
            String job_id = request.getParameter("job_id");
            double salary = Double.parseDouble(request.getParameter("salary")) == 0 ? 0 : Double.parseDouble(request.getParameter("salary"));
            double commission_pct = Double.parseDouble(request.getParameter("commission_pct")) == 0 ? 0 : Double.parseDouble(request.getParameter("commission_pct"));
            int manager_id =  Integer.parseInt(request.getParameter("manager_id")) == 0 ? 0 : Integer.parseInt(request.getParameter("manager_id"));
            int department_id = Integer.parseInt(request.getParameter("department_id")) == 0 ? 0 : Integer.parseInt(request.getParameter("department_id"));


            System.out.println(employee_id);
            System.out.println(first_name);
            System.out.println(last_name);
            System.out.println(email);
            System.out.println(phone_number);
            System.out.println(hire_date);
            System.out.println(job_id);
            System.out.println(salary);
            System.out.println(commission_pct);
            System.out.println(manager_id);
            System.out.println(department_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);
            vo.setFirst_name(first_name);
            vo.setLast_name(last_name);
            vo.setEmail(email);
            vo.setPhone_number(phone_number);
            vo.setHire_date(hire_date);
            vo.setJob_id(job_id);
            vo.setSalary(salary);
            vo.setCommission_pct(commission_pct);
            vo.setManager_id(manager_id);
            vo.setDepartment_id(department_id);


            int result = service.update(vo);
            System.out.println("update result : " + result);

            if (result == 1) {
                System.out.println("update successed...");
                response.sendRedirect("e_selectOne.do?employee_id=" + employee_id);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("e_update.do?employee_id=" + employee_id);
            }

        } else if (sPath.equals("/e_deleteOK.do")) {
            int employee_id = request.getParameter("employee_id") == null ? 0 : Integer.parseInt(request.getParameter("employee_id"));
            System.out.println(employee_id);

            EmpVO vo = new EmpVO();
            vo.setEmployee_id(employee_id);

            int result = service.delete(vo);
            System.out.println("delete result : " + result);

            if (result == 1) {
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("e_delete.do?employee_id=" + employee_id);
            }

        }

    }//end doGet()....

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
