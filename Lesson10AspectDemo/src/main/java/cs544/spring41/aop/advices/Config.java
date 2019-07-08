package cs544.spring41.aop.advices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cs544.spring41.aop.advices")
@EnableAspectJAutoProxy
public class Config {
}
