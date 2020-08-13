<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////   Fin de la navbar et début du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

 	 <div class="container-fluid" style="padding-top: 100px">
      <h2>Gestion du personnel</h2>
      <ul class="nav nav-tabs">
      	<li class="nav-item">
      		<a class="nav-link active" href="${pageContext.request.contextPath}/admin/listeadmin">Administrateurs</a>
      	<li>
      	<li class="nav-item">
      		 <a class="nav-link" href="${pageContext.request.contextPath}/admin/listeenseignant">Enseignants</a>
      	<li>
      	<li class="nav-item">
      	 <a class="nav-link" href="${pageContext.request.contextPath}/admin/listeetudiant">Étudiants</a>
      	<li>
      </ul>
	</div>

	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	
	<jsp:include page="/assets/templates/footer.jsp"/>
	
<%-- Scripts JS --%>
<script src="${jquery}"></script>
<script src="${bootstrapJS}"></script>	

</body>
</html>
