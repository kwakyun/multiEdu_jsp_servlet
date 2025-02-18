package org.example.web09_mvc_jdbc.board;


import java.util.List;

public class BoardService implements BoardDAO {
    BoardDAO dao = new BoardDAOimpl();
    @Override
    public int insert(BoardVO vo) {
        return dao.insert(vo);
    }

    @Override
    public int update(BoardVO vo) {
        return dao.update(vo);
    }

    @Override
    public int delete(BoardVO vo) {
        return dao.delete(vo);
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        return dao.selectOne(vo);
    }

    @Override
    public List<BoardVO> selectAll() {
        return dao.selectAll();
    }

    @Override
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        return dao.searchList(searchKey, searchWord);
    }

    @Override
    public int selectMaxNo() {
        return dao.selectMaxNo();
    }

    @Override
    public List<BoardVO> selectPage(int page, int limit) {
        return dao.selectPage(page,limit);
    }
}
