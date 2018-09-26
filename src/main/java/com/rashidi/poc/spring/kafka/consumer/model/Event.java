package com.rashidi.poc.spring.kafka.consumer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

  private String id;

  private Instant timestamp;

  private Map<String, Object> params;

  @JsonCreator
  public Event(@JsonProperty("id") String id,
               @JsonProperty("timestamp") Instant timestamp,
               @JsonProperty("params") Map<String, Object> params) {
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

  @Override
  public String toString() {
    return "Event{" +
      "id='" + id + '\'' +
      ", timestamp=" + timestamp +
      ", params=" + params +
      '}';
  }
}
