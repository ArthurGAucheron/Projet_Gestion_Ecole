package com.intiformation.gestionecole.modele;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * modèle de données pour un Enseignant, hérite de la classe abstraite 'Personne'
 * @author cam
 *
 */
@Entity
@Table(name="enseignants")
public class Enseignant extends Personne  {

public Enseignant() {
}
	
}//end class
