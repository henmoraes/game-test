package br.com.hrmoraes;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import br.com.hrmoraes.bean.AppBean;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");  
		TimeZone.setDefault(tz);
        SpringApplication.run(Application.class, args);
    }
 
    @Bean
    public AppBean appBean() {
    	return new AppBean();
    }
}