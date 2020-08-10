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
		<h1>Formulaire de modification d'un cours</h1>
	</div>
	<br />
	<br />

	<div align="center">
	
	<a href="${pageContext.request.contextPath}/gestion-cours.jsp">Retour à la liste des cours</a>

		<form:form modelAttribute="coursModifCommand" method="POST"
			action="${pageContext.request.contextPath}/cours/update">

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
</body>
</html>