<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion du personnel</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>
<link href="${styleperso}" rel="stylesheet">
<%-- Insertion JS --%>


<spring:url value="/assets/scripts/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>
<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>

</head>
<body class="d-flex flex-column h-100">
		<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////   Fin de la navbar et début du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
<main role="main" class="flex-shrink-0">
 	 <div class="container-fluid" style="padding-top: 100px">
      <h2>Gestion du personnel</h2>
      <ul class="nav nav-tabs">
      	<li class="nav-item">
      		<a class="nav-link active" href="${pageContext.request.contextPath}/admin/listeadmin" style="font-weight: bold;">Administrateurs</a>
      	<li>
      	<li class="nav-item">
      		 <a class="nav-link" href="${pageContext.request.contextPath}/admin/listeenseignant">Enseignants</a>
      	<li>
      	<li class="nav-item">
      	 <a class="nav-link" href="${pageContext.request.contextPath}/admin/listeetudiant">Étudiants</a>
      	<li>
      </ul>
	</div>
	<div class="container" style="padding-top: 30px">
	<a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/admin/formadmin" role="button">Ajouter un administrateur</a>	

	<br></br>
	<div class="row col-12">
	<table class="table">
		<thead class="thead-dark">
		<tr >
			<th scope="col">Identifiant</th>
			<th scope="col">Nom</th>
			<th scope="col">Prenom</th>
			<th scope="col">Email</th>
			<th scope="col">Adresse</th>
			<th scope="col">Validité</th>
			<th scope="col">Supprimer</th>
			<th scope="col">Modifier</th>
			
		</tr>
		</thead>
		<c:forEach items="${attribut_liste_admin_bdd}" var="adminBDD">
			<tr >
				<td>${adminBDD.identifiant}</td>
				<td>${adminBDD.nom}</td>
				<td>${adminBDD.prenom}</td>
				<td>${adminBDD.email}</td>
				<td>${adminBDD.adresse.rue} ${adminBDD.adresse.codePostal} ${adminBDD.adresse.ville}</td>
				<td align="center">
				<c:choose>
					<c:when test="${adminBDD.actived == true }">
						<input type="checkbox" class="form-check-input" disabled="disabled" checked="checked" />
					</c:when>
					<c:otherwise>
						<input type="checkbox" class="form-check-input" disabled="disabled"/>
					</c:otherwise>
				</c:choose>
				</td>
				<td><a href="${pageContext.request.contextPath}/admin/supp/admin/${adminBDD.idPersonne}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/admin/formmodifadmin/${adminBDD.idPersonne}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</main>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
<jsp:include page="/assets/templates/footer.jsp"/>
	
<%-- Scripts JS --%>
<script src="${jquery}"></script>
<script src="${bootstrapJS}"></script>
	
</body>
</html>