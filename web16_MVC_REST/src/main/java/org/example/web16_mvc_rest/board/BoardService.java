package org.example.web16_mvc_rest.board;

import java.util.List;

public class BoardService {

    BoardDAO dao = new BoardDAOimpl();
    
    public int insert(BoardVO vo) {
        return dao.insert(vo);
    }

    
    public int update(BoardVO vo) {
        return dao.update(vo);
    }

    
    public int delete(BoardVO vo) {
        return dao.delete(vo);
    }

    
    public BoardVO selectOne(BoardVO vo) {
        return dao.selectOne(vo);
    }

    
    public List<BoardVO> selectAll() {
        return dao.selectAll();
    }

    
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }
}
