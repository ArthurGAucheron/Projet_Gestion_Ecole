package com.intiformation.gestionecole.service;

import java.util.List;
import java.util.Set;

public interface IGeneriqueService <T> {

	public void ajouter(T pT);
	
	public void modifier(T pT);
	
	public void supprimer(Long pIdT);
	
	public T findById(Long pIdT);
	
	public List<T> findAll();
	
}//end interface
