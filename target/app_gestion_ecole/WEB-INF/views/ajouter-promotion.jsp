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
		<h1>Formulaire d'ajout d'une promotion</h1>
	</div>
	<br />
	<br />

	<div align="center">


		<form:form modelAttribute="attributPromotion" method="POST" action="${pageContext.request.contextPath}/promotions/add">
			<table>
				<tr>
					<td><form:label path="libelle">libelle :</form:label></td>
					<td><form:input path="libelle" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Ajouter" /></td>
				</tr>
			</table>


		</form:form>

	</div>


</body>
</html>