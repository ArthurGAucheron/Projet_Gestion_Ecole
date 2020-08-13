package com.intiformation.gestionecole.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {

	@Autowired
	public JavaMailSender emailSender;
	
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ModelAndView goToSendEmail() {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("gestionecole.inti@gmail.com");
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributMail", message);
		
		return new ModelAndView("send-email", donneesCommande);
		
		
	}
	
	@RequestMapping(value="/send/email", method=RequestMethod.POST )
	public String sendSimpleEmail(@ModelAttribute("attributMail")@Validated SimpleMailMessage message) {
		

		
		this.emailSender.send(message);
		
		
		return "redirect:/email";
		
		
	}
}// end class
