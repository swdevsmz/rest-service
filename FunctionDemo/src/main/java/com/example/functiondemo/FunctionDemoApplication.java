package com.example.functiondemo;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.example.functiondemo.model.CommonOutput;
import com.example.functiondemo.model.ErrorOutput;
import com.example.functiondemo.model.HelloWorldInput;
import com.example.functiondemo.model.HelloWorldOutput;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.MethodHint;
import org.springframework.nativex.hint.SerializationHint;
import org.springframework.nativex.hint.TypeHint;

//@NativeHint
@SerializationHint(types = { HelloWorldInput.class, HelloWorldOutput.class, CommonOutput.class, ErrorOutput.class,
        // BigDecimalのシリアライズに必要
        BigDecimal.class, BigInteger.class, Number.class, String.class })

@TypeHint(types = SerializationUtils.class, typeNames = "org.apache.commons.lang3.SerializationUtils", methods = @MethodHint(name = "clone", parameterTypes = Object.class))
@SpringBootApplication
public class FunctionDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FunctionDemoApplication.class, args);
    }
}
