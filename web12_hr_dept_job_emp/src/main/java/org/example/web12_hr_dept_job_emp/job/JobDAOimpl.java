package org.example.web12_hr_dept_job_emp.job;



import org.example.web12_hr_dept_job_emp.dept.DeptVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobDAOimpl implements JobDAO {

    private final String driver_name = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hr";
    private final String user_name = "root";
    private final String password = "1234";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    public JobDAOimpl() { //계속 사용하려면 static을 사용한다.

        System.out.println("JobDAOimpl()...");
        try {
            Class.forName(driver_name);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(JobVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        System.out.println(vo.getJob_id());
        System.out.println(vo.getJob_title());
        System.out.println(vo.getMin_salary());
        System.out.println(vo.getMax_salary());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "insert into job(job_id,job_title,min_salary,max_salary) " +
                    "values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            System.out.println(vo.getJob_id());
            System.out.println(vo.getJob_title());
            System.out.println(vo.getMin_salary());
            System.out.println(vo.getMax_salary());

            pstmt.setString(1,vo.getJob_id());
            pstmt.setString(2,vo.getJob_title());
            pstmt.setDouble(3,vo.getMin_salary());
            pstmt.setDouble(4,vo.getMax_salary());

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
    public int update(JobVO vo) {
        System.out.println("update()...");
        System.out.println(vo);
        System.out.println(vo.getJob_id());
        System.out.println(vo.getJob_title());
        System.out.println(vo.getMin_salary());
        System.out.println(vo.getMax_salary());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "update job set job_title=?,min_salary=?,max_salary=? where job_id=?";
            pstmt = conn.prepareStatement(sql);
            System.out.println(vo.getJob_id());
            System.out.println(vo.getJob_title());
            System.out.println(vo.getMin_salary());
            System.out.println(vo.getMax_salary());

            pstmt.setString(1,vo.getJob_title());
            pstmt.setDouble(2,vo.getMin_salary());
            pstmt.setDouble(3,vo.getMax_salary());
            pstmt.setString(4,vo.getJob_id());

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
    public int delete(JobVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        System.out.println(vo.getJob_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "delete from job where job_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_id());

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
    public JobVO selectOne(JobVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        System.out.println(vo.getJob_id());

        JobVO vo2 = null;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from job where job_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getJob_id());

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                vo2 = new JobVO();
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setJob_title(rs.getString("job_title"));
                vo2.setMin_salary(rs.getDouble("min_salary"));
                vo2.setMax_salary(rs.getDouble("max_salary"));
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
    public List<JobVO> selectAll() {
        System.out.println("selectAll()....");

        List<JobVO> vos = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from job order by job_id desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                JobVO vo = new JobVO();
                vo.setJob_id(rs.getString("job_id"));
                vo.setJob_title(rs.getString("job_title"));
                vo.setMin_salary(rs.getDouble("min_salary"));
                vo.setMax_salary(rs.getDouble("max_salary"));
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
    public List<JobVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<JobVO> vos = new ArrayList<>();

        String sql = "";
        if(searchKey.equals("job_id")){
            sql = "select * from job where job_id like ? order by job_id desc";
        }else if(searchKey.equals("job_title")){
            sql = "select * from job where job_title like ? order by job_id desc";
        }

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                JobVO vo = new JobVO();
                vo.setJob_id(rs.getString("job_id"));
                vo.setJob_title(rs.getString("job_title"));
                vo.setMin_salary(rs.getDouble("min_salary"));
                vo.setMax_salary(rs.getDouble("max_salary"));
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
            sql = "SELECT COUNT(job_id) as count_job_id FROM job;";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            if(rs.next()) {
                result = rs.getInt("count_job_id");
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

    @Override
    public List<JobVO> selectPage(int page, int limit) {

        List<JobVO> vos = new ArrayList<>();
        int startNum = (page-1)*10;
        try {
            conn = DriverManager.getConnection(url, user_name, password);
            String sql = "select * from job order by job_id limit ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,startNum);
            pstmt.setInt(2,limit);
            rs = pstmt.executeQuery();//select

            while (rs.next()) {
                JobVO vo = new JobVO();
                vo.setJob_id(rs.getString("job_id"));
                vo.setJob_title(rs.getString("job_title"));
                vo.setMin_salary(rs.getDouble("min_salary"));
                vo.setMax_salary(rs.getDouble("max_salary"));
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
