//package com.example.demo.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.retry.annotation.EnableRetry;
//import org.springframework.scheduling.annotation.EnableAsync;
//
//import java.util.Properties;
//
//@Configuration
//@EnableAsync
//@EnableRetry
//public class MailConfiguration {
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//
//        mailSender.setUsername("tanvir@gmail.com");
//        mailSender.setPassword("kzdi enkn jkzq gikx");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.starttls.required", "true");
//        props.put("mail.debug", "true");
//
//        return mailSender;
//    }
//}
