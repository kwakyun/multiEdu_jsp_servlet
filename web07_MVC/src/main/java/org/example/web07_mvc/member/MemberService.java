package org.example.web07_mvc.member;

import java.util.List;

public class MemberService implements MemberDAO {

    MemberDAO dao = new MemberDAOimpl();

    public int insert(MemberVO vo) {
        return dao.insert(vo);
    }

    
    public int update(MemberVO vo) {
        return dao.update(vo);
    }

    
    public int delete(MemberVO vo) {
        return dao.delete(vo);
    }

    
    public MemberVO selectOne(MemberVO vo) {
        return dao.selectOne(vo);
    }

    
    public List<MemberVO> selectAll() {
        return dao.selectAll();
    }

    
    public List<MemberVO> searchList(String searchKey,String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }
}
