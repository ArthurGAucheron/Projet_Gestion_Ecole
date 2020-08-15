<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des étudiants</title>

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
<body>

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp" />

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Contenu ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

	<main role="main" class="flex-shrink-0">
	<div class="container-fluid" style="padding-top: 100px">
		<h2>Gestion du personnel</h2>
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/listeadmin">Administrateurs</a>
			<li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/admin/listeenseignant">Enseignants</a>
			<li>
			<li class="nav-item "><a class="nav-link active" style="font-weight: bold;"
				href="${pageContext.request.contextPath}/admin/listeetudiant">Étudiants</a>
			<li>
		</ul>
	</div>
	<div class="container" style="padding-top: 30px">
		<a href="${pageContext.request.contextPath}/admin/formetu">Ajouter
			un etudiant</a> <br></br>
		<div class="row col-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Email</th>
						<th>Adresse</th>
						<th>Photo</th>
						<th>Date de naissance</th>
						<th>Promotion</th>
						<th>Validité</th>
						<th>Supprimer</th>
						<th>Modifier</th>
					</tr>
				</thead>
				<c:forEach items="${liste_etudiant_attribute}" var="etuBDD">
					<tr>
						<td>${etuBDD.identifiant}</td>
						<td>${etuBDD.nom}</td>
						<td>${etuBDD.prenom}</td>
						<td>${etuBDD.email}</td>
						<td>${etuBDD.adresse.rue}${etuBDD.adresse.codePostal}
							${etuBDD.adresse.ville}</td>
						<td><img src="data:image/png;base64,${etuBDD.base64}"
							height="100px" />
						<td>${etuBDD.dateNaissance}</td>
						<td>${etuBDD.promotion.libelle}</td>
						<td align="center"><input type="checkbox" class="form-check-input" disabled="disabled" checked="${etuBDD.actived}" /></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/supp/etu/${etuBDD.idPersonne}">supprimer</a>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/formmodifetu/${etuBDD.idPersonne}">modifier</a>
						</td>
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