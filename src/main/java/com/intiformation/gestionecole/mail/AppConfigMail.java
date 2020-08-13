package com.intiformation.gestionecole.mail;



import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfigMail {

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		// Using mail
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("gestionecole.inti@gmail.com");
		mailSender.setPassword("ProjetEcole+1");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
	    javaMailProperties.put("mail.smtp.auth", "true");
	    javaMailProperties.put("mail.transport.protocol", "smtp");
	    javaMailProperties.put("mail.debug", "true");
	    
	    mailSender.setJavaMailProperties(javaMailProperties);
	    return mailSender;
	
	}
	
}// end class
