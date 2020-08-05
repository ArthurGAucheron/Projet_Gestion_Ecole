<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Etudiants encore en vie</h1>
	<a href="${pageContext.request.contextPath}/admin/formulaireetudiant">Remplacer l'étudiant mangé par le chien</a>
	<table>
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
				<th>${etuBDD.identifiant}</th>
				<th>${etuBDD.motdePasse}</th>
				<th>${etuBDD.nom}</th>
				<th>${etuBDD.prenom}</th>
				<th>${etuBDD.email}</th>
				<th>${etuBDD.adresse.rue} ${etuBDD.codePostal} ${etuBDD.ville}</th>
				<th>${etuBDD.photo}</th>
				<th>${etuBDD.date_de_naissance}</th>
				<th>${etuBDD.promotion}</th>
				<th> <a href="${pageContext.request.contextPath}/etu/supp/idetu/${etuBDD.idPersonne}">Faire disparaître le corps</a> </th>
				<th> <a href="${pageContext.request.contextPath}/etu/formulairemodifetudiant/${etuBDD.idPersonne}">Changer sa sale tronche</a> </th>
			</tr>
		</c:forEach>
	</table>
	
	<br/><tr/><br/>
	
	<a href="${pageContext.request.contextPath}/index">Retour à l'index</a>

</body>
</html>