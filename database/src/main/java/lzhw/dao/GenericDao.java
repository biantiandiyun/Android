package lzhw.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by admin on 2017/2/9.
 */
public interface GenericDao<T> {
     T selectById(Long id);
     List<T> selectAll();
     int insert(T t);
     int delete(T t);
     int update(T t);
}
