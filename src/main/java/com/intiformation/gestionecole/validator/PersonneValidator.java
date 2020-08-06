package com.intiformation.gestionecole.validator;

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
		
		Personne personne = (Personne) objetValider;
		
	}// end validate

	
	
}// end class
