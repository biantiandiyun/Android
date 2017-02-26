package lzhw.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import java.net.URL;

/**
 * Created by admin on 2017/2/21.
 */
public class EhcacheUtil {

    private  static final CacheManager cacheManager;
    static {
        URL url = EhcacheUtil.class.getClassLoader().getResource("ehcache.xml");
        cacheManager = CacheManager.create(url);
    }

    public static synchronized Cache getCache(String name){
        Cache cache = cacheManager.getCache(name);
        if (cache!=null){
            return cache;
        }
        cacheManager.addCache(name);
        return cacheManager.getCache(name);
    }

    public static void shunDown(){
        cacheManager.shutdown();
    }

    public static void main(String[] args) {

    }
}
