package com.example.restservice.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  public String hello(final Model model) {
    model.addAttribute("hello", "Hello World");
    return "hello";
  }
}
