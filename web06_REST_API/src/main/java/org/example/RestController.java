package org.example;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet({"/test.do","/json_object.do","/json_array.do","/json_idCheck.do"})
public class RestController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/json");
        //크로스도메인 설정.
        response.setHeader("Access-Control-Allow-Origin","*");
        System.out.println("============");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/test.do")){
            PrintWriter out = response.getWriter();
            out.append("Hello 안녕~~");
            out.append("Hello 안녕~~");
            out.append("Hello 안녕~~");
            out.append("Hello 안녕~~");
        }else if(sPath.equals("/json_object.do")){
            PrintWriter out = response.getWriter();
            //json object : {"name":"kim","age":33}
            
            //service >> dao >> jdbc >> return TestVO
            TestVO vo2 = new TestVO("lee",22);
            
            //out.append("{\"name\":\"kim\",\"age\":33}");
            //out.append("{\"name\":\""+vo2.getName()+"\",\"age\":"+ vo2.getAge()+"}");
            //위와같이 객체로부터 JSON문자열에 정보를 할당하는 불편함을 해조해주는 라이브러리가 존재한다.
            //대표로 gson 또는 jackson 라이브러리등을 많이 사용한다.
            //https://mvnrepository.com/ >> gson검색 >> jar파일 다운로드 또는 maven카피.
            //pom.xml에 추가 및 업데이트

            out.append(new Gson().toJson(vo2));//객체를 json형식 문자열로 자동변환


        }else if(sPath.equals("/json_array.do")){
            PrintWriter out = response.getWriter();
            //json array : [{"name":"kim1","age":11},{"name":"kim2","age":22}]
            //out.append("[{\"name\":\"kim1\",\"age\":11},{\"name\":\"kim2\",\"age\":22}]");

            //service >> dao >> jdbc >> return List<TestVO>
            List<TestVO> vos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                TestVO vo = new TestVO("lee"+i,20+i);
                vos.add(vo);
            }

            out.append(new Gson().toJson(vos));//객체를 json형식 문자열로 자동변환

        }else if(sPath.equals("/json_idCheck.do")){

            String id = request.getParameter("id");
            System.out.println("id : "+id);

            PrintWriter out = response.getWriter();
            //json obj : {"result":"OK"} or {"result":"Not OK"}
            //out.append("{\"result\":\"OK\"}");

            Map<String,String> map = new HashMap<>();
            map.put("result","OK");
            out.append(new Gson().toJson(map));//객체를 json형식 문자열로 자동변환
        }

    }//end doGet()...

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doPost().....");
        doGet(request,response);
    }
}
