package org.example.web12_hr_dept_job_emp.dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeptDAOimpl implements DeptDAO {


    private final String driver_name = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hr";
    private final String user_name = "root";
    private final String password = "1234";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    public DeptDAOimpl() { //계속 사용하려면 static을 사용한다.

        System.out.println("DeptDAOimpl()...");
        try {
            Class.forName(driver_name);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(DeptVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        System.out.println(vo.getDepartment_id());
        System.out.println(vo.getDepartment_name());
        System.out.println(vo.getManager_id());
        System.out.println(vo.getLocation_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "insert into dept(department_id,department_name,manager_id,location_id) " +
                    "values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            System.out.println(vo.getDepartment_id());
            System.out.println(vo.getDepartment_name());
            System.out.println(vo.getManager_id());
            System.out.println(vo.getLocation_id());

            pstmt.setInt(1,vo.getDepartment_id());
            pstmt.setString(2,vo.getDepartment_name());
            pstmt.setInt(3,vo.getManager_id());
            pstmt.setInt(4,vo.getLocation_id());

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
    public int update(DeptVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        System.out.println(vo.getDepartment_id());
        System.out.println(vo.getDepartment_name());
        System.out.println(vo.getManager_id());
        System.out.println(vo.getLocation_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "update dept set department_id=?,department_name=?,manager_id=?,location_id=? where department_id=?";
            pstmt = conn.prepareStatement(sql);
            System.out.println(vo.getDepartment_id());
            System.out.println(vo.getDepartment_name());
            System.out.println(vo.getManager_id());
            System.out.println(vo.getLocation_id());

            pstmt.setInt(1,vo.getDepartment_id());
            pstmt.setString(2,vo.getDepartment_name());
            pstmt.setInt(3,vo.getManager_id());
            pstmt.setInt(4,vo.getLocation_id());

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
    public int delete(DeptVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        System.out.println(vo.getDepartment_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "delete from dept where department_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());

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
    public DeptVO selectOne(DeptVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        System.out.println(vo.getDepartment_id());

        DeptVO vo2 = null;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from dept where department_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getDepartment_id());

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                vo2 = new DeptVO();
                vo2.setDepartment_id(rs.getInt("department_id"));
                vo2.setDepartment_name(rs.getString("department_name"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setLocation_id(rs.getInt("location_id"));
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



    @Override
    public List<DeptVO> selectAll() {
        System.out.println("selectAll()....");

        List<DeptVO> vos = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from dept order by department_id desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                DeptVO vo = new DeptVO();
                vo.setDepartment_id(rs.getInt("department_id"));
                vo.setDepartment_name(rs.getString("department_name"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setLocation_id(rs.getInt("location_id"));;
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
        Collections.reverse(vos);
        return vos;
    }

    @Override
    public List<DeptVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<DeptVO> vos = new ArrayList<>();

        String sql = "";
        if(searchKey.equals("department_id")){
            sql = "select * from job where department_id like ? order by department_id desc";
        }else if(searchKey.equals("department_name")){
            sql = "select * from job where department_name like ? order by department_id desc";
        }

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                DeptVO vo = new DeptVO();
                vo.setDepartment_id(rs.getInt("department_id"));
                vo.setDepartment_name(rs.getString("department_name"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setLocation_id(rs.getInt("location_id"));
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
    @Override
    public int selectCount() {
        int result = 0;
        try {
            conn = DriverManager.getConnection(url, user_name, password);

            String sql = "";
            sql = "SELECT COUNT(department_id) as count_department_id FROM dept;";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            if(rs.next()) {
                result = rs.getInt("count_department_id");
            }else {
                System.out.println("No records found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
    @Override //
    public List<DeptVO> selectPage(int page, int limit) {


        List<DeptVO> vos = new ArrayList<>();
        int startNum = (page-1)*10;
        try {
            conn = DriverManager.getConnection(url, user_name, password);
            String sql = "select * from dept where department_id order by department_id limit ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,startNum);
            pstmt.setInt(2,limit);
            rs = pstmt.executeQuery();//select

            while (rs.next()) {
                DeptVO vo = new DeptVO();
                vo.setDepartment_id(rs.getInt("department_id"));
                vo.setDepartment_name(rs.getString("department_name"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setLocation_id(rs.getInt("location_id"));
                vos.add(vo);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Collections.reverse(vos);
        return vos;
    }
}
