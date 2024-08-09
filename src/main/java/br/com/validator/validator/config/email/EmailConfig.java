package br.com.validator.validator.config.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {


    @Bean
    public JavaMailSenderImpl mailSender(){
        return new JavaMailSenderImpl();
    }
}
