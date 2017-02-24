package lzhw.utils;

/**
 * Created by admin on 2017/2/20.
 */
public class Ehcache3Util {
    /*private static XmlConfiguration xmlConfig;
    private static CacheManager cacheManager;
    static {
        xmlConfig = new XmlConfiguration(Ehcache3Util.class.getResource("/ehcache3.xml"));
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();

    }
    public static Cache createCache() throws Exception {
        return cacheManager.createCache("demo",  xmlConfig.newCacheConfigurationBuilderFromTemplate("template",Long.class,String.class));
    }

    public static void main(String[] args) throws Exception {
       Cache<Long,String> cache = Ehcache3Util.createCache();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            cache.put(i,"value"+i);
            System.err.println(i);
        }
        System.err.println("the end =====================");
        Thread.sleep(1000000);
    }*/
}
