package org.example.web16_mvc_rest.member;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/json_idCheck.do","/json_m_selectAll.do","/json_m_selectOne.do",
"/json_m_searchList.do"})
public class MemberRestController extends HttpServlet {
    private MemberService service = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //응답객체에 다국어지원 인코딩 설정
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String sPath = request.getServletPath();
        System.out.println(sPath);

        if(sPath.equals("/json_idCheck.do")){

            String id = request.getParameter("id");
            System.out.println("id : "+id);
            MemberVO vo = new MemberVO();
            vo.setId(id);

            PrintWriter out = response.getWriter();

            Map<String,String> map = new HashMap<>();

            //service > dao > daoimple > return vo2
            //vo2 null일때(OK)와 ,그렇지않을때(Not OK) 분기문
            MemberVO vo2 = service.idCheck(vo);

            if(vo2 == null){
                map.put("result","OK");
            }else{
                map.put("result","Not OK");
            }
            out.append(new Gson().toJson(map));
        }else if(sPath.equals("/json_m_selectAll.do")){

            String cpage = request.getParameter("cpage")==null?"1":request.getParameter("cpage");
            String limit = request.getParameter("limit")==null?"10":request.getParameter("limit");
            System.out.println("cpage : " + cpage);
            System.out.println("limit : " + limit);

            List<MemberVO> vos = service.selectAll();

            PrintWriter out = response.getWriter();
            out.append(new Gson().toJson(vos));

        }else if(sPath.equals("/json_m_selectOne.do")){
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            MemberVO vo2 = service.selectOne(vo);

            PrintWriter out = response.getWriter();
            out.append(new Gson().toJson(vo2));
        }else if(sPath.equals("/json_m_searchList.do")){
            String cpage = request.getParameter("cpage")==null?"1":request.getParameter("cpage");
            String limit = request.getParameter("limit")==null?"10":request.getParameter("limit");
            System.out.println("cpage : " + cpage);
            System.out.println("limit : " + limit);

            String searchKey = request.getParameter("searchKey");
            String searchWord = request.getParameter("searchWord");
            System.out.println("searchKey : " + searchKey);
            System.out.println("searchWord : " + searchWord);

            List<MemberVO> vos = service.searchList(searchKey, searchWord);

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