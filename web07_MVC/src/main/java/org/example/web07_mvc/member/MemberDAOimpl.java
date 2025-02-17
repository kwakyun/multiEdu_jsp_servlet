package org.example.web07_mvc.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOimpl implements MemberDAO {

    @Override
    public int insert(MemberVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public int update(MemberVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public int delete(MemberVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        int flag = 0;

        flag = 1;

        return flag;
    }

    @Override
    public MemberVO selectOne(MemberVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        MemberVO vo2 = null;

        vo2 = new MemberVO(vo.getNum(), "admin1", "hi1111", "kim1", "011");

        return vo2;
    }

    @Override
    public List<MemberVO> selectAll() {
        System.out.println("selectAll()...");

        List<MemberVO> vos = new ArrayList<MemberVO>();
        for (int i = 0; i < 15; i++) {
            MemberVO vo = new MemberVO(1 + i, "admin" + (1 + i), "hi1111" + (1 + i), "kim" + (1 + i), "011" + (1 + i));
            vos.add(vo);
        }

        return vos;
    }

    @Override
    public List<MemberVO> searchList(String searchKey,String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<MemberVO> vos = new ArrayList<MemberVO>();
        for (int i = 10; i < 13; i++) {
            MemberVO vo = new MemberVO(1 + i, "admin" + (1 + i), "hi1111" + (1 + i), "kim" + (1 + i), "011" + (1 + i));
            vos.add(vo);
        }

        return vos;
    }
}
