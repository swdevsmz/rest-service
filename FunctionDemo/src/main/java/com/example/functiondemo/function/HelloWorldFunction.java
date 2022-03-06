package com.example.functiondemo.function;

import java.util.Optional;
import java.util.function.Function;

import com.example.functiondemo.exception.BusinessException;
import com.example.functiondemo.exception.SystemException;
import com.example.functiondemo.model.CommonOutput;
import com.example.functiondemo.model.ErrorOutput;
import com.example.functiondemo.model.HelloWorldInput;
import com.example.functiondemo.model.HelloWorldOutput;
import com.example.functiondemo.service.HelloWorldService;
import com.example.functiondemo.service.HelloWorldValidationService;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component("helloWorldFunction")
@Slf4j
@AllArgsConstructor
public class HelloWorldFunction implements Function<Message<HelloWorldInput>, Message<CommonOutput<HelloWorldOutput>>> {

    private final HelloWorldValidationService validationService;
    private final HelloWorldService helloWorldService;

    @Override
    public Message<CommonOutput<HelloWorldOutput>> apply(Message<HelloWorldInput> input) {

        log.info(this.getClass().getName() + " has started!");
        log.info("[input]" + input.toString());

        final CommonOutput<HelloWorldOutput> output = new CommonOutput<>();

        try {

            HelloWorldInput helloWorldInput = input.getPayload();
            // HelloWorldInput cloned = SerializatienableLoggingRequestDetails:
            // trueonUtils.clone(helloWorldInput);
            // SerializationUtils.roundtrip(helloWorldInput);
            // Math.abs(0.2); helloWorldOutput.setMessage(helloWorldInput.getvoidMessage() +
            // "ですよ～");

            // log.info(cloned.toString());

            // 入力検証
            Optional<ErrorOutput> error = validate(helloWorldInput);
            if (error.isPresent()) {
                output.setError(error.get());
                return MessageBuilder.withPayload(output).build();
            }

            HelloWorldOutput helloWorldOutput = helloWorldService.execute(helloWorldInput);
            output.setResult(helloWorldOutput);
            log.info("[Output]" + helloWorldOutput.toString());
            return MessageBuilder.withPayload(output).build();

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new SystemException("", e.getStackTrace(), e);
        }
    }

    Optional<ErrorOutput> validate(HelloWorldInput input) {
        try {
            validationService.execute(input);
        } catch (BusinessException e) {
            return Optional.of(new ErrorOutput(e.getCode(), e.getMessage()));
        }
        return Optional.empty();
    }
}
