<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un cours</title>

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

	<main role="main" class="flex-shrink-0">
	<div class="container-fluid" style="padding-top: 100px;">
		<h1>Ajout d'un cours</h1>

		<a href="${pageContext.request.contextPath}/gestion-cours.jsp">Retour à la liste des cours</a>

		<div class="container">

			<form:form modelAttribute="attributCours" method="POST"
				action="${pageContext.request.contextPath}/cours/addcours">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<div class="row-form">
					<div class="form-group col-md-6">

						<form:label path="libelle">Libelle :</form:label>
						<form:input path="libelle" cssClass="form-control" />
						<form:errors path="libelle" cssClass="erreurs_validation" />

					</div>
				</div>
				<div class="row-form">
					<div class="form-group col-md-6">

						<form:label path="date">Date (jj/mm/aaaa ):</form:label>
						<form:input path="date" cssClass="form-control" />
						<form:errors path="date" cssClass="erreurs_validation" />
					</div>
				</div>
				<div class="row-form">
					<div class="form-group col-md-6">
						<form:label path="duree">Durée (en heures):</form:label>
						<form:input path="duree" cssClass="form-control" />
						<form:errors path="duree" cssClass="erreurs_validation" />
					</div>
				</div>

				<div class="row-form">
					<div class="form-group col-md-6">
						<form:label path="description">Description :</form:label>
						<form:input path="description" cssClass="form-control" />
						<form:errors path="description" cssClass="erreurs_validation" />
					</div>
				</div>
				<div class="row-form">
					<div class="form-group col-md-6">
						<form:label path="matiere.idMatiere">Matiere :</form:label>
						<form:select path="matiere.idMatiere" cssClass="form-control">
							<form:options items="${attributMatiere}" itemValue="idMatiere"
								itemLabel="libelle" />
						</form:select>

					</div>
				</div>
				<div class="row-form">
					<div class="form-group col-md-6">
						<form:label path="promotion.idPromotion">Promotion :</form:label>
						<form:select path="promotion.idPromotion" cssClass="form-control">
							<form:options items="${attributPromotion}"
								itemValue="idPromotion" itemLabel="libelle" />
						</form:select>
					</div>
				</div>
				<div class="row-form">
					<div class="form-group col-md-6">
						<input type="submit" value="Ajouter" class="btn btn-primary mb-2">
					</div>
				</div>
			</form:form>

		</div>
	</div>
	</main>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/footer.jsp" />

	<%-- Scripts JS --%>
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>
</body>
</html>