package com.intiformation.gestionecole.modele;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * classe de liaison 'Enseigne'
 * regroupe différents IDs pour lier les classes 'Enseignant', 'Matiere' et 'Promotion'
 * @author cam
 *
 */
public class Enseigne {
	
	/* ______Propriétés________ */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_enseigne")
	private Long idEnseigne ;
	
	@Column(name="enseignant_id")
	private Long enseignantId;
	
	@Column(name="matiere_id")
	private Long matiereId;
	
	@Column(name="promotion_id")
	private Long promotionId;

	/* ______Constructeurs________ */

	public Enseigne() {
	}
	
	/* ______Getters/Setters________ */

	public Long getEnseignantId() {
		return enseignantId;
	}

	public void setEnseignantId(Long enseignantId) {
		this.enseignantId = enseignantId;
	}

	public Long getMatiereId() {
		return matiereId;
	}

	public void setMatiereId(Long matiereId) {
		this.matiereId = matiereId;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	
	public Long getIdEnseigne() {
		return idEnseigne;
	}

	public void setIdEnseigne(Long idEnseigne) {
		this.idEnseigne = idEnseigne;
	}
	
	/* ______toString()________ */

	@Override
	public String toString() {
		return "Enseigne [enseignantId=" + enseignantId + ", matiereId=" + matiereId + ", promotionId=" + promotionId
				+ "]";
	}

	





}//end class
