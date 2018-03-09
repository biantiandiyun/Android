package lzhw.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public <T> T get(Object key){
        return  (T) redisTemplate.opsForValue().get(key);
    }

    public void set(Object key,Object value){
         redisTemplate.opsForValue().set(key,value,0, TimeUnit.SECONDS);
    }

    /**
     *
     * @param key
     * @param value
     * @param time 毫秒
     */
    public void set(Object key,Object value,long time){
         redisTemplate.opsForValue().set(key,value,time, TimeUnit.MILLISECONDS);
    }

    public void publish (String channel,Object message){
        redisTemplate.convertAndSend(channel, message);
    }
    public String subscribe (String channel, Message message){
        return (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
    }


}
