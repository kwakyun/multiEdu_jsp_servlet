package org.example.web16_mvc_rest.board;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.web16_mvc_rest.member.MemberService;
import org.example.web16_mvc_rest.member.MemberVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/json_b_selectAll.do","/json_b_selectOne.do",
"/json_b_searchList.do"})
public class BoardRestController extends HttpServlet {
    private BoardService service = new BoardService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //응답객체에 다국어지원 인코딩 설정
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String sPath = request.getServletPath();
        System.out.println(sPath);

        if(sPath.equals("/json_b_selectAll.do")){

            String cpage = request.getParameter("cpage")==null?"1":request.getParameter("cpage");
            String limit = request.getParameter("limit")==null?"10":request.getParameter("limit");
            System.out.println("cpage : " + cpage);
            System.out.println("limit : " + limit);

            List<BoardVO> vos = service.selectAll();

            PrintWriter out = response.getWriter();
            out.append(new Gson().toJson(vos));

        }else if(sPath.equals("/json_b_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));

            BoardVO vo2 = service.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.append(new Gson().toJson(vo2));

        }else if(sPath.equals("/json_b_searchList.do")){
            String cpage = request.getParameter("cpage")==null?"1":request.getParameter("cpage");
            String limit = request.getParameter("limit")==null?"10":request.getParameter("limit");
            System.out.println("cpage : " + cpage);
            System.out.println("limit : " + limit);

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println("searchKey : " + searchKey);
            System.out.println("searchWord : " + searchWord);

            List<BoardVO> vos = service.searchList(searchKey, searchWord);

            PrintWriter out = response.getWriter();
            out.append(new Gson().toJson(vos));

        }

    }//end doGet....

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}