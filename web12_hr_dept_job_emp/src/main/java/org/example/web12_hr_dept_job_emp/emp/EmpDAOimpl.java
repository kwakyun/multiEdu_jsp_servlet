package org.example.web12_hr_dept_job_emp.emp;

import com.google.gson.stream.JsonToken;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpDAOimpl implements EmpDAO {

    private final String driver_name = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hr";
    private final String user_name = "root";
    private final String password = "1234";

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    public EmpDAOimpl() { //계속 사용하려면 static을 사용한다.

        System.out.println("EmpDAOimpl()...");
        try {
            Class.forName(driver_name);
            System.out.println("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(EmpVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        System.out.println(vo.getEmployee_id());
        System.out.println(vo.getFirst_name());
        System.out.println(vo.getLast_name());
        System.out.println(vo.getEmail());
        System.out.println(vo.getPhone_number());
        System.out.println(vo.getJob_id());
        System.out.println(vo.getSalary());
        System.out.println(vo.getCommission_pct());
        System.out.println(vo.getManager_id());
        System.out.println(vo.getDepartment_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url, user_name, password);
            System.out.println("conn successed...");
            String sql = "insert into emp(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values(?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);
            System.out.println(vo.getEmployee_id());
            System.out.println(vo.getFirst_name());
            System.out.println(vo.getLast_name());
            System.out.println(vo.getEmail());
            System.out.println(vo.getPhone_number());
            System.out.println(vo.getHire_date());
            System.out.println(vo.getJob_id());
            System.out.println(vo.getSalary());
            System.out.println(vo.getCommission_pct());
            System.out.println(vo.getManager_id());
            System.out.println(vo.getDepartment_id());

            pstmt.setInt(1, vo.getEmployee_id());
            pstmt.setString(2, vo.getFirst_name());
            pstmt.setString(3, vo.getLast_name());
            pstmt.setString(4, vo.getEmail());
            pstmt.setString(5, vo.getPhone_number());
            pstmt.setString(6, vo.getHire_date());
            pstmt.setString(7, vo.getJob_id());
            pstmt.setDouble(8, vo.getSalary());
            pstmt.setDouble(9, vo.getCommission_pct());
            pstmt.setInt(10, vo.getManager_id());
            pstmt.setInt(11, vo.getDepartment_id());

            flag = pstmt.executeUpdate(); //insert, update, delete
            System.out.println("pstmt successed... flag : " + flag);

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


        return flag;

    }

    @Override
    public int update(EmpVO vo) {
        System.out.println("insert()...");
        System.out.println(vo);
        System.out.println(vo.getEmployee_id());
        System.out.println(vo.getFirst_name());
        System.out.println(vo.getLast_name());
        System.out.println(vo.getEmail());
        System.out.println(vo.getPhone_number());
        System.out.println(vo.getJob_id());
        System.out.println(vo.getSalary());
        System.out.println(vo.getCommission_pct());
        System.out.println(vo.getManager_id());
        System.out.println(vo.getDepartment_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url, user_name, password);
            System.out.println("conn successed...");
            String sql = "update emp set employee_id=?,first_name=?,last_name=?,email=?,phone_number=?,hire_date=?,job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? where employee_id=?";
            pstmt = conn.prepareStatement(sql);


            pstmt.setInt(1, vo.getEmployee_id());
            pstmt.setString(2, vo.getFirst_name());
            pstmt.setString(3, vo.getLast_name());
            pstmt.setString(4, vo.getEmail());
            pstmt.setString(5, vo.getPhone_number());
            pstmt.setString(6, vo.getHire_date());
            pstmt.setString(7, vo.getJob_id());
            pstmt.setDouble(8, vo.getSalary());
            pstmt.setDouble(9, vo.getCommission_pct());
            pstmt.setInt(10, vo.getManager_id());
            pstmt.setInt(11, vo.getDepartment_id());
            pstmt.setInt(12, vo.getEmployee_id());

            flag = pstmt.executeUpdate();//insert,update,delete
            System.out.println("pstmt successed...flag : " + flag);


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
        return flag;
    }

    @Override
    public int delete(EmpVO vo) {
        System.out.println("delete()...");
        System.out.println(vo);
        System.out.println(vo.getEmployee_id());

        int flag = 0;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "delete from emp where employee_id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getEmployee_id());

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
    public EmpVO selectOne(EmpVO vo) {
        System.out.println("selectOne()...");
        System.out.println(vo);
        System.out.println(vo.getEmployee_id());

        EmpVO vo2 = null;

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from emp where employee_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getEmployee_id());

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                vo2 = new EmpVO();
                vo2.setEmployee_id(rs.getInt("employee_id"));
                vo2.setFirst_name(rs.getString("first_name"));
                vo2.setLast_name(rs.getString("last_name"));
                vo2.setEmail(rs.getString("email"));
                vo2.setPhone_number(rs.getString("phone_number"));
                vo2.setHire_date(rs.getString("hire_date"));
                vo2.setJob_id(rs.getString("job_id"));
                vo2.setSalary(rs.getDouble("salary"));
                vo2.setCommission_pct(rs.getDouble("commission_pct"));
                vo2.setManager_id(rs.getInt("manager_id"));
                vo2.setDepartment_id(rs.getInt("department_id"));
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
    public List<EmpVO> selectAll() {
        System.out.println("selectAll()....");

        List<EmpVO> vos = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");
            String sql = "select * from emp order by employee_id desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getString("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getDouble("salary"));
                vo.setCommission_pct(rs.getDouble("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
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
    public List<EmpVO> searchList(String searchKey, String searchWord) {
        System.out.println("searchList()...");
        System.out.println(searchKey);
        System.out.println(searchWord);

        List<EmpVO> vos = new ArrayList<>();

        String sql = "";
        if(searchKey.equals("employee_id")){
            sql = "select * from emp where employee_id like ? order by employee_id desc";
        }else if(searchKey.equals("job_id")){
            sql = "select * from emp where job_id like ? order by employee_id desc";
        }

        try {
            conn = DriverManager.getConnection(url,user_name,password);
            System.out.println("conn successed...");

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            rs = pstmt.executeQuery();//select
            System.out.println("pstmt successed...");

            while(rs.next()){
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getString("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getDouble("salary"));
                vo.setCommission_pct(rs.getDouble("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
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
            sql = "SELECT COUNT(employee_id) as count_employee_id FROM emp;";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//select
            if(rs.next()) {
                result = rs.getInt("count_employee_id");
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
    public List<EmpVO> selectPage(int page, int limit) {

        List<EmpVO> vos = new ArrayList<>();
        int startNum = (page-1)*10;
        try {
            conn = DriverManager.getConnection(url, user_name, password);
            String sql = "select * from emp where employee_id order by employee_id limit ?,?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,startNum);
            pstmt.setInt(2,limit);
            rs = pstmt.executeQuery();//select

            while (rs.next()) {
                EmpVO vo = new EmpVO();
                vo.setEmployee_id(rs.getInt("department_id"));
                vo.setEmployee_id(rs.getInt("employee_id"));
                vo.setFirst_name(rs.getString("first_name"));
                vo.setLast_name(rs.getString("last_name"));
                vo.setEmail(rs.getString("email"));
                vo.setPhone_number(rs.getString("phone_number"));
                vo.setHire_date(rs.getString("hire_date"));
                vo.setJob_id(rs.getString("job_id"));
                vo.setSalary(rs.getDouble("salary"));
                vo.setCommission_pct(rs.getDouble("commission_pct"));
                vo.setManager_id(rs.getInt("manager_id"));
                vo.setDepartment_id(rs.getInt("department_id"));
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
