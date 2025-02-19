package org.example.web11_ajax_idcheck;

public class MemberService {

    private MemberDAO dao = new MemberDAOimpl();

    public MemberVO idCheck(MemberVO vo) {
        return dao.idCheck(vo);
    }
}
