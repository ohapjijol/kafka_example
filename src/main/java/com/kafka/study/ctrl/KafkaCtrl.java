package com.kafka.study.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * study
 *
 * @author wedul
 * @since 2019-01-24
 **/
@RestController
@Slf4j
public class KafkaCtrl {

  private final KafkaTemplate kafkaTemplate;

  public KafkaCtrl(KafkaTemplate kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendMessage(String message) {
    if(!StringUtils.isEmpty(message)) kafkaTemplate.send("test", "Message is " + message);
    log.info(message);
    return ResponseEntity.ok("");
  }
}
