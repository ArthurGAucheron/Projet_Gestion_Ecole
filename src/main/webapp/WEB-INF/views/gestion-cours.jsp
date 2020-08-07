<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des cours</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/formadd/cours">Ajouter un cours</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Libelle</th>
			<th>Matière associée</th>
		</tr>
		<c:forEach items="${attribut_liste_cours_bdd}" var="cours">
			<tr>
				<td>${cours.libelle}</td>
				<td>${cours.matiere.libelle} </td>
				<td><a href="#">Supprimer</a></td>
				<td><a href="#">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à l'index</a>
</body>
</html>