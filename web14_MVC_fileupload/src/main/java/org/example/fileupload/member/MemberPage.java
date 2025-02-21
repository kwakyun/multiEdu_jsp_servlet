package org.example.fileupload.member;

import java.util.List;

public class MemberPage {

    public int cpage(){
        MemberService service = new MemberService();
        int endPage = (int) Math.ceil(service.selectMaxNo()/10.0);
        System.out.println("endPage =" + endPage);
        return endPage;
    }

    public List<MemberVO> spage(int page, int limit){
        MemberService service = new MemberService();
        return service.selectPage(page,limit);
    }




}
