package com.example.restservice.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class UserController {


  @GetMapping("/user")
  public ModelAndView get(){
    return new ModelAndView();
  }
}
