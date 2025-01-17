package com.EmailSender.MailSender.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.EmailSender.MailSender.Entity.EmailEntity;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String fromEmailId;
	@Autowired
	JavaMailSender javaMailSender;
	public void sendMail(EmailEntity emailEntity ) {
		
	String recipient=	emailEntity.getEmail();
	String subject = "Email Sender Test..... ";


	String body = "Hi  " + emailEntity.getName() + ",\n\n" +
	              "I was created the Email Sender project \n " +
	              "The project is developed by Spring Boot " + ".\n" +
	              " your registration details:\n" +
	              "-----------------------------------\n" +
	              "Name: " + emailEntity.getName() + "\n" +
	              "Email: " + emailEntity.getEmail() + "\n" +
	              "Course: " +emailEntity.getCourse() + "\n" +
	              "Domain: " + emailEntity.getDomain() + "\n" +
	              "Education: " + emailEntity.getEducation() + "\n" +
	              "Address: " + emailEntity.getAddress() + "\n" +
	              "-----------------------------------\n\n" +
	              "If you want the code then Contact me .\n\n" +
	              "Email: jadhavsatyam93@gmail.com\n" +
	              "Phone: +91 7447649595\n" ;
	             

	
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setFrom(fromEmailId);
		simpleMailMessage.setTo(recipient);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
	
		javaMailSender.send(simpleMailMessage);
		
	}
}
