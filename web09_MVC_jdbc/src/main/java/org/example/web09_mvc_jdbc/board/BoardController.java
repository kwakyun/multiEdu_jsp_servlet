package org.example.web09_mvc_jdbc.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet({"/b_insert.do","/b_insertOK.do",
        "/b_update.do","/b_updateOK.do",
        "/b_delete.do","/b_deleteOK.do",
        "/b_selectOne.do","/b_selectAll.do","/b_searchList.do"})
public class BoardController extends HttpServlet {

    private BoardService service = new BoardService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("==================");

        //서블릿패스 얻기.
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if (sPath.equals("/b_insert.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("board/insert.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_update.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd= request.getRequestDispatcher("board/update.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_delete.do")) {
            RequestDispatcher rd= request.getRequestDispatcher("board/delete.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectOne.do")) {

            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2 = service.selectOne(vo);

            request.setAttribute("vo2",vo2);

            RequestDispatcher rd= request.getRequestDispatcher("board/selectOne.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_selectAll.do")) {

            //end page 값 설정
            BoardPage bpage = new BoardPage();
            request.setAttribute("cpage", bpage.cpage());

            //selectPage 값 얻어서 설정

            String limit = request.getParameter("limit");
            if(limit == null){
                limit = "10";
            }

            List<BoardVO> sPageVos = bpage.spage(1,Integer.parseInt(limit));
            request.setAttribute("spageVos", sPageVos);

            if(request.getParameter("spage") != "1" && request.getParameter("spage") != null){
                String strSpage = (String) request.getParameter("spage");
                sPageVos = bpage.spage(Integer.parseInt(strSpage),Integer.parseInt(limit));
                Collections.reverse(sPageVos);
                request.setAttribute("spageVos", sPageVos);
                request.setAttribute("spage", strSpage);
            }

            List<BoardVO> vos = service.selectAll();
            request.setAttribute("vos", vos);


            RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request, response);
        }else if (sPath.equals("/b_searchList.do")) {
            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println(searchKey);
            System.out.println(searchWord);

            List<BoardVO> vos = service.searchList(searchKey,searchWord);

            request.setAttribute("vos",vos);

            RequestDispatcher rd= request.getRequestDispatcher("board/selectAll.jsp");
            rd.forward(request,response);
        }else if (sPath.equals("/b_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            int result = service.delete(vo);
            System.out.println("delete result:"+result);

            if(result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("b_delete.do?num="+num);
            }

        }else if (sPath.equals("/b_insertOK.do")) {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = service.insert(vo);
            System.out.println("insert result:"+result);

            if(result == 1){
                System.out.println("insert successed...");
                response.sendRedirect("b_selectAll.do");
            }else{
                System.out.println("insert failed...");
                response.sendRedirect("b_insert.do");
            }

        }else if (sPath.equals("/b_updateOK.do")) {
            String num = request.getParameter("num");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String writer = request.getParameter("writer");

            System.out.println(num);
            System.out.println(title);
            System.out.println(content);
            System.out.println(writer);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);

            int result = service.update(vo);
            System.out.println("update result:"+result);

            if(result == 1){
                System.out.println("update successed...");
                response.sendRedirect("b_selectOne.do?num="+num);
            }else{
                System.out.println("update failed...");
                response.sendRedirect("b_update.do?num="+num);
            }

        }
    }//end doGet()

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doPost().....");

        doGet(request,response);


    }


}//end class

