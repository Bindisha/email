package com.slb.service.controller;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slb.service.email.EmailSender;
import com.slb.service.model.Payload;
import com.slb.service.model.ResponseMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmailApiController {
	
	private final EmailSender emailSender;

	@GetMapping("/sendmail")
	public ResponseEntity<ResponseMessage> getData(){
		
		
		emailSender.sendEmail(Arrays.asList("bindishaparmar01@gmail.com"),"TestMail", "text/sample.txt");
		
		ResponseMessage message = new ResponseMessage();
		message.setEmailAdress("bindisha@gmail.com");
		message.setMailSentOn(Instant.now());
		message.setMailSentTo("SLB");
		message.setMessage("Downloading Please wait");
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	
	@PostMapping("/sendmail")
	public ResponseEntity<ResponseMessage> getDetails(@RequestBody Payload payload){
		
		emailSender.sendEmail(Arrays.asList("bindishaparmar01@gmail.com"),"TestMail", "text/sample.txt");
		
		ResponseMessage message = new ResponseMessage("bindisha@gmail.com", "Downloading Please wait", Instant.now(), "SLB");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
