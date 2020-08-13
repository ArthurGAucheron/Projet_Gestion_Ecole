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

<body class="d-flex flex-column h-100">
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp" />

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////    contenu ////////////////////////////////////////////////////////////// --%>
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
						<th scope="col">Durée</th>
						<th scope="col">Description</th>
						<th scope="col">Matière</th>
						<th scope="col">Promotion</th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
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
						<td><a href="${pageContext.request.contextPath}/ens/absence-form?idCours=${coursBDD.idCours}">Gérer les absences</a></td>
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

</body>
</html>