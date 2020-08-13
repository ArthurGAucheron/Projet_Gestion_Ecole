<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un cours</title>

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

	<div class=container-fluid style="padding-top: 100px;">
		<h1>Modification d'un cours</h1>
		<a href="${pageContext.request.contextPath}/gestion-cours.jsp">Retour
			à la liste des cours</a> <br></br>

		<div class="container">



			<form:form modelAttribute="coursModifCommand" method="POST"
				action="${pageContext.request.contextPath}/updatecours">

				<table width="60%">
					<!-- recup de l'id dans un champ caché -->
					<tr>
						<td><form:hidden path="idCours" /></td>
					</tr>
					<tr>
						<td><form:label path="libelle">Libelle :</form:label></td>
						<td><form:input path="libelle" /></td>
					</tr>

					<tr>
						<td><form:label path="date">Date (jj/mm/aaaa ):</form:label></td>
						<td><form:input path="date" /></td>
					</tr>

					<tr>
						<td><form:label path="duree">Durée (en heures):</form:label></td>
						<td><form:input path="duree" /></td>
					</tr>

					<tr>
						<td><form:label path="description">Description :</form:label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><form:label path="matiere.idMatiere">Matiere :</form:label></td>
						<td><form:select path="matiere.idMatiere">
								<form:options items="${attributMatiere}" itemValue="idMatiere"
									itemLabel="libelle" />
							</form:select></td>

					</tr>
					<tr>
						<td><form:label path="promotion.idPromotion">Promotion :</form:label></td>
						<td><form:select path="promotion.idPromotion">
								<form:options items="${attributPromotion}"
									itemValue="idPromotion" itemLabel="libelle" />
							</form:select></td>

					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="Appliquer les modifications" /></td>
					</tr>

				</table>


			</form:form>
		</div>
	</div>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>

	<jsp:include page="/assets/templates/footer.jsp" />

	<%-- Scripts JS --%>
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>
</body>
</html>