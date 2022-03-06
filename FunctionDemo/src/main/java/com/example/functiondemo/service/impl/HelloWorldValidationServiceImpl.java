package com.example.functiondemo.service.impl;

import java.util.Locale;
import java.util.Objects;

import com.example.functiondemo.exception.BusinessException;
import com.example.functiondemo.model.HelloWorldInput;
import com.example.functiondemo.service.HelloWorldValidationService;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HelloWorldValidationServiceImpl implements HelloWorldValidationService {

    private final MessageSource messageSource;

    @Override
    public void execute(HelloWorldInput input) throws BusinessException {
        if (Objects.isNull(input) || !StringUtils.hasText(input.getMessage())) {
            throw new BusinessException("BE00001",
                    messageSource.getMessage("BE0001", new Object[] { "メッセージ" }, Locale.getDefault()));
        }
    }
}
