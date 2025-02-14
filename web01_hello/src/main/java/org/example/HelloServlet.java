package org.example;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/hello-servlet","/hello-jsp"})
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        if(request.getServletPath().equals("/hello-servlet")){
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>안녕하세요</h1>");
            out.println("</body></html>");
        }else if(request.getServletPath().equals("/hello-jsp")){
            RequestDispatcher rd= request.getRequestDispatcher("hello.jsp");
            rd.forward(request,response);
        }
    }//end doGet()
}

