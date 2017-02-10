import lzhw.dao.GenericDao;
import lzhw.dao.SeatDao;
import lzhw.dao.TicketDao;
import lzhw.dao.TrainDao;
import lzhw.model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lzhw on 2016/12/31.
 */
public class Test {
    static  Logger logger = LoggerFactory.getLogger(Test.class);
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

//        System.err.println("usetime:" + insertSingleThread());
//        mulSingleThread();
    }
    public static void addStation(){

    }
    public static void addTrain(){
        SqlSession session = sqlSessionFactory.openSession();
        TrainDao trainDao = session.getMapper(TrainDao.class);
        Train train = new Train();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            train.setTrainNumber("G"+String.format("%03d",i));
            train.setBeginTime(new Date(time+60*60*1000*i));
            train.setEndTime(new Date(time+60*60*1000*(i+1)));
            trainDao.insert(train);
        }
        session.commit();
    }
    public static void mulSingleThread(){
        for (int i = 0; i <10000 ; i++) {
            new Thread(new Runnable() {
                public void run() {
                    insertSingleThread();
                }
            }).start();
        }
    }
    /*
     * 单线程1000条数据
     */
    public static long insertSingleThread() {
        SqlSession session = sqlSessionFactory.openSession();
        long time = System.currentTimeMillis();
        System.err.println("now start:" + System.currentTimeMillis());
        for (int i = 0; i <1000000; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("user" + i);
            user.setData("1234".getBytes());
            user.setRemark(text);
            session.insert("userMapper.insert", user);
            if(i>500&&i%500==0){
                session.commit();
                logger.info("time:"+System.currentTimeMillis());
            }
        }
        session.commit();
        session.close();
        return (System.currentTimeMillis()- time);
    }

    public static String getText (){
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream("d:\\空发日志.txt"),"utf-8");
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
//    public static byte[] getByte (){
//        try {
//            FileInputStream fr = new FileInputStream("E:\\98【软件安装包】\\Yosemite Install(14B25).cdr.baiduyun.downloading");
//            DataInputStream d = new DataInputStream(fr);
//            d.
//            return  sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
