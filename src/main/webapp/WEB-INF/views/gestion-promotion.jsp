<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<%--/////////////////////////////////////////  contenu //////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
<main role="main" class="flex-shrink-0">
 	 <div class="container-fluid" style="padding-top: 100px">
      <h2>Gestion des promotions</h2>
      <div class="container" style="padding-top: 30px">
	  
	  <form:form  modelAttribute="attributPromotion" method="POST" action="${pageContext.request.contextPath}/promotions/add" cssClass="form-inline">
	  	<div class="row-form">
			<div class="form-group col-md-6">	
				<form:input path="libelle" cssClass="form-control" placeholder="libelle"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >
				<input type="submit" value="Ajouter une promotion" class="btn btn-outline-dark">
			</div>
		</div>
	  </form:form>
	  
	  
	  <br></br>
	  
	<div class="row col-12">
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th scope="col">Libelle</th>
			<th scope="col">Liste des cours</th>
			<th scope="col">Supprimer</th>
			<th scope="col">Modifier</th>
		</tr>
		</thead>
		<c:forEach items="${attribut_liste_promotion_bdd}"  var="promo">
			<tr>
				<td>${promo.libelle}</td>
				<td>
					<ul>
					<c:forEach items="${promo.listeCours}" var="cours">
						<li>${cours.libelle}</li>
					</c:forEach>	
					</ul>			
				</td>
				<td><a href="${pageContext.request.contextPath}/promotions/delete/${promo.idPromotion}">Supprimer</a></td>
				<td><a href="${pageContext.request.contextPath}/promotions/update-promotion-form?idPromotion=${promo.idPromotion}">Modifier</a></td>
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