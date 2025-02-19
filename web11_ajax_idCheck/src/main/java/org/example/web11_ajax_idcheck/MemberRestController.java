package org.example.web11_ajax_idcheck;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet({"/json_idCheck.do"})
public class MemberRestController extends HttpServlet {
    private MemberService service = new MemberService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    public void destroy() {
    }
}