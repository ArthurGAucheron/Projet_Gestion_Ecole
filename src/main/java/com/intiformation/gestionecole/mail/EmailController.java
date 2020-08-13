package com.intiformation.gestionecole.mail;



import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

	String emailToRecipient;
	String emailSubject;
	String emailMessage;
	
	// Adresse email émettrice
	static final String emailFromRecipient = "gestionecole.inti@gmail.com";
	
	static ModelAndView modelViewObj;
	
	@Autowired
	private JavaMailSender mailSenderObj;
	
	public void setMailSenderObj(JavaMailSender mailSenderObj) {
		this.mailSenderObj = mailSenderObj;
	}

	@RequestMapping(value="/emailForm", method=RequestMethod.GET)
	public ModelAndView emailForm(ModelMap model) {
		modelViewObj = new ModelAndView("email-form");
		return modelViewObj;
	}// end emailForm()
	
	@RequestMapping(value="sendEmail", method=RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {
		
		// Lecture des paramètres du formulaire d'envoie d'un email
		emailSubject = request.getParameter("subject");
		emailMessage = request.getParameter("message");
		emailToRecipient = request.getParameter("mailTo");
		
		System.out.println("\nDestinataire = " + emailToRecipient + " , Sujet = " + emailSubject + " , Message = " + emailMessage + "\n");
		
		mailSenderObj.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);
				
				// Test si le client à attaché une pièce jointe au mail
				if ((attachFileObj != null) && (attachFileObj.getSize()>0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name = " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {
						@Override
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\n Le mail n'a pas de pièce jointe");
				}
				
			}
		});
		System.out.println("\nMessage envoyé avec succés");
		modelViewObj = new ModelAndView("sucess-mail", "messageObj", "Merci, votre message à été envoyé avec succés");
		return modelViewObj;
		
	}
	
}// end class
