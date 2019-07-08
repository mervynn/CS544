package cs544.spring43.aop.data;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InjectAspect {
	@Autowired
	private PersonDao personDao;
	
	@Before("execution(* cs544.spring43.aop.data.CustomerService.setName(String))")
	public void argsBefore(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = (String)args[0];
		Person p = personDao.byName(name);
		if (p.getAge() > 18) {
			System.out.println("adult");
		}
	}

}
