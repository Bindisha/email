package com.slb.service.email;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class EmailSender {

	private final JavaMailSender javaMailSender;
	
	private String from;
	private List<String> cc;
	private List<String> bcc;
	
	public void sendEmail(List<String> recipients,String subject) {
		
		try {
			
		String[] receiverToList = recipients.toArray(new String[0]);
		String[] receiverCcList = cc.toArray(new String[0]);
		String[] receiverBccList = bcc.toArray(new String[0]);
		
		Properties properties=new Properties();  
		//fill all the information like host name etc.  
		Session session=Session.getDefaultInstance(properties,null); 
		
		  MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress(from));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress("bindishaparmar01@gmail.com"));  
	         message.setSubject("Ping");  
	         message.setText("Hello, this is example of sending email  ");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  			
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
