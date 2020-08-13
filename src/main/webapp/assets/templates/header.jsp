<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header> <nav
		class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"> <a
		href="${pageContext.request.contextPath}/index.jsp"
		style="text-decoration: none"><img
		src="${pageContext.request.contextPath}/assets/images/logo.jpg"
		style="max-width: 50px; margin-right: 15px"></a> <a
		class="navbar-brand"
		href="${pageContext.request.contextPath}/index.jsp">Université du
		Poitou</a>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="dropdown01"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gérer
					(admin)</a>
				<div class="dropdown-menu" aria-labelledby="dropdown01">
					<a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/gestionpersonnel">Le
						personnel</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/listemat">Les
						matières</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/listecours">Les
						cours</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/admin/listepromo">Les
						promotions</a> <a class="dropdown-item"
						href="${pageContext.request.contextPath}/aide">La page aide</a> <a
						class="dropdown-item" href="#">Les absences</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Consulter
					(ens)</a>
				<div class="dropdown-menu" aria-labelledby="dropdown01">
					<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/listecours">Les cours</a> 
						<a class="dropdown-item" href="#">Récapulatif des absences</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/ens/mesCours" id="dropdown01"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gérer
					(ens)</a>
				<div class="dropdown-menu" aria-labelledby="dropdown01">
					<a class="dropdown-item" href="#">Mes cours</a> <a
						class="dropdown-item" href="#">Les absences</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/etu/mesCours">Mes cours
					(etu)</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Mes
					absences (etu)</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/email">Contact</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/aide">Aide</a></li>
		</ul>

		<ul class="navbar-nav mt-2 mt-md-2" style="align-content: right;">
			<li class="nav-item dropdown">
				<div class="btn-group dropleft">
					<a style="color: white; font-weight: bold;"
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Identifiant</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">Mon Compte</a> <a
							class="dropdown-item" href="#">Se déconnecter</a>
					</div>
				</div>
			</li>
		</ul>

	</div>
	</nav> </header>

</body>
</html>