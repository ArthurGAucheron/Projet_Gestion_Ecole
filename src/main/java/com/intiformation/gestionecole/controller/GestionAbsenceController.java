package com.intiformation.gestionecole.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.EtudiantCours;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.CoursServiceImpl;
import com.intiformation.gestionecole.service.EtudiantServiceImpl;
import com.intiformation.gestionecole.service.IEtudiantCoursService;
import com.intiformation.gestionecole.service.IEtudiantService;
import com.intiformation.gestionecole.service.PromotionServiceImpl;
import com.intiformation.gestionecole.utils.EtudiantCoursListContainer;

@Controller
public class GestionAbsenceController {

	@Autowired
	private CoursServiceImpl coursService;

	public void setCoursService(CoursServiceImpl coursService) {
		this.coursService = coursService;
	}
	
	@Autowired
	private PromotionServiceImpl promotionService;

	public void setPromotionService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}
	
	@Autowired
	private IEtudiantService etudiantService;

	public void setEtudiantService(EtudiantServiceImpl etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	@Autowired
	private IEtudiantCoursService etudiantCoursService;

		
	public void setEtudiantCoursService(IEtudiantCoursService etudiantCoursService) {
		this.etudiantCoursService = etudiantCoursService;
	}

	@Autowired
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}


	@RequestMapping(value="/ens/absence-form", method=RequestMethod.GET)
	public ModelAndView envoiFormulaireGestionAbsences(@RequestParam("idCours") Long pCoursID) {
		
		Cours cours = coursService.findById(pCoursID);
		Promotion promotion = promotionService.findById(cours.getPromotion().getIdPromotion());
		List<Etudiant> etudiants = etudiantService.findAllEtudiantsOfAPromotion(promotion.getIdPromotion());
		
		List<EtudiantCours> etudiantCours = etudiantCoursService.findAllByCourId(pCoursID);
		if (etudiantCours.isEmpty()) {
			for (Etudiant etudiant : etudiants) {
				etudiantCoursService.ajouter(new EtudiantCours(etudiant, cours));
			}
			etudiantCours = etudiantCoursService.findAllByCourId(pCoursID);
		}
		
		EtudiantCoursListContainer container = new EtudiantCoursListContainer();
		container.setEtudiantCours(etudiantCours);
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("coursAttribute", cours);
		donneesCommande.put("promotionAttribute", promotion);
		donneesCommande.put("etudiantCoursAttribute", container);
		
		return new ModelAndView("ajouter-absence", donneesCommande);
		
	}//end
	
	
	@RequestMapping(value="/ens/addabsences", method=RequestMethod.POST)
	public String enregistrerAbsence(@ModelAttribute("etudiantCoursAttribute") EtudiantCoursListContainer container) {
		
		List<EtudiantCours> etudiantCours = container.getEtudiantCours();
		SimpleMailMessage message = new SimpleMailMessage();
		String destinataire;
		String objet;
		String messageText;
		
		
		for (EtudiantCours etuCours : etudiantCours) {
			etudiantCoursService.modifier(etuCours);
			
			if (etuCours.isAbsence()==true) {
				destinataire = "gestionecole.inti@gmail.com";  // email de l'étudiant pour la démo on utilise 'gestionecole.inti@gmail.com'
				message.setTo(destinataire);
			
				Etudiant etudiantAbsent = etudiantService.findById(etuCours.getIdEtudiantsCours());
				Cours coursAbsent = coursService.findById(etuCours.getCours().getIdCours());
				
				objet = "Absence au cours : " + coursAbsent.getLibelle();
				message.setSubject(objet);
				
				messageText = "Bonjour " + etudiantAbsent.getNom() + " " + etudiantAbsent.getPrenom() + "\n" +
							   "Nous vous informons que vous avez été absent pour le cours  '" +  coursAbsent.getLibelle() + "' à la date du " + 
							   coursAbsent.getDate() + "\n Cordialement la direction de l'Université du Poitou";
				
				message.setText(messageText);
				
				this.mailSender.send(message);
			}
			
			
		
		}
		
		return "redirect:/ens/absence";
		
	}//end
	
	
	@RequestMapping(value="/etu/absence", method=RequestMethod.GET)
	public String envoiListeAbsenceParEleve(ModelMap modelMap) {
		
		List<EtudiantCours> etudiantCours = etudiantCoursService.findAllByEtudiantId(5L);
		
		modelMap.addAttribute("etudiantCoursAttribute", etudiantCours);
		
		return "consulter-absences";
		
	}//end
	
	@RequestMapping(value="/ens/absence", method=RequestMethod.GET)
	public String envoiListeAbsence(ModelMap modelMap) {
		
		List<EtudiantCours> etudiantCours = etudiantCoursService.findAll();
		etudiantCours = etudiantCours.stream().sorted((e1, e2) -> e2.getCours().getDate().compareTo(e1.getCours().getDate())).collect(Collectors.toList());
		
		modelMap.addAttribute("etudiantCoursAttribute", etudiantCours);
		
		return "gestion-absences";
		
	}//end
	
}
