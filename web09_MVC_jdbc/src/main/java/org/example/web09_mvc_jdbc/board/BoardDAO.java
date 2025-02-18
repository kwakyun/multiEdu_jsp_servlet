package org.example.web09_mvc_jdbc.board;

import org.example.web09_mvc_jdbc.member.MemberVO;

import java.util.List;

public interface BoardDAO {
    public int insert(BoardVO vo);
    public int update(BoardVO vo);
    public int delete(BoardVO vo);
    public BoardVO selectOne(BoardVO vo);
    public List<BoardVO> selectAll();
    public List<BoardVO> searchList(String searchKey, String searchWord);
    public int selectMaxNo();
    public List<BoardVO> selectPage(int page, int limit);
}
