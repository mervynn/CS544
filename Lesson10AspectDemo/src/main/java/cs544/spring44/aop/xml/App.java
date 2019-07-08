package cs544.spring44.aop.xml;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context;
		context = new ClassPathXmlApplicationContext("springconfig_44.xml");
		IAccountService as = context.getBean(IAccountService.class);
		as.addAccount(12345, new Customer());
		context.close();
	}
}
