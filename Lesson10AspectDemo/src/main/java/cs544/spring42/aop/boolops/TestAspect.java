package cs544.spring42.aop.boolops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    private static Logger logger = LogManager.getLogger(TestAspect.class.getName());

    @Before("execution(* cs544.spring42.aop.boolops.CustomerService.*(..)) "
            + " && @target(org.springframework.stereotype.Service)")
    public void logBefore(JoinPoint joinpoint) {
        logger.warn("About to exec: " + joinpoint.getSignature().getName());
    }
}
