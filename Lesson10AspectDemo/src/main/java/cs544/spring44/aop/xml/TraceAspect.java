package cs544.spring44.aop.xml;

import org.aspectj.lang.JoinPoint;

public class TraceAspect {

	public void tracebeforemethod(JoinPoint joinpoint) {
		System.out.println("before execution of method " + joinpoint.getSignature().getName());
	}

	public void traceaftermethod(JoinPoint joinpoint) {
		System.out.println("after execution of method " + joinpoint.getSignature().getName());
	}
}