<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<%-- Insertion JS --%>
<spring:url value="/assets/scripts/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>


<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>


</head>
<body>

	<h1>Hello ! Ceci est la page d'accueil (index.jsp) !</h1>


	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/index.jsp">Université de
		Grosville</a>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/gestionpersonnel">Gestion du personnel</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/matieres/liste">Gestion des matières</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/cours/liste">Gestiondes des cours</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/promotions/liste">Gestion des promotions </a></li>
			<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aide">Page aide</a></li>
		
			<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
		
		
		
		
		
		</ul>
		<ul style="list-style: none; margin: 0 0 0 0;" >
			<li style="list-style: none; color: white;">admin01<li>
			<li style="list-style: none; color: white;">adresse@mail.fr<li>
		</ul>
	</div>
	
	
	</nav>

<script src="${jquery}"></script>
<script src="${bootstrapJS}"></script>
</body>
</html>