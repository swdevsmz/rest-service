package com.example.restservice.configuration;

import com.example.restservice.domain.WordModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${sample.world:World}")
  String world;

  /**
   * wordモデルを取得します.
   *
   * @return wordモデル
   */
  @Bean
  public WordModel wordModel() {
    final WordModel model = new WordModel();
    model.setValue(world);
    return model;
  }

}
