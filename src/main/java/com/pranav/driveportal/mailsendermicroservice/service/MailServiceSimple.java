package com.pranav.driveportal.mailsendermicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pranav.driveportal.mailsendermicroservice.model.MailModel;

@Service
public class MailServiceSimple {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public String sendMail(MailModel modelInst){
		
		var messageInst = new SimpleMailMessage();
		
		messageInst.setFrom(from);
		messageInst.setTo(modelInst.getTo());
		messageInst.setSubject(modelInst.getTitle());
		messageInst.setText(modelInst.getMessage());
		
		mailSender.send(messageInst);
		
		return "Successfully sent the appropriate message to "+modelInst.getTo();
	}

}
