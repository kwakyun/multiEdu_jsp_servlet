package org.example.web12_hr_dept_job_emp.emp;

import com.google.gson.stream.JsonToken;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        System.out.println(vo);

        return 0;
    }

    @Override
    public int update(EmpVO vo) {
        return 0;
    }

    @Override
    public int delete(EmpVO vo) {
        return 0;
    }

    @Override
    public EmpVO selectOne(EmpVO vo) {
        return null;
    }

    @Override
    public List<EmpVO> selectAll() {
        return List.of();
    }

    @Override
    public List<EmpVO> searchList(String searchKey, String searchWord) {
        return List.of();
    }
}
