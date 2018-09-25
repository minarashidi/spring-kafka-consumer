package com.rashidi.poc.spring.kafka.consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public interface Bootstrap {

  static void main(String[] args) {
    new AnnotationConfigApplicationContext("com.rashidi.poc.spring.kafka.consumer");
  }
}
