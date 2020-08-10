package com.intiformation.gestionecole.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.gestionecole.modele.Cours;

@Component
public class CoursValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Cours.class.isAssignableFrom(clazz);
	}//end supports

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelle","le champ est obligatoire");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description","le champ est obligatoire");

		Cours cours = (Cours) target ;
		
		if (cours.getDuree()<0) {
			
			errors.rejectValue("duree", "notallowed.duree","la valeur du champ ne peut pas être négative" );
			
		}else if (cours.getDuree()==0) {
			
			errors.rejectValue("duree","required.duree","la valeur du champ ne peut pas être nulle");	
		}
		
	}//end validate

}//end class
