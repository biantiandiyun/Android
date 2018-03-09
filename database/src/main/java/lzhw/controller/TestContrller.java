package lzhw.controller;

import lzhw.db.DataSourceEnum;
import lzhw.db.DynamicDataSource;
import lzhw.mapper.TestDaoMapper;
import lzhw.dao.TrainDao;
import lzhw.model.Test;
import lzhw.model.Train;
import lzhw.service.TestTx;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class TestContrller {

    @Autowired
    TestTx testTx;
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("/test")
    public Object doSomething(){
//        TrainDao trainDao = sqlSession.getMapper(TrainDao.class);
//        Train train = new Train();
//        train.setBeginTime(new Date());
//        train.setEndTime(new Date());
//        train.setTrainNumber("T004");
//        trainDao.insert(train);
//        train.setTrainNumber("T005");
//        trainDao.insert(train);
//        TestDaoMapper testDaoMapper = sqlSession.getMapper(TestDaoMapper.class);
//        try {
//            Method method = testTx.getClass().getDeclaredMethod("doTx",new Class[0]);
//            return method.invoke(testTx,new Class[0]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return testTx.doTx();
    }
//
    @RequestMapping("/redis")
    public Object doRedis(){
        redisTemplate.opsForValue().set(UUID.randomUUID().toString(),UUID.randomUUID().toString());
        return null;
    }
}
