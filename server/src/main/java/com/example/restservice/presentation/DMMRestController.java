package com.example.restservice.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/dmm")
@RequiredArgsConstructor
public class DMMRestController {

  private final RestTemplate restTemplate;

  @GetMapping(value = "show")
  public String show() {
    String url = "";
    return restTemplate.getForObject(url, String.class);
  }

}
