package com.example.restservice.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Message implements Serializable {
  private String text;
}
