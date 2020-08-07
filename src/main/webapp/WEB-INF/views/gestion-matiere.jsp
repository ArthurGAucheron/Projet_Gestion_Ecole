<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion matiere</title>
</head>
<body>
<h1>Gestion des matières</h1>
	<a href="${pageContext.request.contextPath}/formadd/matiere">Ajouter une matière</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Libelle</th>
			<th>Liste des cours</th>
		</tr>
		<c:forEach items="${attribut_liste_matiere_bdd}" var="matiereBDD">
			<tr>
				<td>${matiereBDD.libelle}</td>
				<td>
					<ul>
					<c:forEach items="${matiereBDD.listeCours}" var="cours">
						<li>${cours.libelle}</li>
					</c:forEach>	
					</ul>			
				</td>
				<td><a href="${pageContext.request.contextPath}/matieres/delete/${matiereBDD.idMatiere}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/matieres/update-matiere-form?idMatiere=${matiereBDD.idMatiere}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à l'index</a>
</body>
</html>