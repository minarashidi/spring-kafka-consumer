package com.rashidi.poc.spring.kafka.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.Instant;
import java.util.Map;

public class Event {

  @JsonProperty("id")
  private final String id;

  @JsonProperty("timestamp")
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  private final Instant timestamp;

  @JsonProperty("params")
  private final Map<String, Object> params;

  public Event(String id, Instant timestamp, Map<String, Object> params) {
    this.id = id;
    this.timestamp = timestamp;
    this.params = params;
  }

  public String getId() {
    return id;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public Map<String, Object> getParams() {
    return params;
  }
}
