package com.EmailSender.MailSender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmailSender.MailSender.Entity.EmailEntity;
import com.EmailSender.MailSender.Service.EmailService;

;

@Controller
public class EmailController {

	@Autowired
	private EmailService emailService;
	@GetMapping("/")
	String register(Model model) {
		model.addAttribute("emailEntity",new EmailEntity());
		return "Registration";
	}
	@PostMapping("/send")
	String send(@ModelAttribute("emailEntity") EmailEntity emailEntity, Model model) {
		emailService.sendMail(emailEntity);
		model.addAttribute("successMessage", "Email sent successfully!");
	    return "redirect:/?success=true";
	}
}
