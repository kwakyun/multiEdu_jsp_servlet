package org.example.web09_mvc_jdbc.member;

import java.util.List;

public class MemberPage {

    public int cpage(){
        BoardService service = new BoardService();
        int endPage = (int) Math.ceil(service.selectMaxNo()/10.0);
        System.out.println("endPage =" + endPage);
        return endPage;
    }

    public List<MemberVO> spage(int page, int limit){
        BoardService service = new BoardService();
        return service.selectPage(page,limit);
    }




}
