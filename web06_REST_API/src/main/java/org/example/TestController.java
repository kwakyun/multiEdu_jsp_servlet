package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/index.do","/index_jquery.do"})
public class TestController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("============");
        String sPath = request.getServletPath();
        System.out.println("sPath:"+sPath);

        if(sPath.equals("/index.do")){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }else if(sPath.equals("/index_jquery.do")){
            RequestDispatcher rd = request.getRequestDispatcher("index_jquery.jsp");
            rd.forward(request,response);
        }

    }//end doGet()...

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException , ServletException {
        System.out.println("doPost().....");
        doGet(request,response);
    }
}
