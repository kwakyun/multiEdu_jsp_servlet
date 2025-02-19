package org.example.web10_session_cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/login.do","/loginOK.do","/logout.do"})
public class MemberController extends HttpServlet {

    private MemberService service = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sPath = request.getServletPath();
        System.out.println("================");
        System.out.println(sPath);
        if(sPath.equals("/login.do")){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else if(sPath.equals("/loginOK.do")){

            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            System.out.println("id:"+id+", pw:"+pw);


            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);

            //service > dao > daoimp > login검증 > MemberVO
            MemberVO vo2 = service.login(vo);
            System.out.println("vo2:"+vo2);

            if(vo2 != null){
                System.out.println("login success");
                HttpSession session = request.getSession();

                session.setAttribute("name", vo2.getName());
                session.setAttribute("id", vo2.getId());

                response.sendRedirect("index.do");
            }else{
                System.out.println("login fail");
                response.sendRedirect("login.do");
            }


        }else if(sPath.equals("/logout.do")){
            HttpSession session = request.getSession();
            //세션제거 모두제거
            session.invalidate();
            response.sendRedirect("index.do");
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}