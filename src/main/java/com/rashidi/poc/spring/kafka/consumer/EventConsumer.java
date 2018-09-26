package com.rashidi.poc.spring.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rashidi.poc.spring.kafka.consumer.model.Event;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EventConsumer {

  private static final Logger LOG = LoggerFactory.getLogger(EventConsumer.class);

  private ObjectMapper objectMapper;

  @Autowired
  public EventConsumer(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = "event")
  public void listen(ConsumerRecord<String, byte[]> record) {
    if (record.value() == null) {
      return;
    }

    try {
      Event event = objectMapper.readValue(record.value(), Event.class);
      LOG.info("Event {} received.", event.toString());
    } catch (IOException ioe) {
      LOG.warn("Could not deserialize Event.", ioe);
    }
  }
}
