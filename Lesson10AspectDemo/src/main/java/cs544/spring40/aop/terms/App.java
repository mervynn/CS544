package cs544.spring40.aop.terms;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    ConfigurableApplicationContext context;
    context = new ClassPathXmlApplicationContext("springconfig_40.xml");
    //context = new AnnotationConfigApplicationContext(Config.class);
    ICustomerService cs = context.getBean("customerService", ICustomerService.class);
    cs.doSomething();
    
    context.close();
  }
}
