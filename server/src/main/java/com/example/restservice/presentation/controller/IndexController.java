package com.example.restservice.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/")
  public String index(final Model model) {
    model.addAttribute("index", "Hello index");
    return "index";
  }
}
