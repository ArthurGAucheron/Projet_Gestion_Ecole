<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.erreurs_validation{
			color: red;
			font-style: italic;
			margin: 15px
		}
</style>
</head>
<body>

	<h1>Ajouter un étudiant</h1>
	<br />
	
	<a href="${pageContext.request.contextPath}/admin/listeetudiant">Retour à la liste des etudiants</a>

	<div align="left">
	<form:form modelAttribute="etudiantAttribute" method="POST" action="${pageContext.request.contextPath}/admin/addetu" enctype="multipart/form-data">
		<form:errors path="*" cssClass="erreurs_validation" element="div" />
			<table>
				<tr>
					<td><form:label path="identifiant">Identifiant : </form:label></td>
					<td><form:input path="identifiant" /></td>
				</tr>
				<tr>
					<td><form:label path="motdePasse">Mot de passe : </form:label></td>
					<td><form:input path="motdePasse" /></td>
				</tr>
				<tr>
					<td><form:label path="nom">Nom : </form:label></td>
					<td><form:input path="nom" /></td>
				</tr>
				<tr>
					<td><form:label path="prenom">Prénom : </form:label></td>
					<td><form:input path="prenom" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email : </form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="adresse.rue">Rue : </form:label></td>
					<td><form:input path="adresse.rue" /></td>
				</tr>
				<tr>
					<td><form:label path="adresse.codePostal">Code Postal : </form:label></td>
					<td><form:input path="adresse.codePostal" /></td>
				</tr>
				<tr>
					<td><form:label path="adresse.ville">Ville : </form:label></td>
					<td><form:input path="adresse.ville" /></td>
				</tr>
				<tr>
					<td>Photo : </td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td><form:label path="dateNaissance">Date de naissance (aaaa-mm-jj) : </form:label></td>
					<td><form:input path="dateNaissance" /></td>
				</tr>
				<tr>
					<td><form:label path="promotion.idPromotion">Promotion :</form:label></td>
					<td><form:select path="promotion.idPromotion">
							<form:option value="" label="--- Promotion ---" />
							<form:options items="${promotionAttribute}" itemValue="idPromotion" itemLabel="libelle"/>
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Ajouter"></td>
				</tr>
			</table>
		
	</form:form>
	</div>
	<br />

	
</body>
</html>