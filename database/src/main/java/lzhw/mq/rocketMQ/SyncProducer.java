package lzhw.mq.rocketMQ;

import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class SyncProducer {

    public static void main(String[] args) throws Exception {
        /**
         * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例<br>
         * 注意：ProducerGroupName需要由应用来保证唯一<br>
         * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键，
         * 因为服务器会回查这个Group下的任意一个Producer
         */
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        //设置NameServer地址,此处应改为实际NameServer地址，多个地址之间用；分隔
        //NameServer的地址必须有，但是也可以通过环境变量的方式设置，不一定非得写死在代码里
        producer.setNamesrvAddr("localhost:9876;localhost:9875");
//        producer.setInstanceName("producer");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("TopicTest2",// topic
                    "Tag"+i,// tag 消息标签，只支持设置一个Tag（服务端消息过滤使用）
                    "OrderID00"+i,// key 消息关键词，多个Key用KEY_SEPARATOR隔开（查询消息使用）
                    ("Hello MetaQA"+i).getBytes());// body
            SendResult result = producer.send(message);
            System.out.println(result);
        }
    }
}

