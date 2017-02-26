import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * Created by admin on 2017/2/14.
 */
public class EhcacheTest {

    static Logger logger = LoggerFactory.getLogger(EhcacheTest.class);

    public static void main(String[] args) {
        URL url = EhcacheTest.class.getResource("ehcache.xml");
        CacheManager cacheManager = CacheManager.create(url);
        cacheManager.addCache("demo");
        Cache cache =cacheManager.getCache("demo");
//
        for (int i = 0; i < 100; i++) {
            Element element = new Element(i,"value"+i);
            cache.put(element);
            System.err.println(cache.getSize());
        }
        System.err.println("ddddddddddddddddddddddddddd");
//        try {
//            Thread.sleep(1000*60);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i = 0; i < 100; i++) {
            System.err.println(cache.get(i));
        }
//        cacheManager.shutdown();
  /*      CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(10))).build();
        cacheManager.init();
        ResourcePoolsBuilder.
       Cache<Object,Object> cache = cacheManager.getCache("preConfigured",Object.class, Object.class);
        cache.put(1L,"sasa");
        System.err.println(cache.get(1L));*/
    }
}
