<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Hello ! Ceci est la page d'accueil (index.jsp) !</h1>
	
	<a href="${pageContext.request.contextPath}/admin/gestionpersonnel">Gestion du personnel</a>
	
	<br />
	
	<a href="${pageContext.request.contextPath}/liste/matiere">Liste des mati�res</a>

	<br />

	<a href="${pageContext.request.contextPath}/liste/cours">Liste des cours</a>

	<br />
	
	
</body>
</html>