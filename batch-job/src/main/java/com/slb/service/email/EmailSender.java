package com.slb.service.email;

import static java.util.Locale.ENGLISH;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class EmailSender {

	private final SpringTemplateEngine templateEngine;
	private final JavaMailSender javaMailSender;
	
	private String from;
	private List<String> cc;
	private List<String> bcc;
	
	public void sendEmail(List<String> recipients,String subject,String template) {
		
		try {
			
	
		
		var message = javaMailSender.createMimeMessage();
	   	String[] receiverToList = recipients.toArray(new String[0]);
		String[] receiverCcList = cc.toArray(new String[0]);
		String[] receiverBccList = bcc.toArray(new String[0]);
		var html = templateEngine.process(template, new Context(ENGLISH));
		
		var email = new MimeMessageHelper(message, true);
		email.setFrom(from);
		email.setTo(receiverToList);
		email.setCc(receiverCcList);
		email.setBcc(receiverBccList);
		email.setSubject(subject);
		email.setText(html,true);
			
		javaMailSender.send(message);
			
		} catch (MessagingException e) {
			throw new EmailServiceException("Error while sending mail",e);
		}
		
	}
	
	
	private static class EmailServiceException extends RuntimeException{

		public EmailServiceException(String message,Exception exception) {
			super(message,exception);
		}
		
	}
}
