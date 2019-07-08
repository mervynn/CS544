package cs544.spring40.aop.terms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cs544.spring40.aop.terms")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Config {
}
