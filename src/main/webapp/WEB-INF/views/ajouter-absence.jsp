<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gestion absence</title>

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
			<h1>Enregistrer les absents</h1>
			<h4>Cours : ${coursAttribute.libelle}</h4>
			<h4>Promotion : ${promotionAttribute.libelle}</h4>
			
			<a href="${pageContext.request.contextPath}/cours/liste">Retour à la liste des cours</a>

			<div class="container">
			<form:form modelAttribute="etudiantCoursAttribute" method="POST" action="${pageContext.request.contextPath}/ens/addabsences">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<table>
						<tr>
							<th>Nom :</th>
							<th>Prenom :</th>
							<th>Absent :</th>
							<th>Motif :</th>
						</tr>
						<c:forEach  var="etuCours" items="${etudiantCoursAttribute.etudiantCours}" varStatus="status">
							<tr>
								<td>${etuCours.etudiant.nom}</td>
								<td>${etuCours.etudiant.prenom}</td>
								<td><form:checkbox path="etudiantCours[${status.index}].absence"/> </td>
								<td><form:input path="etudiantCours[${status.index}].motif"/> </td>
								<td><form:hidden path="etudiantCours[${status.index}].cours.idCours"/> </td>
								<td><form:hidden path="etudiantCours[${status.index}].etudiant.idPersonne"/> </td>
								<td><form:hidden path="etudiantCours[${status.index}].idEtudiantsCours"/> </td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2"><input type="submit" value="Enregistrer"></td>
						</tr>
					</table>
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