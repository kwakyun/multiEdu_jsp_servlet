package org.example.fileupload;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAOimpl implements TestDAO {

    private final String driver_name = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/multi";
    private final String user_name = "root";
    private final String password = "1234";

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;


    public TestDAOimpl(){
        System.out.println("TestDAOimpl()....");

        try {
            Class.forName(driver_name);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(TestVO vo) {
        System.out.println("insert()....");
        System.out.println(vo);

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "insert into test(name,age,imgname) " +
                    "values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getName());
            pstmt.setInt(2,vo.getAge());
            pstmt.setString(3,vo.getImgName());

            flag = pstmt.executeUpdate();//insert,update,delete
            System.out.println("pstmt successed...flag : " + flag);


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
        return flag;
    }

    @Override
    public List<TestVO> selectAll() {
        System.out.println("selectAll()...");

        List<TestVO> vos = new ArrayList<TestVO>();
        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from test order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                TestVO vo = new TestVO();
                vo.setNum(rs.getInt("num"));
                vo.setName(rs.getString("name"));
                vo.setAge(rs.getInt("age"));
                vo.setImgName(rs.getString("imgname"));
                vos.add(vo);
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

        return vos;
    }


}
