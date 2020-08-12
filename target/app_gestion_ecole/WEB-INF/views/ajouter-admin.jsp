<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un administrateur</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>

<%-- Insertion JS --%>
<spring:url value="/assets/scripts/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>
<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>

</head>
<body class="d-flex flex-column h-100">
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--///////////////////////////////////////////////////////  Début de la navbar /////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	
	<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a href="${pageContext.request.contextPath}/index.jsp" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logo.jpg" style="max-width: 50px; margin-right: 15px" ></a>
	<a class="navbar-brand"	href="${pageContext.request.contextPath}/index.jsp">Université du Poitou</a>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gérer</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/gestionpersonnel">Le personnel</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/matieres/liste">Les matières</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/cours/liste">Les cours</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/promotions/liste">Les promotions</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/aide">La page aide</a>
         		<a class="dropdown-item" href="#">Les absences</a>
       			</div>
      		</li>	
		</ul>
		<ul class="navbar-nav mt-2 mt-md-2" style="align-content: right;" >
			<li class="nav-item dropdown">
        		<div class="btn-group dropleft">
  				<a style="color: white; font-weight: bold;" class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Identifiant</a>
			  <div class="dropdown-menu">
			   	<a class="dropdown-item" href="#">Mon Compte</a>
          		<a class="dropdown-item" href="#">Se déconnecter</a>
			  </div>
			</div>
      		</li>
		</ul>
		
	</div>
	</nav>
	</header> 
	
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////   Fin de la navbar et début du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	
	
	<main role="main" class="flex-shrink-0">
 	 <div class="container-fluid" style="padding-top: 100px;">
 	 <h1>Ajout d'un administrateur</h1>

	<a href="${pageContext.request.contextPath}/admin/listeadmin">Retour à la liste des administrateurs</a>
	
	<div class="container">
	<form:form modelAttribute="attributAdmin"  method="POST"  action="${pageContext.request.contextPath}/admin/addadmin">
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
<footer class="page-footer font-small blue">
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
   Arthur, Camille, Jérémie, Pierre-François, Yanis
  </div>
  <div class="row" >
        	<div class="col-md-12" style="text-align: center; " >
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoFR.jpg" style="max-width: 20px; margin-right: 15px" > </a>
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoES.jpg" style="max-width: 20px; margin-right: 15px" > </a>
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoEN.jpg" style="max-width: 20px; margin-right: 20px" > </a>
            </div>
        </div>
</footer>
	
<%-- Scripts JS --%>
<script src="${jquery}"></script>
<script src="${bootstrapJS}"></script>
	
</body>
</html>