<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<br />
	<br />
	<div>
		<h1>Formulaire d'ajout d'une matiere</h1>
	</div>
	<br />
	<br />

	<div align="center">


		<%-- � la soumission du formulaire : invocation de la methode "ajouterMatiereBDD()" --%>
		<form:form modelAttribute="matiereCommand" method="POST"
			action="${pageContext.request.contextPath}/matieres/add">


			<table width="60%">

				<tr>
					<td><form:label path="libelle">libelle :</form:label></td>
					<td><form:input path="libelle" /></td>

				</tr>
				<tr>
					<td><form:label path="listeCours">Liste des cours :</form:label></td>
					<td><form:select path="listeCours" items="${attribut_liste_cours}"
							itemValue="cours" itemLabel="nom_cours" multiple="true" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>

			</table>


		</form:form>

	</div>


</body>
</html>