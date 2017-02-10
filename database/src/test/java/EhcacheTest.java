import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * Created by admin on 2017/2/14.
 */
public class EhcacheTest {

    public static void main(String[] args) {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().withCache("preConfigured",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(10))).build();
        cacheManager.init();
       Cache<Object,Object> cache = cacheManager.getCache("preConfigured",Object.class, Object.class);
        cache.put(1L,"sasa");
        System.err.println(cache.get(1L));
    }
}
