<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello ! Ceci est la page d'accueil (index.jsp) !</h1>

	<a href="${pageContext.request.contextPath}/matieres/liste">lien
		vers la page 'liste-matieres.jsp'</a>

	<br />

	<a href="${pageContext.request.contextPath}/cours/liste">lien vers
		la page 'liste-cours.jsp'</a>

	<br />


</body>
</html>