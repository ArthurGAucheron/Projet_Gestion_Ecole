package com.intiformation.gestionecole.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Personne;

/**
 * <pre>
 * 	Implémentation d'un validator <br/>
 * 	Gestion du remplissage des formulaires ajouter admin/enseignant/etudiant <br/>
 * <pre>
 * @author arthu
 *
 */
@Component
public class PersonneValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Personne.class.isAssignableFrom(clazz);
	
	}// end supports

	@Override
	public void validate(Object objetValider, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors, "identifiant", "required.identifiant", "L'identifiant est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "motdePasse", "required.motdePasse", "Le mot de passe est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "email", "required.email", "L'email est obligatoire");
		
		Personne personne = (Personne) objetValider;
		
		if (personne.getEmail().isEmpty() == false) {
			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(personne.getEmail());
			System.out.println(" le pattern est : " + matcher.matches());

			if (matcher.matches() == false) {
				errors.rejectValue("email", "pattern.email", "Le format de l'adresse email est incorrecte");
			}
		}
		
		
	}// end validate

	
	
}// end class
