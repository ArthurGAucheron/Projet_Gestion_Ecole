<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des étudiants</title>
</head>
<body>

	<h1>Gestion des étudiants</h1>
	<a href="${pageContext.request.contextPath}/admin/formetu">Ajouter un etudiant</a>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Identifiant</th>
			<th>Mot de passe</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<th>Adresse</th>
			<th>Photo</th>
			<th>Date de naissance</th>
			<th>Promotion</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
		<c:forEach items="${liste_etudiant_attribute}" var="etuBDD">
			<tr>
				<td>${etuBDD.identifiant}</td>
				<td>${etuBDD.motdePasse}</td>
				<td>${etuBDD.nom}</td>
				<td>${etuBDD.prenom}</td>
				<td>${etuBDD.email}</td>
				<td>${etuBDD.adresse.rue} ${etuBDD.adresse.codePostal} ${etuBDD.adresse.ville}</td>
				<td><img src="data:image/png;base64,${etuBDD.base64}" height="100px"/></th>
				<td>${etuBDD.dateNaissance}</td>
				<td>${etuBDD.promotion.libelle}</td>
				<td> <a href="${pageContext.request.contextPath}/admin/supp/idetu/${etuBDD.idPersonne}">supprimer</a> </td>
				<td> <a href="${pageContext.request.contextPath}/admin/formulairemodifetudiant/${etuBDD.idPersonne}">modifier</a> </td>
			</tr>
		</c:forEach>
	</table>
	
	<br/><br/>
	
	<a href="${pageContext.request.contextPath}/admin/gestionpersonnel">Retour à la gestion du personel</a>

</body>
</html>