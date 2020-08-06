<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Administrateur</title>
</head>
<body>
	<h1>Modification d'un Administrateur</h1>
	<br></br>
	<a href="${pageContext.request.contextPath}/admin/listeadmin">Retour à la liste des administrateurs</a>
	<br></br>
	<form:form modelAttribute="attrtibutAdminModif" method="POST" action="${pageContext.request.contextPath}/admin/updateadmin">
	<table>
			<tr>
				<td><form:hidden path="idPersonne"/></td>
			</tr>
			
			<tr>
				<td><form:hidden path="identifiant" /></td>
			</tr>
			<tr>
				<td><form:label path="motdePasse">Mot de passe</form:label></td>
				<td><form:input path="motdePasse"/></td>
			</tr>
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom"/></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prénom</form:label></td>
				<td><form:input path="prenom"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td><form:hidden path="adresse.idAdresse"/></td>	
			<tr>
			<tr>
				<td><form:label path="adresse.rue">Rue</form:label></td>
				<td><form:input path="adresse.rue"/></td>
			</tr>
			<tr>
				<td><form:label path="adresse.codePostal">Code Postal</form:label></td>
				<td><form:input path="adresse.codePostal"/></td>
			</tr>
			<tr>
				<td><form:label path="adresse.ville">Ville</form:label></td>
				<td><form:input path="adresse.ville"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Modifier">
				</td>
		   </tr>
		</table>
	</form:form>
	
</body>
</html>