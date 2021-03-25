package mx.com.axity.poc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "mx.com.axity.poc.controller", "mx.com.axity.poc.service" })
public class AppConfig
{

}
