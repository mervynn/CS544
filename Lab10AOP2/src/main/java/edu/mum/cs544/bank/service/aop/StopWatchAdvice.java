package edu.mum.cs544.bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class StopWatchAdvice {

    @Around(value = "execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start();
        Object retVal = pjp.proceed();
        sw.stop();
        System.out.println(String.format("%s method costs %s ms", pjp.getSignature().getName(), sw.getLastTaskTimeMillis()));
        return retVal;
    }
}
