package com.pranav.driveportal.mailsendermicroservice.controller;

import com.pranav.driveportal.mailsendermicroservice.model.MailModelAttachments;
import com.pranav.driveportal.mailsendermicroservice.service.MailWithAttachments;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

import com.pranav.driveportal.mailsendermicroservice.model.MailModel;
import com.pranav.driveportal.mailsendermicroservice.service.MailServiceSimple;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/send-mail")
@CrossOrigin
public class MailController {
	
	//http://localhost:8100/send-mail/notespranav@gmail.com/TEST MAIL FOR DEV PURPOSE/Hi this is a test mail
	
	private final MailServiceSimple serviceInst;

	private final MailWithAttachments serviceInstAttch;

	public MailController(MailServiceSimple serviceInst, MailWithAttachments serviceInstAttch) {
		super();
		this.serviceInst = serviceInst;
        this.serviceInstAttch = serviceInstAttch;
    }
	
	@GetMapping(value="/{to}/{title}/{message}")
	private String sendMail(@PathVariable String to,@PathVariable String title,@PathVariable String message) {
		String retMsg =  serviceInst.sendMail(new MailModel(to, title, message));
		return retMsg;
	}

	@PostMapping(value="/with-attachments/{title}/{message}")
	public boolean sendMailWithAttachments(@RequestParam("mailList") List<String> mailList,@PathVariable String title, @PathVariable String message, @RequestParam("files") List<MultipartFile> fileList) throws MessagingException, IOException {


		return serviceInstAttch.sendMailWithAttachments(new MailModelAttachments(message,title,fileList,mailList));
	}

	//http://localhost:8100/send-mail/with-attachments/{to}/{title}/{message}

}
