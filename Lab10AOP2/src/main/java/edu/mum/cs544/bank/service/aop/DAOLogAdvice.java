package edu.mum.cs544.bank.service.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DAOLogAdvice {
    @Autowired
    ILogger logger;

    @Before(value = "execution(* edu.mum.cs544.bank.dao..*.*(..))")
    public void logDAOCall(JoinPoint joinPoint) {
        logger.log("DAO method: " + joinPoint.getSignature().getName() + " is being called.");
    }
}
