package com.example.functiondemo.service.impl;

import com.example.functiondemo.model.HelloWorldInput;
import com.example.functiondemo.model.HelloWorldOutput;
import com.example.functiondemo.service.HelloWorldService;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public HelloWorldOutput execute(HelloWorldInput input) {
        var output = new HelloWorldOutput();
        output.setMessage(input.getMessage() + "ですよ～");
        return output;
    }

}