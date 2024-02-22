package com.example.springboot.controller;

import com.example.springboot.config.KafkaProducerListener;
import com.example.springboot.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaProducerListener kafkaProducerListener;

    @PostMapping()
    public R produce(@RequestParam(value = "msg") String msg) {
        kafkaTemplate.setProducerListener(kafkaProducerListener);
        kafkaTemplate.send("topic-test", msg);
        return R.success();
    }
}
