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
<<<<<<< HEAD
	
	<br />
	
	<a href="${pageContext.request.contextPath}/matieres/liste">Gestion des mati�res</a>

	<br />

	<a href="${pageContext.request.contextPath}/cours/liste">Gestion des cours</a>

	<br />
	
	<a href="${pageContext.request.contextPath}/promotions/liste">Gestion des promotions</a>

	<br />
	
=======
	<br/>
	<a href="${pageContext.request.contextPath}/liste/matiere">Liste des mati�res</a>
	<br/>
	<a href="${pageContext.request.contextPath}/liste/cours">Liste des cours</a>
	<br/>
	<a href="${pageContext.request.contextPath}/aide">Page aide</a>
	<br/>
>>>>>>> 1abca6b0f4e3d9ea0b357cff68cbb8b23a7bb4c6
	
</body>
</html>