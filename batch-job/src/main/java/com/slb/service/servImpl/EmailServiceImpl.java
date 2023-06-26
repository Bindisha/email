package com.slb.service.servImpl;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.slb.service.email.EmailSender;
import com.slb.service.model.ResponseMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
/*
 * constructor DI
 */
public class EmailServiceImpl implements EmailService {
	
	private final EmailSender emailSender;
	
	@Override
	public ResponseMessage sendEmail(List<String> receiptTo,String subject, String template) {
		emailSender.setMsg(subject);
		emailSender.sendEmail(receiptTo, subject, template);
		ResponseMessage message = new ResponseMessage("bindisha@gmail.com", "Downloading Please wait", Instant.now(), "SLB");
		return message;
	}

}
