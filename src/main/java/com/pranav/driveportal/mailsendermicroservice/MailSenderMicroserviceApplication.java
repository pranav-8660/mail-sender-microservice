package com.pranav.driveportal.mailsendermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class MailSenderMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSenderMicroserviceApplication.class, args);
	}

}
