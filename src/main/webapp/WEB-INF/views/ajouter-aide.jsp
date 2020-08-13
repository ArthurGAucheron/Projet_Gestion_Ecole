<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter une aide</title>

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


	<div class="container-fluid" style="padding-top: 100px;">
		<h1>Ajout d'une aide</h1>

		<a href="${pageContext.request.contextPath}/aide">Retour à la page
			d'aide</a>

		<div class="container">
			<form:form modelAttribute="attributAide" method="POST"
				action="${pageContext.request.contextPath}/aide/admin/add">
				<form:errors path="*" cssClass="erreurs_validation" element="div" />
				<table>
					<tr>
						<td><form:label path="pageLibelle">Intitulé de la page</form:label></td>
						<td><form:input path="pageLibelle" /></td>
						<td><form:errors pahth="pageLibelle"
								cssClass="erreurs_validation" />
					</tr>
					<tr>
						<td><form:label path="contenu">Contenue</form:label></td>
						<td><form:textarea path="contenu" /></td>
						<td><form:errors pahth="contenu"
								cssClass="erreurs_validation" /></td>
					</tr>
					<tr>

						<td colspan="2"><input type="submit" value="Ajouter">
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

	<jsp:include page="/assets/templates/footer.jsp" /></body>
</html>