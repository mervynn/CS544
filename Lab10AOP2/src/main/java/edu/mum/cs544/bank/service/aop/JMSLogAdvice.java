package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JMSLogAdvice {
    @Autowired
    ILogger logger;

    @Around(value = "execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..))")
    public Object JMSLogAdvice(ProceedingJoinPoint pjp) throws Throwable{
        String msg = (String) pjp.getArgs()[0];
        logger.log("JMS message: " + msg);
        Object retVal = pjp.proceed();
        return retVal;
    }

}
