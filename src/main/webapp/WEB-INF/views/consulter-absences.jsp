<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultation absence</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>

<%-- Insertion JS --%>
<spring:url value="/assets/scripts/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>
<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>

</head>
<body>

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Contenu ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

	<main role="main" class="flex-shrink-0">
 		<div class="container-fluid" style="padding-top: 100px;">
			<h1>Absence :</h1>
		</div>
		<div class="container" style="padding-top: 30px">	
			<br></br>
			<div class="row col-12">
			<table class="table">
				<thead class="thead-dark">
				<tr>
					<th scope="col">Cours</th>
					<th scope="col">Date</th>
					<th scope="col">Motif</th>
				</tr>
				</thead>
				<c:forEach items="${etudiantCoursAttribute}" var="etuCours">
					<tr>
						<td>${etuCours.cours.libelle}</td>
						<td>${etuCours.cours.date}</td>
						<td>${etuCours.motif}</td>
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