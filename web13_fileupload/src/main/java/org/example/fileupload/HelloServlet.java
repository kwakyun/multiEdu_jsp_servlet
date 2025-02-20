package org.example.fileupload;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

@WebServlet({"/index.do","/fileUpload.do","/selectAll.do"})
public class HelloServlet extends HttpServlet {

    private TestService service = new TestService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("==============");
        String sPath = request.getServletPath();
        System.out.println(sPath);
        if (sPath.equals("/index.do")) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else if (sPath.equals("/fileUpload.do")) {
            System.out.println("fileUpload 처리중.....");
            //한글 깨짐 방지 인코딩 추가방법
//        인텔리제이 > 상단 tomcat > Edit configurations > VM option
//        -Dfile.encoding=UTF-8

            String name = "";
            int age = 0;
            String imgName = "default.png";

            //form전송시 encType설정 멀티파트형식일 때 : true
            System.out.println(JakartaServletFileUpload.isMultipartContent(request));

            if(JakartaServletFileUpload.isMultipartContent(request)){
                //업로드파일 객체 설정
                DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
                JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
                upload.setFileSizeMax(1024 * 1024 * 100);//파일 최대사이즈 제한

                //요청(request)으로부터 파일아이템들을 파싱
                List<FileItem> items = upload.parseRequest(request);

                //반복문으로 파일정보와 파라메터 정보획득
                for (FileItem item : items) {
                    System.out.println(item);
                    if (item.isFormField()) {
                        if(item.getFieldName().equals("name")){
                            name = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if(item.getFieldName().equals("age")){
                            age = Integer.parseInt(item.getString());//33
                        }
                    }else{
                        System.out.println(item.getName());
                        String originName = item.getName();
                        if(originName.length() > 0){
                            //이미지이름을 유니크하게 변경해줘야한다.
                            String temp = originName.substring(0,originName.lastIndexOf("."))+"_"+System.currentTimeMillis();
                            System.out.println(temp);//0112_893057340915154
                            String format_type = originName.substring(originName.lastIndexOf("."));//.png
                            System.out.println(format_type);
                            imgName = temp + format_type;//0112_893057340915154 + .png



                            System.out.println("====================");
                            //이미지저장
                            //이미지 저장할 폴더 찾기(리얼패스)
                            //프로젝트경로가아니고 배포경로를 의미한다.
                            String dir_path = request.getServletContext().getRealPath("/upload");
                            System.out.println(dir_path);//C:\\MULTI_EDU_01\\web\\work\\web13_fileupload\\target\\fileupload-1.0-SNAPSHOT\\upload

                            //경로 + 파일명 >> 이미저장됨.
                            item.write(new File(dir_path,imgName).toPath());

                        }
                    }
                }
                System.out.println(name);
                System.out.println(age);
                System.out.println(imgName);

                //미션~~~~
                //TestVO - num,name,age,imgName
                //TestService >> TestDAO >> TestDAOimpl
                //DB - multi
                //table - test(num,name,age,imgName)
                //selectAll.do >> 이미지목록도 포함해서 보이도록 하기.
                TestVO vo = new TestVO();
                vo.setName(name);
                vo.setAge(age);
                vo.setImgName(imgName);

                int result = service.insert(vo);
                System.out.println("insert result:" + result);

                if(result > 0){
                    response.sendRedirect("selectAll.do");
                }

            }//end if

            //리다이렉트시 파일명이 한글일 경우 아래와 같이 인코딩이 필요하다.
            //imgName = URLEncoder.encode(imgName, "UTF-8");
            //response.sendRedirect("index.do?imgName="+imgName);
        }else if(sPath.equals("/selectAll.do")){

            List<TestVO> vos = service.selectAll();
            request.setAttribute("vos", vos);

            request.getRequestDispatcher("selectAll.jsp").forward(request,response);
        }

    }//end doGet...

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

}