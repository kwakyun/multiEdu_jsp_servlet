package org.example.fileupload;

import java.util.List;

public class TestService {

    private TestDAO dao = new TestDAOimpl();

    public int insert(TestVO vo) {
        return dao.insert(vo);
    }

    public List<TestVO> selectAll() {
        return dao.selectAll();
    }
}
