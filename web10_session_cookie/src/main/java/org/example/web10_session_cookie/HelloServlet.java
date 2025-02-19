package org.example.web10_session_cookie;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/index.do","/test_session.do","/test_cookie.do"})
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("================");
        System.out.println(sPath);
        if(sPath.equals("/index.do")){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if(sPath.equals("/test_session.do")){
            //세션
            HttpSession session = request.getSession();
            System.out.println("session.getId() : " + session.getId());
            //JSESSIONID: E7112035E7B315BD473FC53F10E3F3E2
            // >> 브라우저 F12/응용프로그램/쿠키 항목에서 확인가능.

            System.out.println("session.isNew() : "+session.isNew());//새로운 세션인지 확인

            //기본 세션 유지시간 확인(30분:1800초)
            System.out.println("session.getMaxInactiveInterval() : "+session.getMaxInactiveInterval());

            //session.setMaxInactiveInterval(10);//세션 유지시간을 10초로 설정
            //System.out.println("session.getMaxInactiveInterval() : "+session.getMaxInactiveInterval());

            //로그인에 사용
            //세션에 정보 설정
            session.setAttribute("name", "kim1");
            session.setAttribute("id", "admin01");

            System.out.println("session.getAttribute(\"name\"):"+session.getAttribute("name"));
            System.out.println("session.getAttribute(\"user_id\"):"+session.getAttribute("user_id"));

            //로그아웃에 사용
            //세션제거 1 - 대상제거
//            session.removeAttribute("name");
//            System.out.println("session.getAttribute(\"name\"):"+session.getAttribute("name"));
//            System.out.println("session.getAttribute(\"user_id\"):"+session.getAttribute("user_id"));

            //세션제거 2 - 모두제거
            //session.invalidate();//getAttribute()호출불가.

            request.getRequestDispatcher("test_session.jsp").forward(request,response);
        }else if(sPath.equals("/test_cookie.do")){
            //쿠키 : 클라이언트(웹사용자) 브라우저에 저장가능
            Cookie cookie = new Cookie("message", "hello");//쿠키생성
            //쿠키객체를 생성 후 response객체에 쿠키추가하는 방식으로 처리
            response.addCookie(cookie);//쿠키추가
            
            //쿠키 등록 미션 - isChecked : true 설정값으로 쿠키등록 및 화면출력하기
            cookie = new Cookie("isChecked", "true");
            System.out.println(cookie.getMaxAge());//-1
            cookie.setMaxAge(5);//5초만 유지(새션과는 달리 브라우저 새로고침으로도 연장안됨.)
            //쿠키삭제는 유효시간을 0으로 설정하면 제거가된다.
            //cookie.setMaxAge(0);
            response.addCookie(cookie);

            response.sendRedirect("index.do");

        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}