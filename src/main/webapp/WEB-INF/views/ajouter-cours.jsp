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


		<%-- à la soumission du formulaire : invocation de la methode "ajouterMatiereBDD()" --%>
		<form:form modelAttribute="attributCours" method="POST" action="${pageContext.request.contextPath}/cours/add">
			<table>
				<tr>
					<td><form:label path="libelle">libelle :</form:label></td>
					<td><form:input path="libelle" /></td>
				</tr>
				<tr>
					<td>List des matières disponibles</td>
				</tr>
					<c:forEach items="${attributMatiere}" var="matiereBDD" >
					<tr>
						<td>${matiereBDD.idMatiere}</td>
						<td>${matiereBDD.libelle}</td>	
					</tr>
					</c:forEach>
				<tr>
					<td><form:label path="matiere.idMatiere">Saisir l'id de la matière souhaité</form:label></td>
					<td><form:input path="matiere.idMatiere" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Ajouter" /></td>
				</tr>
			</table>
		</form:form>

	</div>


</body>
</html>