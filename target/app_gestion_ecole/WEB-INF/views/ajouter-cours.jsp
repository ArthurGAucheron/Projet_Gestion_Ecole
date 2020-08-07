<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<form:form modelAttribute="attributCours" method="POST" action="${pageContext.request.contextPath}/cours/add">
			<table>
				<tr>
					<td><form:label path="libelle">Libelle :</form:label></td>
					<td><form:input path="libelle" /></td>
				</tr>
				
				<tr>
					<td><form:label path="date">Date :</form:label></td>
					<td><form:input type="date" path="date" /></td>
				</tr>
				
				<tr>
					<td><form:label path="duree">Dur�e :</form:label></td>
					<td><form:input path="duree" /></td>
				</tr>
				
				<tr>
					<td><form:label path="description">Description :</form:label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><form:label path="matiere.idMatiere">Matiere :</form:label></td>
					<td><form:select path="matiere.idMatiere">
							<form:option value="Mati�re : none" label="--- Mati�re ---" />
							<form:options items="${attributMatiere}" itemValue="idMatiere" itemLabel="libelle" /> 
						</form:select></td>

				</tr>
				<tr>
					<td><form:label path="promotion.idPromotion">Promotion :</form:label></td>
					<td><form:select path="promotion.idPromotion">
							<form:option value="Promotion : none" label="--- Promotion ---" />
							<form:options items="${attributPromotion}" itemValue="idPromotion" itemLabel="libelle" /> 
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