package org.example.web16_mvc_rest.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
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

            String cpage = request.getParameter("cpage");
            String limit = request.getParameter("limit");
            System.out.println(cpage);
            System.out.println("cpage : " + cpage);
            System.out.println("limit : " + limit);

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
            request.setAttribute("vos", vos);

            RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
            rd.forward(request, response);
        } else if (sPath.equals("/m_insertOK.do")) {

            System.out.println("fileUpload 처리중.....");
            //한글 깨짐 방지 인코딩 추가방법
//        인텔리제이 > 상단 tomcat > Edit configurations > VM option
//        -Dfile.encoding=UTF-8

            String id = "";
            String pw = "";
            String name = "";
            String tel = "";
            String imgName = "default.png";

            //form전송시 encType설정 멀티파트형식일 때 : true
            System.out.println(JakartaServletFileUpload.isMultipartContent(request));

            if(JakartaServletFileUpload.isMultipartContent(request)) {
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
                        if (item.getFieldName().equals("id")) {
                            id = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("pw")) {
                            pw = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("name")) {
                            name = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("tel")) {
                            tel = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }

                    } else {
                        System.out.println(item.getName());
                        String originName = item.getName();
                        if (originName.length() > 0) {
                            //이미지이름을 유니크하게 변경해줘야한다.
                            String temp = originName.substring(0, originName.lastIndexOf(".")) + "_" + System.currentTimeMillis();
                            System.out.println(temp);//0112_893057340915154
                            String format_type = originName.substring(originName.lastIndexOf("."));//.png
                            System.out.println(format_type);
                            imgName = temp + format_type;//0112_893057340915154 + .png


                            System.out.println("====================");
                            //이미지저장
                            //이미지 저장할 폴더 찾기(리얼패스)
                            //프로젝트경로가아니고 배포경로를 의미한다.
                            String dir_path = request.getServletContext().getRealPath("/upload");
                            System.out.println(dir_path);

                            //경로 + 파일명 >> 이미저장됨.
                            item.write(new File(dir_path, imgName).toPath());

                        }
                    }
                }//end for
            }//end if

            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);
            System.out.println(imgName);

            MemberVO vo = new MemberVO();
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);
            vo.setImgName(imgName);

            int result = service.insert(vo);
            System.out.println("insert result : "+result);

            if (result == 1) {
                System.out.println("insert successed...");
                response.sendRedirect("index.do");
            } else {
                System.out.println("insert failed...");
                response.sendRedirect("m_insert.do");
            }

        } else if (sPath.equals("/m_updateOK.do")) {

            System.out.println("fileUpload 처리중.....");
            //한글 깨짐 방지 인코딩 추가방법
//        인텔리제이 > 상단 tomcat > Edit configurations > VM option
//        -Dfile.encoding=UTF-8

            String num = "";
            String id = "";
            String pw = "";
            String name = "";
            String tel = "";
            String imgName = "default.png";

            //form전송시 encType설정 멀티파트형식일 때 : true
            System.out.println(JakartaServletFileUpload.isMultipartContent(request));

            if(JakartaServletFileUpload.isMultipartContent(request)) {
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
                        if (item.getFieldName().equals("num")) {
                            num = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("id")) {
                            id = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("pw")) {
                            pw = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("name")) {
                            name = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }
                        if (item.getFieldName().equals("tel")) {
                            tel = item.getString(Charset.forName("UTF-8"));//한글처리,kim길동
                        }

                    } else {
                        System.out.println(item.getName());
                        String originName = item.getName();
                        if (originName.length() > 0) {
                            //이미지이름을 유니크하게 변경해줘야한다.
                            String temp = originName.substring(0, originName.lastIndexOf(".")) + "_" + System.currentTimeMillis();
                            System.out.println(temp);//0112_893057340915154
                            String format_type = originName.substring(originName.lastIndexOf("."));//.png
                            System.out.println(format_type);
                            imgName = temp + format_type;//0112_893057340915154 + .png


                            System.out.println("====================");
                            //이미지저장
                            //이미지 저장할 폴더 찾기(리얼패스)
                            //프로젝트경로가아니고 배포경로를 의미한다.
                            String dir_path = request.getServletContext().getRealPath("/upload");
                            System.out.println(dir_path);

                            //경로 + 파일명 >> 이미저장됨.
                            item.write(new File(dir_path, imgName).toPath());

                        }
                    }
                }//end for
            }//end if

            System.out.println(num);
            System.out.println(id);
            System.out.println(pw);
            System.out.println(name);
            System.out.println(tel);
            System.out.println(imgName);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));
            vo.setId(id);
            vo.setPw(pw);
            vo.setName(name);
            vo.setTel(tel);
            vo.setImgName(imgName);

            int result = service.update(vo);
            System.out.println("update result : "+result);

            if (result == 1) {
                System.out.println("update successed...");
                response.sendRedirect("m_selectOne.do?num="+num);
            } else {
                System.out.println("update failed...");
                response.sendRedirect("m_update.do?num=" + num);
            }

        }else if (sPath.equals("/m_deleteOK.do")) {
            String num = request.getParameter("num");
            System.out.println(num);

            MemberVO vo = new MemberVO();
            vo.setNum(Integer.parseInt(num));

            int result = service.delete(vo);
            System.out.println("delete result : "+result);

            if(result == 1){
                System.out.println("delete successed...");
                response.sendRedirect("index.do");
            }else{
                System.out.println("delete failed...");
                response.sendRedirect("m_delete.do?num="+num);
            }

        }

    }//end doGet()....

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }


}