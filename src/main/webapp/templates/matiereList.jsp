<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Liste des Matières</title>
</head>
<body>



	<h2>
		<u>Liste des matières</u>
	</h2>

	<c:forEach items="${matieresAttribute}" var="matiere">
		<table>
			<tr>
				<td>Id :</td>
				<td>${matiere.idMatiere}</td>
			</tr>
			<tr>
				<td>Libelle :</td>
				<td>${matiere.libelle}</td>
			</tr>
			<tr>
				<td>Liste des cours :</td>
				<td>${matiere.listeCours}</td>
			</tr>
		</table>
	</c:forEach>




</body>
</html>