<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout une aide</title>
<style type="text/css">
	.erreurs_validation{
		color: red;
		font-style: italic;
		margin: 15px
	}
</style>
</head>
<body>
<h1>Ajouter une aide</h1>
	<br></br>

	<a href="${pageContext.request.contextPath}/aide">Retour à la page d'aide</a>
	<br></br>
	
	<div align="left">
	<form:form modelAttribute="attributAide"  method="POST"  action="${pageContext.request.contextPath}/aide/admin/add">
		<form:errors path="*" cssClass="erreurs_validation" element="div" />
		<table>
			<tr>
				<td><form:label path="pageLibelle">Intitulé de la page</form:label></td>
				<td><form:input path="pageLibelle"/></td>
				<td><form:errors pahth="pageLibelle" cssClass="erreurs_validation"/>
			</tr>
			<tr>
				<td><form:label path="contenu">Contenue</form:label></td>
				<td><form:textarea path="contenu"/></td>
				<td><form:errors pahth="contenu" cssClass="erreurs_validation"/></td>
			</tr>
			<tr>
				
				<td colspan="2">
					<input type="submit" value="Ajouter">
				</td>
		   </tr>
		</table>
	</form:form>
	</div>
</body>
</html>