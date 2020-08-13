<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aide</title>
</head>
<body>
<h1>Page aide</h1>
	<a href="${pageContext.request.contextPath}/aide/admin/form">Ajouter une aide</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Page</th>	
		</tr>
		<c:forEach items="${attributAide}" var="aide">
			<tr>
				<td>${aide.pageLibelle}</td>
				<td>${aide.contenu}</td>
				<td><a href="${pageContext.request.contextPath}/aide/admin/delete/${aide.idAide}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/aide/admin/update/${aide.idAide}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à l'index</a>
</body>
</html>