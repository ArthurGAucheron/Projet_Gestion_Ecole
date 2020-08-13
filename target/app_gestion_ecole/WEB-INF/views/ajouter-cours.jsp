<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<a href="${pageContext.request.contextPath}/gestion-cours.jsp">Retour à la liste des cours</a>
	<br />
	<br />

	<div align="center">

		<form:form modelAttribute="attributCours" method="POST"
			action="${pageContext.request.contextPath}/cours/add">
			<table>
				<tr>
					<td><form:label path="libelle">Libelle :</form:label></td>
					<td><form:input path="libelle" /></td>
					<td><form:errors path="libelle" cssStyle="color:red; font-style:italic;"/></td>
				</tr>

				<tr>
					<td><form:label path="date">Date (jj/mm/aaaa ):</form:label></td>
					<td><form:input path="date" /></td>
					<td><form:errors path="date" cssStyle="color:red; font-style:italic;"/></td>
				</tr>

				<tr>
					<td><form:label path="duree">Durée (en heures):</form:label></td>
					<td><form:input path="duree" /></td>
					<td><form:errors path="duree" cssStyle="color:red; font-style:italic;"/></td>
				</tr>

				<tr>
					<td><form:label path="description">Description :</form:label></td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description" cssStyle="color:red; font-style:italic;"/></td>
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
					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>
			</table>
		</form:form>

	</div>


</body>
</html>