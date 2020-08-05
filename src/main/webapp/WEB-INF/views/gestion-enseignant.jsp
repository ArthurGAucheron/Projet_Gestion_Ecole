<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des enseignants</title>
</head>
<body>
	<h1>Gestion des enseignants</h1>
	<a href="${pageContext.request.contextPath}/admin/formens">Ajouter un enseignants</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Identifiant</th>
			<th>Mot de passe</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<th>Adresse</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
		<c:forEach items="${attribut_liste_enseignant_bdd}" var="ensBDD">
			<tr>
				<td>${ensBDD.identifiant}</td>
				<td>${ensBDD.motdePasse}</td>
				<td>${ensBDD.nom}</td>
				<td>${ensBDD.prenom}</td>
				<td>${ensBDD.email}</td>
				<td>${ensBDD.adresse.rue} ${ensBDD.adresse.codePostal} ${ensBDD.adresse.ville} </td>
				<td><a href="${pageContext.request.contextPath}/admin/supp/ens/${ensBDD.idPersonne}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/admin/formmodifens/${ensBDD.idPersonne}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/admin/gestionpersonnel">Retour à la gestion du personel</a>
</body>
</html>