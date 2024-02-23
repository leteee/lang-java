package com.example.springboot.kafka;

import com.example.springboot.config.KafkaConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TopicListener {

    private static final Logger log = LoggerFactory.getLogger(TopicListener.class);

    @KafkaListener(topics = {KafkaConfig.TOPIC_TEST})
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        log.info("收到kafka推送的数据:{}", consumerRecord.toString());
    }

}
