<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'accueil</title>

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

	<%-- Fin de la navbar et début du contenu --%> 
	
	<main role="main" class="flex-shrink-0">
   <div class="container-fluid" style="padding-top: 100px;">
 	 <h1>Envoie d'un email</h1>
	
	<div class="container">
	<form:form modelAttribute="attributMail"  method="POST"  action="${pageContext.request.contextPath}/send/email">
		<form:hidden path="to"/>
		<div class="row-form">
			<div class="form-group col-md-6">	
				<form:label path="subject">Objet</form:label>
				<form:input path="subject" cssClass="form-control"/>
			</div>
		</div>
		
		<div class="row-form">
			<div class="form-group col-md-6">
				<form:label path="text">Contenu</form:label>
				<form:textarea path="text" cssClass="form-control"/>
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >
				<input type="submit" value="Envoyer" class="btn btn-primary mb-2">
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