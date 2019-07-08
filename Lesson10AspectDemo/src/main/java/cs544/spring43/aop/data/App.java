package cs544.spring43.aop.data;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context;
		// context = new
		// ClassPathXmlApplicationContext("cs544/spring43/aop/data/springconfig_41.xml");
		context = new AnnotationConfigApplicationContext(Config.class);
		// ICustomerService cs = context.getBean("customerService",
		// ICustomerService.class);
		// cs.setName("John");
		// System.out.println("From cs: " + cs.getName());
		// cs.exception();

		ICalculator calc = context.getBean("calculator", ICalculator.class);
		int result = calc.add(3, 4);
		System.out.println("The result of 3 + 4 = " + result);

		context.close();
	}
}
