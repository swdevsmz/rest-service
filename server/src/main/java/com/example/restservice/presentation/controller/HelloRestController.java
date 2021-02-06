package com.example.restservice.presentation.controller;

import com.example.restservice.domain.WordModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("api/hello")
@RequiredArgsConstructor
public class HelloRestController {

  private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);

  private final MessageSource messageSource;

  private final WordModel wordModel;

  @GetMapping
  @RequestMapping("show")
  public String showHelloWorld() {
    return "hello world";
  }

  @GetMapping
  @RequestMapping("messageSource")
  public String showMessage() {
    return messageSource.getMessage("key", null, Locale.getDefault());
  }

  @GetMapping(value = "/world")
  public WordModel world() {
    return wordModel;
  }

  /**
   * wordを設定します.
   *
   * @param wordModel ワード
   * @return ワード
   */
  @PostMapping(value = "/world")
  public WordModel setWorld(final @RequestBody WordModel wordModel) {
    this.wordModel.setValue(wordModel.getValue());
    logger.info("set value : {}", wordModel.getValue());
    return wordModel;
  }

}
