package configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import utils.Calculadora;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	
	@Bean
	public Calculadora getCalculadora () {
		return new Calculadora();
	}
}
