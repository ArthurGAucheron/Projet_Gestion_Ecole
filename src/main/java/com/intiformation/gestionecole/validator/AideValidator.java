package com.intiformation.gestionecole.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.gestionecole.modele.Aide;

/**
 * Validator pour le contenu aide <br/>
 * @author Arthur.GA
 *
 */
@Component
public class AideValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Aide.class.isAssignableFrom(clazz);
	}// end supports

	@Override
	public void validate(Object objetAValider, Errors errors) {
	

		ValidationUtils.rejectIfEmpty(errors, "pageLibelle", "required.pageLibelle", "Le titre de la page est obligatoire");
		ValidationUtils.rejectIfEmpty(errors, "contenu", "required.contenu", "Veuillez renseigner l'aide");
		
		Aide aide = (Aide) objetAValider;
		
	}// enb validate

}//end class
