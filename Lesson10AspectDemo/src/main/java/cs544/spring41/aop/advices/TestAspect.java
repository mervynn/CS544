package cs544.spring41.aop.advices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    private static Logger logger = LogManager.getLogger(TestAspect.class.getName());

    @Before("execution(* cs544.spring41.aop.advices.CustomerService.*(..))")
    public void logBefore(JoinPoint joinpoint) {
        logger.warn("Inside @Before: About to exec: " + joinpoint.getSignature().getName());
    }

    @After("execution(* cs544.spring41.aop.advices.CustomerService.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        logger.warn("Inside @After: Just execed: " + joinpoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* cs544.spring41.aop.advices.CustomerService.getName(..))", returning = "ret")
    public void afterRet(JoinPoint jp, String ret) {
        System.out.println("Inside @AfterReturning: " + jp.getSignature().getName() + " returned: " + ret);
    }

    @AfterThrowing(pointcut = "execution(* cs544.spring41.aop.advices.CustomerService.getAge(..))", throwing = "ex")
    public void afterThrow(JoinPoint jp, MyException ex) {
        System.out.println("Inside @AfterThrowing: " +jp.getSignature().getName() + " threw a: " + ex.getClass().getName());
    }

    @Around("execution(* cs544.spring41.aop.advices.CustomerService.getName(..))")
    public Object around(ProceedingJoinPoint pjp) {
        String m = pjp.getSignature().getName();
        System.out.println("Inside @Around: Before " + m);
        Object ret = null;
        try {
            ret = pjp.proceed();
//           ICustomerService customerService = (CustomerService) pjp.getTarget();
//           String value = customerService.getName();
//           System.out.println("value: " +value);
//           ret = value;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Inside @Around: After " + m + " returned " + ret);
        return ret;
    }
}
