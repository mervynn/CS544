package cs544.spring42.aop.boolops;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NamedPointCuts {
	@Pointcut("execution(* cs544.spring42.aop.boolops.OrderService.*(..))")
	public void checkOrder() {
	}
}
