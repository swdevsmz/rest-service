package com.example.restservice.presentation;

import com.example.restservice.domain.WorldModel;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
@RequiredArgsConstructor
public class HelloRestController {

  private static final Logger logger = LoggerFactory.getLogger(HelloRestController.class);

  private final MessageSource messageSource;

  private final WorldModel worldModel;

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
  public WorldModel world() {
    return worldModel;
  }

  /**
   * wordを設定します.
   *
   * @param worldModel ワード
   * @return ワード
   */
  @PostMapping(value = "/world")
  public WorldModel setWorld(@RequestBody WorldModel worldModel) {
    this.worldModel.setValue(worldModel.getValue());
    logger.info("set value : {}", worldModel.getValue());
    return worldModel;
  }

}
