package cs544.spring42.aop.boolops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckOrderAspect {
//	@Pointcut("execution(* cs544.spring42.aop.boolops.OrderService.*(..))")
//	public void checkOrder() {
//	}

	@Before("NamedPointCuts.checkOrder()")
	public void checkOrder(JoinPoint joinpoint) {
		System.out.println("check order");
	}

	@After("NamedPointCuts.checkOrder()")
	public void logOrderEvent(JoinPoint joinpoint) {
		System.out.println("log order event");
	}
}
