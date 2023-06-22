package com.slb.service.email;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@ConfigurationProperties(prefix = "email.details")
public class EmailConfig {

	@Value("${email.from}")
	private String from;
	@Value("${email.cc}")
	private List<String> cc;
	@Value("${email.bcc}")
	private List<String> bcc;
	
	@Bean
	EmailSender emailSender(JavaMailSender javaMailSender) {
		var emailSender = new EmailSender(javaMailSender);
		emailSender.setFrom(from);
		emailSender.setCc(cc);
		emailSender.setBcc(bcc);
		return emailSender;
	}
	
	
}
