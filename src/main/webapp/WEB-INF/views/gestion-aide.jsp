<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Administrateur</title>

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
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gérer (admin)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listeadmin">Le personnel</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/matieres/liste">Les matières</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/cours/liste">Les cours</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/promotions/liste">Les promotions</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/aide">La page aide</a>
         		<a class="dropdown-item" href="#">Les absences</a>
       			</div>
      		</li>
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Consulter (ense)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/cours/liste">Les cours</a>
         		<a class="dropdown-item" href="#">Récapulatif des absences</a>
       			</div>
      		</li>
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gérer (ense)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="#">Mes cours</a>
         		<a class="dropdown-item" href="#">Les absences</a>
       			</div>
      		</li>
      		<li class="nav-item"><a class="nav-link" href="#">Mes cours (etu)</a></li>
      		<li class="nav-item"><a class="nav-link" href="#">Mes absences (etu)</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/email">Contact</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aide">Aide</a></li>
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
 	 <div class="container-fluid" style="padding-top: 100px">
      <h2>Page Aide</h2>
      <div class="container" style="padding-top: 30px">
	 <div class="row col-12">
	<form:form modelAttribute="AttributAideAjout"  method="POST"  action="${pageContext.request.contextPath}/aide/admin/add" cssStyle="border : 1px solid black; padding : 5px" >
		<form:errors path="*" cssClass="erreurs_validation" element="div" />
	
			<div class="form-group md-3">	
				<form:input path="pageLibelle" cssClass="form-control" placeholder="pageLibelle" cssStyle="margin-right : 15px; "/>
				<form:errors pahth="pageLibelle" cssClass="erreurs_validation"/>
			</div>
			<div class="form-group md-6">	
				<form:textarea path="contenu" placeholder="contenu" cssStyle="margin-right : 15px; padding : 50px;"/>
				<form:errors pahth="contenu" cssClass="erreurs_validation"/>
			</div>
			<div class="form-group md-3" >
				<input type="submit" value="Ajouter une aide" class="btn btn-outline-dark">
			</div>
	  </form:form>
	  </div>
	  <br></br>
	  
	<div class="row col-12">
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Page</th>
			<th scope="col">Aide</th>
			<th scope="col">Supprimer</th>
			<th scope="col">Modifier</th>
		</tr>
		</thead>
		<c:forEach items="${attributAide}"   var="aide">
			<tr>
				<td>${aide.pageLibelle}</td>
				<td>${aide.contenu}</td>
				<td><a href="${pageContext.request.contextPath}/aide/admin/delete/${aide.idAide}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/aide/admin/update/${aide.idAide}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
	</div>
</main>
	<%--  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
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