package org.example.web09_mvc_jdbc.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet({"/m_insert.do", "/m_selectAll.do", "/m_selectOne.do",
        "/m_update.do", "/m_delete.do", "/m_searchList.do", "/m_insertOK.do"
        , "/m_updateOK.do", "/m_deleteOK.do"})
public class MemberController extends HttpServlet {

    private MemberService service = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("=======================");

        String sPath = request.getServletPath();
        System.out.println(sPath);

        if (sPath.equals("/m_insert.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_selectAll.do")) {

            //end page 값 설정
            MemberPage mpage = new MemberPage();
            request.setAttribute("cpage", mpage.cpage());

            //selectPage 값 얻어서 설정
            String limit = request.getParameter("limit");
            if(limit == null){
                limit = "10";
            }
            List<MemberVO> sPageVos = mpage.spage(1,Integer.parseInt(limit));
            request.setAttribute("spageVos", sPageVos);

            if(request.getParameter("spage") != "1" && request.getParameter("spage") != null){
                String strSpage = (String) request.getParameter("spage");
                sPageVos = mpage.spage(Integer.parseInt(strSpage),Integer.parseInt(limit));
                Collections.reverse(sPageVos);
                request.setAttribute("spageVos", sPageVos);
                request.setAttribute("spage", strSpage);
            }

            List<MemberVO> vos = service.selectAll();
            request.setAttribute("vos", vos);


            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_selectOne.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectOne.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_update.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2", vo2);

            RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_delete.do")) {
            RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<MemberVO> vos = service.searchList(searchKey, searchWord);
            Collections.reverse(vos);
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_insertOK.do")) {
            String id = request.getParameter("id");
            String pw = request.getParameter("pw");
            String name = request.getParameter("name");
            String tel = request.getParameter("tel");
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = service.insert(vo);
            System.out.println("insert result : " + result);

            if (result == 1) {
                System.out.println("insert successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("m_insert.do");
            }

        } else if (sPath.equals("/m_updateOK.do")) {
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

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);

            int result = service.update(vo);
            System.out.println("update result : " + result);

            if (result == 1) {
                System.out.println("update successed...");
                response.sendRedirect("m_selectOne.do?num=" + num);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("m_update.do?num=" + num);
            }

        } else if (sPath.equals("/m_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            int result = service.delete(vo);
            System.out.println("delete result : " + result);

            if (result == 1) {
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("delete failed...");
                response.sendRedirect("m_delete.do?num=" + num);
            }

        }

    }//end doGet()....

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}