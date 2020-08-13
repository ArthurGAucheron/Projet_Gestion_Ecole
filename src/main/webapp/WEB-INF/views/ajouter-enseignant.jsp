<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un enseignant</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>

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
	<%--/////////////////////////////////////////   Fin de la navbar et début du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	
	
	<main role="main" class="flex-shrink-0">
 	 <div class="container-fluid" style="padding-top: 100px;">
 	 <h1>Ajout d'un enseignant</h1>

	<a href="${pageContext.request.contextPath}/admin/listeenseignant">Retour à la liste des enseignants</a>
	
	<div class="container">
	<form:form  modelAttribute="attributEns"  method="POST"  action="${pageContext.request.contextPath}/admin/addens">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<div class="row-form">
			<div class="form-group col-md-6">	
				<form:label path="identifiant">Identifiant</form:label>
				<form:input path="identifiant" cssClass="form-control"/>
				<form:errors pahth="identifiant" cssClass="erreurs_validation"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6">
				<form:label path="motdePasse">Mot de passe</form:label>
				<form:password path="motdePasse" cssClass="form-control"/>
				<form:errors pahth="motdePasse" cssClass="erreurs_validation"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >	
				<form:label path="nom">Nom</form:label>
				<form:input path="nom" cssClass="form-control"/>
			</div>
			<div class="form-group col-md-6">
				<form:label path="prenom">Prénom</form:label>
				<form:input path="prenom" cssClass="form-control"/>
			</div>
		</div>		
		<div class="row-form">	
			<div class="form-group col-md-6">
				<form:label path="email">Email</form:label>
				<form:input path="email" cssClass="form-control"/>
				<form:errors pahth="email" cssClass="erreurs_validation"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >
				<form:label path="adresse.rue">Rue</form:label>
				<form:input path="adresse.rue" cssClass="form-control"/>
				<form:label path="adresse.codePostal">Code Postal</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control"/>
				<form:label path="adresse.ville" >Ville</form:label>
				<form:input path="adresse.ville" cssClass="form-control"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >
				<input type="submit" value="Ajouter" class="btn btn-primary mb-2">
			</div>
		</div>
	</form:form>
	
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