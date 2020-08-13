<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--ajout de la taglib de spring mvc 'form' --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modifier-matière</title>
</head>
<body>


	<br />
	<br />
	<div>
		<h1>Formulaire de modification d'une matière</h1>
	</div>
	<br />
	<br />

	<div align="center">

		<form:form modelAttribute="matiereModifCommand" method="POST"
			action="${pageContext.request.contextPath}/matieres/update">

			<table width="60%">
				<!-- recup de l'id dans un champ caché -->
				<tr>
					<td><form:hidden path="idMatiere" /></td>
				</tr>
				<tr>
					<td><form:label path="libelle">Libelle :</form:label></td>
					<td><form:input path="libelle" /></td>
				</tr>
				<tr>
					<td><form:label path="enseignant.idPersonne">Enseignant résponsable</form:label></td>
					<td><form:select path="enseignant.idPersonne">
							<form:option value="NONE" label="${matiereModifCommand.enseignant.nom}"/>
							<form:options items="${attributEnseignant}" itemValue="idPersonne" itemLabel="nom" /> 
						</form:select></td>

				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="Appliquer les modifications" /></td>
				</tr>

			</table>


		</form:form>

	</div>




</body>
</html>