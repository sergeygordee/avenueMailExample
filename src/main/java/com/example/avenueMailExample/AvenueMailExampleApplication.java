package com.example.avenueMailExample;

import com.example.avenueMailExample.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvenueMailExampleApplication {
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(AvenueMailExampleApplication.class, args);
		System.out.println("http://localhost:8099/");
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail(){
//		emailService.sendMail(
//				"sergeyspringemail@gmail.com",
//				"sergey.gordeev.000@mail.ru",
//				"This is email subject",
//				"This is email message");
//		System.out.println("Mail sended");
//	}

//@EventListener(ApplicationReadyEvent.class)
//public void triggerMail() throws MessagingException {
//	emailService.sendMailWithAttachment(
//			"sergeyspringemail@gmail.com",
//			"sergey.gordeev.000@mail.ru",
//			"This is email subject ith attachment",
//			"This is email message with attachment",
//			"" + "spring-overview.png");
//	System.out.println("Mail with attachment send suncessfuly");
//}

}
