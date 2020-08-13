<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un étudiant</title>

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
		<h1>Modifier les données d'un étudiant</h1>
		<a href="${pageContext.request.contextPath}/admin/listeetudiant">Retour
			à la liste des étudiants</a>

		<div class="container">
			<form:form modelAttribute="modifEtudiantAttribute" method="POST"
				action="${pageContext.request.contextPath}/admin/updateetu"
				enctype="multipart/form-data">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<table>
					<tr>
						<td><form:hidden path="idPersonne" /></td>
					</tr>

					<tr>
						<td><form:label path="identifiant">Identifiant : </form:label></td>
						<td><form:input path="identifiant" /></td>
					</tr>
					<tr>
						<td><form:label path="motdePasse">Mot de passe : </form:label></td>
						<td><form:input path="motdePasse" /></td>
					</tr>
					<tr>
						<td><form:label path="nom">Nom : </form:label></td>
						<td><form:input path="nom" /></td>
					</tr>
					<tr>
						<td><form:label path="prenom">Prénom : </form:label></td>
						<td><form:input path="prenom" /></td>
					</tr>
					<tr>
						<td><form:label path="email">Email : </form:label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><form:label path="adresse.rue">Rue : </form:label></td>
						<td><form:input path="adresse.rue" /></td>
					</tr>
					<tr>
						<td><form:label path="adresse.codePostal">Code Postal : </form:label></td>
						<td><form:input path="adresse.codePostal" /></td>
					</tr>
					<tr>
						<td><form:label path="adresse.ville">Ville : </form:label></td>
						<td><form:input path="adresse.ville" /></td>
					</tr>
					<tr>
						<td><form:label path="photo">Photo : </form:label></td>
						<td><form:hidden path="photo" /></td>
						<td><input type="file" name="file" /></td>
					</tr>
					<tr>
						<td><form:label path="dateNaissance">Date de naissance (jj/mm/aaaa) : </form:label></td>
						<td><form:input path="dateNaissance" /></td>
					</tr>
					<tr>
						<td><form:label path="promotion.idPromotion">Promotion :</form:label></td>
						<td><form:select path="promotion.idPromotion">
								<form:option value="" label="--- Promotion ---" />
								<form:options items="${promotionAttribute}"
									itemValue="idPromotion" itemLabel="libelle" />
							</form:select></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Modifier">
						</td>
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