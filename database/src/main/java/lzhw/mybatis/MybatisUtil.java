package lzhw.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by admin on 2017/2/14.
 */
public class MybatisUtil {
    static Logger logger = LoggerFactory.getLogger(MybatisUtil.class);


    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    static {
        initSqlSessionFactory();
    }
    private static void initSqlSessionFactory(){
        if (sqlSessionFactory==null){
            try {
                Reader reader = Resources.getResourceAsReader("config/mybatis/Configuration.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory;
    }
    public static SqlSession getSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            sqlSession = getSqlSessionFactory().openSession();
            threadLocal.set(sqlSession);
        }
        return  sqlSession;
    }

    public static void close(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }

    public static void main(String[] args) {

    }
}
