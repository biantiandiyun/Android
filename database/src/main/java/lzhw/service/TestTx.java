package lzhw.service;

import lzhw.db.DataSourceEnum;
import lzhw.db.DynamicDataSource;
import lzhw.mapper.TestDaoMapper;
import lzhw.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestTx {

    @Autowired
    TestDaoMapper testDaoMapper;

    public List<Test> doTx() {
        DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
        List<Test> list = testDaoMapper.selectAll();
        DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
        list = testDaoMapper.selectAll();
        return list;
    }
}
