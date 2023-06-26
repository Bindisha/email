package com.slb.service.servImpl;

import java.util.List;

import com.slb.service.model.ResponseMessage;

public interface EmailService {
	public ResponseMessage sendEmail(List<String> receiptTo,String subject,String template);	
}
