package restservice.application.aop;

import lombok.extern.slf4j.Slf4j;
/*
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
*/
import org.springframework.stereotype.Component;

//@Aspect
@Component
@Slf4j
public class LogInterceptor {

    //@Around("execution(public * restservice.presentation.contoroller.*.HeroController.*(..))")
    //public Object itemReaderAround(ProceedingJoinPoint joinPoint) throws Throwable {
     //   String methodName = joinPoint.getSignature().getName();
     //  log.info("[{}] called.", methodName);
     //   Object object = joinPoint.proceed();
     //   return object;
    //}
}