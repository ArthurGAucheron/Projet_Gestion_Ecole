package com.intiformation.gestionecole.dao;

import java.util.List;

import com.intiformation.gestionecole.modele.Cours;

public interface ICoursDAO extends IGeneriqueDAO<Cours> {

	List<Cours> getCoursEns(Long pIdEns);

	List<Cours> getCoursEtu(Long pIdEtu);

}
