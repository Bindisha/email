package com.slb.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slb.service.model.Payload;
import com.slb.service.model.ResponseMessage;
import com.slb.service.servImpl.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailApiController {
	
	@Autowired
	private EmailService emailService;
	
	@Value("${email.msg}")
	private String msg;
	
	@GetMapping("/sendmail")
	public ResponseEntity<ResponseMessage> getData(){
		ResponseMessage message = emailService.sendEmail(null,msg,"html/emailTemplate.html");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
	@PostMapping("/sendmail")
	public ResponseEntity<ResponseMessage> getDetails(@RequestBody Payload payload){
		ResponseMessage message = emailService.sendEmail(null,msg, "html/emailTemplate.html");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
