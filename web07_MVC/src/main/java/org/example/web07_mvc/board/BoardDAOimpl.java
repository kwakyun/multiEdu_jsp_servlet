package org.example.web07_mvc.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {

    @Override
    public int insert(BoardVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public int update(BoardVO vo) {
        System.out.println("update()....");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public int delete(BoardVO vo) {
        System.out.println("delete()....");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public BoardVO selectOne(BoardVO vo) {
        System.out.println("selectOne()....");
        System.out.println(vo);

        BoardVO vo2 = null;

        vo2 = new BoardVO(vo.getNum(),"title...","content...","admin01","2025-25-25");

        return vo2;
    }

    @Override
    public List<BoardVO> selectAll() {
        System.out.println("selectAll()....");

        List<BoardVO> vos = new ArrayList<BoardVO>();
        for (int i = 0; i < 5; i++) {
            BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"admin0"+(1+i),"2025-12-2"+(1+i));
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<BoardVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()....");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<BoardVO> vos = new ArrayList<BoardVO>();
        for (int i = 0; i < 3; i++) {
            BoardVO vo = new BoardVO(1+i,"title"+(1+i),"content"+(1+i),"admin0"+(1+i),"2025-12-2"+(1+i));
            vos.add(vo);
        }
        return vos;
    }
}
