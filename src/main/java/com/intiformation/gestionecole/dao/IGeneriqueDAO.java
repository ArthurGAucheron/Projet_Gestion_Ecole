package com.intiformation.gestionecole.dao;

import java.util.List;

public interface IGeneriqueDAO <T> {

	public void add(T pT);
	
	public void update(T pT);
	
	public void delete(Long pIdT);
	
	public T getById(Long pIdT);
	
	public List<T> getAll();
	
}//end interface
