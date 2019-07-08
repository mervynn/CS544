package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* EmailSender.sendEmail(..))")
    public void logAfter(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(String.format("%s method= %s address=%s message= %s", new Date(),
                joinPoint.getSignature().getName(), args[0], args[1]));
        IEmailSender es = (IEmailSender) joinPoint.getTarget();
        System.out.println(String.format("outgoing mail server = %s", es.getOutgoingMailServer()));
    }

    @Around("execution(* CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(pjp.getSignature().getName());
        Object retVal = pjp.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.println(String.format("Time to execute save = %s ms", totalTime));
        return retVal;
    }
}
