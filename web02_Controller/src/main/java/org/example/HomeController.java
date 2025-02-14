package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/hello-servlet","/hello-jsp","/test","/test2.do","/index.do"})
public class HomeController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        System.out.println("==================");

        //서블릿패스 얻기.
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        //servletPath별 분기처리.
        if(sPath.equals("/hello-servlet")){
            PrintWriter out = response.getWriter();
            out.print("<html><body>");
            out.print("안녕하세요");
            out.print("안녕하세요");
            out.print("<h1>안녕하세요</h1>");
            out.print("</body></html>");
        }else if(sPath.equals("/hello-jsp")){

            //request attribute 설정(setAttribute(key,value))
            request.setAttribute("user_id","admin");

            RequestDispatcher rd= request.getRequestDispatcher("hello.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/test")){

            //request attribute 설정(setAttribute(key,value))
            request.setAttribute("user_id","admin");

            RequestDispatcher rd= request.getRequestDispatcher("test.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/test2.do")){

            System.out.println("helle test2.do");

            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String tel = request.getParameter("tel");
            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("tel:"+tel);

            //TestVO 클래스를 만드시고 값할당하기.
            TestVO vo = new TestVO();
            vo.setName(name);
            vo.setAge(Integer.parseInt(age));
            vo.setTel(tel);
            System.out.println(vo);

            //insert처리를 했다고 가정하고.
            int result = 1;
            if(result==1) {
                System.out.println("insert successed....");
                //index.jsp 페이지로 이동시키기.
                response.sendRedirect("index.do");//DML처리후 이동해야 될 서블릿패스 설정
            }else {
                System.out.println("insert failed....");
            }

        } else if (sPath.equals("/index.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
    }//end doGet()
}

