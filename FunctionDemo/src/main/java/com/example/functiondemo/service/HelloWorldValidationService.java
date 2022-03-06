package com.example.functiondemo.service;

import com.example.functiondemo.exception.BusinessException;
import com.example.functiondemo.model.HelloWorldInput;

public interface HelloWorldValidationService {
    public void execute(HelloWorldInput input) throws BusinessException;
}
