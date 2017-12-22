package lzhw.dao;

import lzhw.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 2017/2/9.
 */
@Mapper
public interface TestDaoMapper extends GenericDao<Test> {
    @Select("select * from test")
    List<Test> selectAll();
}
