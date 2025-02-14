package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//ServletPath등록(다른 컨트롤러에 있는 값들과도 유니크해야한다.)
@WebServlet({"/index.do","/insert.do","/insertOK.do",
        "/update.do","/updateOK.do",
        "/delete.do","/deleteOK.do",
        "/selectOne.do","/selectAll.do","/searchList.do"})
public class MemberController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("==================");

        //서블릿패스 얻기.
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/index.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/insert.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/update.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            //MemberVO >> set >> service >> dao >> jdbc >> return vo2

            MemberVO vo2 = new MemberVO(1,"admin1","hi1111","kim1","011");

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd= request.getRequestDispatcher("member/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/delete.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/selectOne.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            //MemberVO >> set >> service >> dao >> jdbc >> return vo2

            MemberVO vo2 = new MemberVO(1,"admin1","hi1111","kim1","011");

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd= request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/selectAll.do")) {

            String cpage = request.getParameter("cpage");
            String limit = request.getParameter("limit");
            System.out.println(cpage);
            System.out.println(limit);

            //service >> dao >> jdbc >> return vos
            List<MemberVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                MemberVO vo = new MemberVO(1+i,"admin"+(1+i),"hi1111"+(1+i),"kim"+(1+i),"011"+(1+i));
                vos.add(vo);
            }

            request.setAttribute("vos",vos);

            RequestDispatcher rd= request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            //service >> dao >> jdbc >> return vos
            List<MemberVO> vos = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                MemberVO vo = new MemberVO(1+i,"admin"+(1+i),"hi1111"+(1+i),"kim"+(1+i),"011"+(1+i));
                vos.add(vo);
            }
            request.setAttribute("vos",vos);

            RequestDispatcher rd= request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            //MemberVO >> set >> service >> dao >> jdbc >> return 1,0

            int result = 1;
            if(result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("delete.do?num="+num);
            }

        }else if (sPath.equals("/insertOK.do")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);

            //MemberVO >> set >> service >> dao >> jdbc >> return 1,0

            int result = 1;
            if(result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("index.do");
            }else{
                System.out.println("insert failed...");
                response.sendRedirect("insert.do");
            }

        }else if (sPath.equals("/updateOK.do")) {
            String num = request.getParameter("num");
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            System.out.println(num);
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);

            //MemberVO >> set >> service >> dao >> jdbc >> return 1,0

            int result = 1;
            if(result == 1){
                System.out.println("update successed...");
                response.sendRedirect("index.do");
            }else{
                System.out.println("update failed...");
                response.sendRedirect("update.do?num="+num);
            }

        }
    }//end doGet()

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doPost()...");
        doGet(request,response);
    }


}//end class

