package cs544.spring43.aop.data;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalcAspect {
	@Around("execution(* cs544.spring43.aop.data.Calculator.add(..))")
	public Object changeNumbers(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		int x = (Integer) args[0];
		int y = (Integer) args[1];
		System.out.println("CalcAspect.changeNumbers: x= " + x + " and y= " + y);
		
		args[0] = 5;
		args[1] = 9;
		Object object = null;
		try { object = pjp.proceed(args);
		} catch (Throwable e) { /* do nothing*/ }
		System.out.println("CalcAdvice.changeNumbers: call.proceed returns " + object);
		return 26;
	}
}
