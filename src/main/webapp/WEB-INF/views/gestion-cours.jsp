<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion du des cours</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>
<link href="${styleperso}" rel="stylesheet">
<%-- Insertion JS --%>


<spring:url value="/assets/scripts/bootstrap.bundle.min.js"
	var="bootstrapJS"></spring:url>
<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>

</head>
<<<<<<< HEAD
<body>
<a href="${pageContext.request.contextPath}/formadd/cours">Ajouter un cours</a>
	<br></br>
	<table cellpadding="10" cellspacing="10" border="1">
		<tr>
			<th>Libelle</th>
			<th>Date</th>
			<th>Durée</th>
			<th>Description</th>
			<th>Matière</th>
			<th>Promotion</th>
		</tr>
		<c:forEach items="${attribut_liste_cours_bdd}" var="cours">
			<tr>
				<td>${cours.libelle}</td>
				<td>${cours.date} </td>
				<td>${cours.duree}</td>
				<td>${cours.description}</td>
				<td>${cours.matiere.libelle}</td>
				<td>${cours.promotion.libelle}</td>
				<td><a href="${pageContext.request.contextPath}/cours/delete/${cours.idCours}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/cours/update-cours-form?idCours=${cours.idCours}">Modifier</a></td>
				<td><a href="${pageContext.request.contextPath}/ens/absence-form?idCours=${cours.idCours}">Gérer les absences</a></td>
			</tr>
		</c:forEach>
	</table>
	<br></br>
	<a href="${pageContext.request.contextPath}/index.jsp">Retour à l'index</a>
=======
<body class="d-flex flex-column h-100">
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp" />

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////   Fin de la navbar et dÃ©but du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<main role="main" class="flex-shrink-0">
	<div class="container-fluid" style="padding-top: 100px">
		<h2>Gestion des cours</h2>
	</div>
	<div class="container" style="padding-top: 30px">
		<a class="btn btn-outline-dark"
			href="${pageContext.request.contextPath}/admin/formcours"
			role="button">Ajouter un cours</a> <br></br>
		<div class="row col-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Libelle</th>
						<th scope="col">Date</th>
						<th scope="col">DurÃ©e</th>
						<th scope="col">Description</th>
						<th scope="col">MatiÃ¨re</th>
						<th scope="col">Promotion</th>
					</tr>
				</thead>
				<c:forEach items="${attribut_liste_cours_bdd}" var="coursBDD">
					<tr>
						<td>${coursBDD.libelle}</td>
						<td>${coursBDD.date}</td>
						<td>${coursBDD.duree}</td>
						<td>${coursBDD.description}</td>
						<td>${coursBDD.matiere.libelle}</td>
						<td>${coursBDD.promotion.libelle}</td>
						<td><a
							href="${pageContext.request.contextPath}/cours/supp/cours/${coursBDD.idCours}">Supprimer</a></td>
						<td><a
							href="${pageContext.request.contextPath}/cours/formodifcours/${coursBDD.idCours}">Modifier</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</main>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/footer.jsp" />

	<%-- Scripts JS --%>
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>

>>>>>>> 2ab1d889986998f73bad01de23b97823954967b7
</body>
</html>