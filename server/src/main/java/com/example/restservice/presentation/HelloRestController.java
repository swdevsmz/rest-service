package com.example.restservice.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloRestController {

  @GetMapping
  @RequestMapping("show")
  public String showHelloWorld() {
    return "hello world";
  }
}
