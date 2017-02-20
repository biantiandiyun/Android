package lzhw.utils;

import lzhw.model.Order;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.core.config.BaseCacheConfiguration;
import org.ehcache.xml.XmlConfiguration;

import java.net.URL;

/**
 * Created by admin on 2017/2/20.
 */
public class EhcacheUtil {
    private static XmlConfiguration xmlConfig;
    private static CacheManager cacheManager;
    static {
        xmlConfig = new XmlConfiguration(EhcacheUtil.class.getResource( "/ehcache.xml"));
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConfig);
        cacheManager.init();

    }
    public static Cache createCache() throws Exception {
        return cacheManager.createCache("demo",  xmlConfig.newCacheConfigurationBuilderFromTemplate("template",Long.class,String.class));
    }

    public static void main(String[] args) throws Exception {
        EhcacheUtil.createCache();
    }
}
