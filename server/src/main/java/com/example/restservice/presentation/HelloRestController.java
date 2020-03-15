package com.example.restservice.presentation;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
@RequiredArgsConstructor
public class HelloRestController {

  private final MessageSource messageSource;

  @GetMapping
  @RequestMapping("show")
  public String showHelloWorld() {
    return "hello world";
  }

  @GetMapping
  @RequestMapping("messagesource")
  public String showMessage() {
    return messageSource.getMessage("key", null, Locale.getDefault());
  }
}
