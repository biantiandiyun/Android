package lzhw.listener.redis;

import lzhw.cache.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisListener implements MessageListener {
    public static final Logger logger = LoggerFactory.getLogger(RedisListener.class);
    @Autowired
    private RedisUtils redisUtils;
    public void onMessage(Message message, byte[] pattern) {
       logger.info(redisUtils.subscribe(null,message));
    }
}
