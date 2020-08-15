<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion matiere</title>

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
      <h2>Gestion des matières</h2>
      <div class="container" style="padding-top: 30px">
	  <a class="btn btn-outline-dark" href="${pageContext.request.contextPath}/admin/formatiere" role="button">Ajouter une matière</a>	
	  <br></br>
	  
	<div class="row col-12">
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Libelle</th>
			<th scope="col">Liste des cours</th>
			<th scope="col">Responsable</th>
			<th scope="col">Supprimer</th>
			<th scope="col">Modifier</th>
		</tr>
		</thead>
		<c:forEach items="${attribut_liste_matiere_bdd}" var="matiereBDD">
			<tr>
				<td>${matiereBDD.libelle}</td>
				<td>
					<ul style="list-style: none;">
					<c:forEach items="${matiereBDD.listeCours}" var="cours">
						<li>${cours.libelle}</li>
					</c:forEach>	
					</ul>			
				</td>
				<td>${matiereBDD.enseignant.prenom} ${matiereBDD.enseignant.nom}</td>
				<td><a href="${pageContext.request.contextPath}/admin/supp/mat/${matiereBDD.idMatiere}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/admin/formodifmat/${matiereBDD.idMatiere}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
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