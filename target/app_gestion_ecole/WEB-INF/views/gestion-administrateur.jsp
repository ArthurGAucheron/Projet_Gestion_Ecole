<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des administrateur</title>
</head>
<body>
	<h1>Gestion des Administrateur</h1>
	<a href="${pageContext.request.contextPath}/admin/formadmin">Ajouter un administrateur</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Identifiant</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<th>Adresse</th>
			<th>Supprimer</th>
			<th>Modifier</th>
		</tr>
		<c:forEach items="${attribut_liste_admin_bdd}" var="adminBDD">
			<tr>
				<td>${adminBDD.libelle}</td>
				<td></td>
				<td><a href="#">Supprimer</a></td>
				<td><a href="#">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/admin/gestionpersonnel">Retour � la gestion du personel</a>
</body>
</html>