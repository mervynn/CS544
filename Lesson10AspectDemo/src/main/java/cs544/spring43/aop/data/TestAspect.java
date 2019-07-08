package cs544.spring43.aop.data;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	@Around("execution(* cs544.spring43.aop.data.CustomerService.setName(String))")
	public Object aroundSetName(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		System.out.println("Argument value: " + args[0]);
		args[0] = "James";
		return pjp.proceed(args);
	}
	
	@Around("execution(* cs544.spring43.aop.data.CustomerService.getName())")
	public Object aroundGetName(ProceedingJoinPoint pjp) throws Throwable {
		Object name = pjp.proceed();
		return "Chris";
	}
	
	@Around("execution(* cs544.spring43.aop.data.CustomerService.exception())")
	public Object aroundException(ProceedingJoinPoint pjp) {
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			throw new OtherException();
		}
	}
	
	@Before("execution(* cs544.spring43.aop.data.CustomerService.setName(String))")
	public void argsBefore(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = (String)args[0];
		System.out.println("Argument value: " + name);
	}

	@Before("execution(* cs544.spring43.aop.data.CustomerService.setName(String)) "
			+ " && args(name))")
	public void argsBefore(JoinPoint jp, String name) {
		System.out.println("Argument value: " + name);
	}

	
}
