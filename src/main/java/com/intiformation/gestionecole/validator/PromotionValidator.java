package com.intiformation.gestionecole.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.gestionecole.modele.Promotion;

@Component
public class PromotionValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Promotion.class.isAssignableFrom(clazz);
	}//end supports

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelle","le champ est obligatoire");
		
	}//end validate

}//end class