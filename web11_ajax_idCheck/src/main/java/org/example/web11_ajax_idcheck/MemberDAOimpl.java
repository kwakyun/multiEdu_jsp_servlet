package org.example.web11_ajax_idcheck;

import java.sql.*;

public class MemberDAOimpl implements MemberDAO {

    private final String driver_name = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/multi";
    private final String user_name = "root";
    private final String password = "1234";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public MemberDAOimpl() {

        System.out.println("MemberDAOimpl()...");
        try {
            Class.forName(driver_name);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MemberVO idCheck(MemberVO vo) {
        System.out.println("idCheck()...");
        System.out.println(vo);
        MemberVO vo2 = null;
        
        //jdbc연동 검색결과가 존재하면 객체생성해서 리턴,그렇지않으면 null리턴
        //vo2 = new MemberVO();

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from member where id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                vo2 = new MemberVO();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(pstmt != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        return vo2;
    }
}
