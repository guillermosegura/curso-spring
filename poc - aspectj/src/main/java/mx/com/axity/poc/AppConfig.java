package mx.com.axity.poc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "mx.com.axity" })
@EnableAspectJAutoProxy
public class AppConfig
{

}
