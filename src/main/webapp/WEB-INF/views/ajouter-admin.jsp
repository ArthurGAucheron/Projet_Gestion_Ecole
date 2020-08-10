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
<link href="${styleperso}" rel="stylesheet">

<style type="text/css">
	.erreurs_validation{
		color: red;
		font-style: italic;
		margin: 15px
	}
</style>
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
 	 <div class="container" style="padding-top: 100px">
 	 <h1>Ajout d'un administrateur</h1>

	<a href="${pageContext.request.contextPath}/admin/listeadmin">Retour à la liste des administrateurs</a>
	<br></br>
	
	<div align="left">
	<form:form modelAttribute="attributAdmin"  method="POST"  action="${pageContext.request.contextPath}/admin/addadmin">
		<form:errors path="*" cssClass="erreurs_validation" element="div" />
		<div class="form-group">
		<table>
			<tr>
				<td><form:label path="identifiant">Identifiant</form:label></td>
				<td><form:input path="identifiant"/></td>
				<td><form:errors pahth="identifiant" cssClass="erreurs_validation"/>
			</tr>
			<tr>
				<td><form:label path="motdePasse">Mot de passe</form:label></td>
				<td><form:password path="motdePasse" id="mdp"/></td>
				<td><form:errors pahth="motdePasse" cssClass="erreurs_validation"/>
			</tr>
			<tr>
				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom"/></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prénom</form:label></td>
				<td><form:input path="prenom"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email"/></td>
				<td><form:errors pahth="email" cssClass="erreurs_validation"/>
			</tr>
			<tr>
				<td><form:label path="adresse.rue">Rue</form:label></td>
				<td><form:input path="adresse.rue"/></td>
			</tr>
			<tr>
				<td><form:label path="adresse.codePostal">Code Postal</form:label></td>
				<td><form:input path="adresse.codePostal"/></td>
			</tr>
			<tr>
				<td><form:label path="adresse.ville">Ville</form:label></td>
				<td><form:input path="adresse.ville"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Ajouter">
				</td>
		   </tr>
		</table>
		</div>
	</form:form>
	
	</div>
	</div>
</main>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12" style="text-align: center; " >
               Développer avec tendresse par l'équipe Lotus
            </div>
        </div>
        <div class="row" >
        	<div class="col-md-12" style="text-align: center; " >
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoFR.jpg" style="max-width: 20px; margin-right: 15px" > </a>
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoES.jpg" style="max-width: 20px; margin-right: 15px" > </a>
              	<a href="#" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logoEN.jpg" style="max-width: 20px; margin-right: 20px" > </a>
            </div>
        </div>
    </div>
</footer>
	
<%-- Scripts JS --%>
<script src="${jquery}"></script>
<script src="${bootstrapJS}"></script>
	
</body>
</html>