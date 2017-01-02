import lzhw.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

/**
 * Created by lzhw on 2016/12/31.
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static String text = getText();
    static {

        try {
            reader = Resources.getResourceAsReader("config/mybatis/Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.err.println("usetime:" + insertSingleThread());

    }
    /*
     * 单线程1000条数据
     */
    public static long insertSingleThread() {
        SqlSession session = sqlSessionFactory.openSession();
        long time = System.currentTimeMillis();
        System.err.println("now start:" + System.currentTimeMillis());
        for (int i = 0; i <1; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("user" + i);
            user.setRemark(getText());
            session.insert("userMapper.insert", user);
            session.commit();
        }
        session.close();
        return (System.currentTimeMillis()- time);
    }

    public static String getText (){
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream("E:\\old file\\资料\\曼昆经济学原理.txt"),"utf-8");
            char[] chs = new char[4096];
            StringBuilder sb = new StringBuilder();

            while(fr.read(chs)!=-1){
                sb.append(chs);
            };
            return  sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
