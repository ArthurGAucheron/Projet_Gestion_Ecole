<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>
	
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////   Fin de la navbar et d�but du contenu ////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

	<div class=container-fluid style="padding-top: 100px;">
	<h1>Modification d'un Administrateur</h1>
	<a href="${pageContext.request.contextPath}/matieres/liste">Retour � la liste des mati�res</a>
	<br></br>
	
	<div class="container">
	<form:form modelAttribute="matiereModifCommand" method="POST" action="${pageContext.request.contextPath}/matieres/update">
		
	<form:hidden path="idMatiere"/>

		<div class="row-form">
			<div class="form-group col-md-6">
				<form:label path="libelle">Libelle :</form:label>
				<form:input path="libelle" cssClass="form-control"/>
			
			</div>
		</div>
		<div class="row-form">
			<div class="form-group col-md-6" >	
				<form:label path="enseignant.idPersonne">Enseignant r�sponsable</form:label>
					<form:select path="enseignant.idPersonne">
					
							<form:options items="${attributEnseignant}" itemValue="idPersonne" itemLabel="nom" /> 
				   </form:select>
			</div>	
		</div>		
		<div class="row-form">
			<div class="form-group col-md-6" >
				<input type="submit" value="Modifier" class="btn btn-primary mb-2">
			</div>
		</div>
	</form:form>
	</div>
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