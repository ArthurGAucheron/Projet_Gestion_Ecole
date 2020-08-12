<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'une aide</title>
</head>
<body>
<h1>Modification d'une aide</h1>
	<br></br>
	<a href="${pageContext.request.contextPath}/aide">Retour à la page aide</a>
	<br></br>
	<form:form modelAttribute="attributAideModif" method="POST" action="${pageContext.request.contextPath}/aide/admin/update">
	<table>
			<tr>
				<td><form:hidden path="idAide"/></td>
			</tr>
			<tr>
				<td><form:label path="pageLibelle">Titre de la page</form:label></td>
				<td><form:input path="pageLibelle"/></td>
			</tr>
			<tr>
				<td><form:label path="contenu">Contenu</form:label></td>
				<td><form:textarea path="contenu"/></td>
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