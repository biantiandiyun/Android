package lzhw.controller;

import lzhw.dao.TestDaoMapper;
import lzhw.dao.TrainDao;
import lzhw.model.Test;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestContrller {

    @Autowired
    SqlSession sqlSession;
    @Autowired
    TestDaoMapper testDaoMapper;
    @RequestMapping("/test")
    public Object doSomething(){
        TrainDao trainDao = sqlSession.getMapper(TrainDao.class);
       return trainDao.selectById(1L);
//        TestDaoMapper testDaoMapper = sqlSession.getMapper(TestDaoMapper.class);
//        List<Test> list = testDaoMapper.selectAll();
//        return list;
    }
}
