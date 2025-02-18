package org.example.web10_session_cookie;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/index.do","/test.do","/login.do","/logout.do","/loginOK.do","/logoutOK.do"})
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String sPath = request.getServletPath();
        System.out.println("===============");
        System.out.println(sPath);
        if(sPath.equals("/index.do")){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if(sPath.equals("/test.do")){
            //세션
            HttpSession session = request.getSession();
            System.out.println("session.getId() : "+session.getId());
            //JSESSIONID: 61D7F69B3BC84EE97260FBF89FDDBCE5
            // >> 브라우저 F12/응용프로그램/쿠키 항목에서 확인가능.

            System.out.println("sesion.isNew() : "+session.isNew()); //새로운 세션인지 확인

            //기본 세션 유지시간 확인(30분: 1800초)
            System.out.println("session.getMaxInactiveInterval() : "+session.getMaxInactiveInterval());

//            session.setMaxInactiveInterval(10); //세션 유지시간을 10초로 설정
//            System.out.println("session.getMaxInactiveInterval() : "+session.getMaxInactiveInterval());

            //로그인에 사용
            //세션에 정보 설정
            session.setAttribute("name","Jack");
            session.setAttribute("id","admin01");

            System.out.println("session.getAttribute(\"name\") : "+session.getAttribute("name")+"");
            System.out.println("session.getAttribute(\"id\") : "+session.getAttribute("id")+"");
            //로그아웃에 사용
            //세션제거1 - 대상제거
//            session.removeAttribute("name");
//            System.out.println("session.getAttribute(\"name\") : "+session.getAttribute("name")+"");
//            System.out.println("session.getAttribute(\"user_id\") : "+session.getAttribute("user_id")+"");

            //세션제거 2 - 모두제거
//            session.invalidate(); //getAttribute() 호출불가.
//            System.out.println("session.getAttribute(\"name\") : "+session.getAttribute("name")+"");
//            System.out.println("session.getAttribute(\"user_id\") : "+session.getAttribute("user_id")+"");






            request.getRequestDispatcher("test.jsp").forward(request,response);

        }else if(sPath.equals("/login.do")){
            request.setAttribute("logstatus","로그인을 해주세요");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else if(sPath.equals("/logout.do")){
            request.getRequestDispatcher("logout.jsp").forward(request,response);
        }else if(sPath.equals("/loginOK.do")){
            HttpSession session = request.getSession();
            String strId = request.getParameter("username");
            System.out.println("[" + strId + "]"); // 공백을 확인하기 위해 대괄호로 감싸 출력
            if(strId.equals("admin1")){
                System.out.println("loginOK success...");
                session.setMaxInactiveInterval(10);
                session.setAttribute("logstatus", "로그인 중");
                response.sendRedirect("index.do");
            } else {
                System.out.println("loginOK fail...");
                response.sendRedirect("login.do");
            }

        }else if(sPath.equals("/logoutOK.do")){
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.do");
        }

    }//end doGet()...
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }//end doPost()...
}