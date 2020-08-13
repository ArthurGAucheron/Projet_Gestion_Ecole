<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>test dao cours</h1>
	
	<c:forEach items="${coursAttribute}" var="cours">
		
		<table>
			
			<tr>
				<td>id cours : </td>
				<td> ${cours.idCours} </td>
			</tr>
			
			<tr>
				<td>libelle : </td>
				<td> ${cours.libelle} </td>
			</tr>
			
			<tr>
				<td>id cours : </td>
				<td> ${cours.idCours} </td>
			</tr>
			
		</table>
		
	</c:forEach>

</body>
</html>