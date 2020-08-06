<%@page import="com.intiformation.gestionecole.service.MatiereServiceImpl"%>
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
		<h1>Formulaire d'ajout d'un cours</h1>
	</div>
	<br />
	<br />

	<div align="center">


		<%-- à la soumission du formulaire : invocation de la methode "ajoutercoursBDD()" --%>
		<form:form modelAttribute="coursCommand" method="POST"
			action="${pageContext.request.contextPath}/cours/add">


			<table width="60%">

				<tr>
					<td><form:label path="libelle">libelle :</form:label></td>
					<td><form:input path="libelle" /></td>

				</tr>
					
				<tr>
				
					<td><form:label path="matiere">matiere :</form:label></td>
					<td><form:select path="matiere">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${attribut_liste_matieres}" /> 
						</form:select></td>

				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>

			</table>


		</form:form>

	</div>


</body>
</html>