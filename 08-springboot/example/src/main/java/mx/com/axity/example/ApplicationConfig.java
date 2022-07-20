package mx.com.axity.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author guillermo.segura@axity.com
 *
 */
@EnableWebMvc
@Configuration
public class ApplicationConfig
{
  @Bean
  public HttpMessageConverter<Object> createXmlHttpMessageConverter() {
      MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
      return xmlConverter;
  }
}
