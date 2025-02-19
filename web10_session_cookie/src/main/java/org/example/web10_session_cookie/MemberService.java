package org.example.web10_session_cookie;

public class MemberService {

    private MemberDAO dao = new MemberDAOimpl();

    public MemberVO login(MemberVO vo) {
        return dao.login(vo);
    }
}
