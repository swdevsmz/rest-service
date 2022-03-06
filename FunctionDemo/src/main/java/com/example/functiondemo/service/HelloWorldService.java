package com.example.functiondemo.service;

import com.example.functiondemo.model.HelloWorldInput;
import com.example.functiondemo.model.HelloWorldOutput;

public interface HelloWorldService {
    HelloWorldOutput execute(HelloWorldInput input);
}
