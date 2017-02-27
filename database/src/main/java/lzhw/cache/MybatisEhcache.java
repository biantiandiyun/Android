package lzhw.cache;

import lzhw.utils.EhcacheUtil;
import net.sf.ehcache.Element;
import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by lzhw on 2017/2/25.
 */
public class MybatisEhcache implements Cache {
    private String id = net.sf.ehcache.Cache.DEFAULT_CACHE_NAME;
    public String getId() {
        return id;
    }

    public MybatisEhcache(String id) {
        this.id = id;
    }
    public MybatisEhcache() {
    }

    public void putObject(Object key, Object value) {
        net.sf.ehcache.Cache cache = EhcacheUtil.getCache(id);
        cache.put(new Element(key,value));
    }

    public Object getObject(Object key) {
        net.sf.ehcache.Cache cache = EhcacheUtil.getCache(id);
        return cache.get(key);
    }

    public Object removeObject(Object key) {
        net.sf.ehcache.Cache cache = EhcacheUtil.getCache(id);
        return cache.remove(key);
    }

    public void clear() {
        net.sf.ehcache.Cache cache = EhcacheUtil.getCache(id);
        cache.removeAll();
    }

    public int getSize() {
        return EhcacheUtil.getCache(id).getSize();
    }

    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
