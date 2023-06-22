package com.slb.service.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

	private String emailAdress;
	private String message;
	private Instant mailSentOn;
	private String mailSentTo;
	
}
