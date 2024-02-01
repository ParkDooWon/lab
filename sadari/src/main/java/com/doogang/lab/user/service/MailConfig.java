package com.doogang.lab.user.service;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

  @Bean
  public JavaMailSender mailSender() {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setPort(587);
    javaMailSender.setUsername("mail_id");
    javaMailSender.setPassword("secret-key");
    javaMailSender.setHost("smtp.gmail.com");
    Properties properties = new Properties();
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    javaMailSender.setJavaMailProperties(properties);
    return javaMailSender;
  }
}
