package cs544.spring42.aop.boolops;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
    ConfigurableApplicationContext context;
    //context = new ClassPathXmlApplicationContext("cs544/spring42/aop/boolops/springconfig_41.xml");
    context = new AnnotationConfigApplicationContext(Config.class);
    ICustomerService cs = context.getBean("customerService", ICustomerService.class);
    cs.getName();
    
    IOrderService os = context.getBean("orderService", IOrderService.class);
    os.deleteOrder("1");
    
    context.close();
  }
}
