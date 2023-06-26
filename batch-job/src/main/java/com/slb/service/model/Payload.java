package com.slb.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payload {
	
	private String vendor;
	private String actionType;
	private String actionLevel;
	private String surveyId;
	private String productId;
	private String venderUrl;
	private String lineName;
	private String dimension;
	private String impersonatedUser;
}
