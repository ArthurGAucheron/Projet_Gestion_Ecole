package com.intiformation.gestionecole.cryptage;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * permet de crypter le mot de passe.
 * utilisation de la classe spring security "BcryptPasswordEncoder" pour le cryptage des mdp.
 * @author yannis
 *
 */
public class PasswordEncoderGenerator {

	private static final String MOT_DE_PASSE = "789";
	
	/**
	 * mainmethod
	 * @param args
	 */
	public static void main(String[] args) {
		
		//objet pour le cryptage
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// cryptage du mot de passe avec la methode encode()
		String hashedMotDePasse = passwordEncoder.encode(MOT_DE_PASSE);
		
		// affichage du mdp crypté
		System.out.println("mot de passe crypté = " + hashedMotDePasse);
		
	}//end main
	
}//end class






