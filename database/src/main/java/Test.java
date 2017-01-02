import lzhw.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by lzhw on 2016/12/31.
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {

        try {
            reader = Resources.getResourceAsReader("config/mybatis/Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
//            User user = (User) session.selectOne("userMapper.GetUserByID", 1);
            System.err.println("now start:"+System.currentTimeMillis());
            for (int i = 0; i < 100000; i++) {
                User user = new User();
                user.setAge(i);
                user.setName("user"+i);
                session.insert("userMapper.insert",user);
                if (i>=100&&i%100==0) {
                    session.commit();
                }
            }
            System.err.println("end:"+System.currentTimeMillis());
        } finally {
            session.close();
        }
    }
}
