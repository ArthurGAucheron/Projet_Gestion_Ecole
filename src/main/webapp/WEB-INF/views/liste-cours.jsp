<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%--Traitement des donn�es envoy�es par le controleur 'MatiereController" et sa methode "recupererListeMatieresBdd" --%>

	<h1>
		<u>Liste des cours</u>
	</h1>

	<table border="1" width="60%">

		<%-- en-t�te de la table --%>

		<tr>
			<td colspan="5" align="right">
				<%--envoi d'une rq HTTP GET vers la methode "afficherFormulaireAjout()" du controleur mappee vers l'url '/employes/add-employe-form'  --%>
				<a style="background-color: lightBlue;"
				href="${pageContext.request.contextPath}/cours/add-cours-form">
					Ajout d'un cours </a>
			</td>
		</tr>


		<tr>
			<th>ID cours</th>
			<th>Libell� cours</th>
			<th>liste des mati�res</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>

		<%-- donn�es de la table --%>
		<c:forEach items="${attribut_liste_cours}" var="cours">
			<tr>
				<td>${cours.idCours}</td>
				<td>${cours.libelle}</td>
				<td>${cours.matiere}</td>
				

				<!-- colonne pr la modif -->
				<td>
					<!-- envoi d'une req HTTP GET vers la m�thode "afficherFormulaireModification()" du controleur "EmployeController" mapp�e � l'url '/employes/update-employe-form?idemploye=1'  -->
					<a
					href="${pageContext.request.contextPath}/matieres/update-matiere-form?idmatiere=${matiere.idMatiere}">modifier</a>
				</td>

				<!-- colonne pr la supresssion -->
				<td>
					<!-- envoi d'une req HTTP GET vers la m�thode "supprimerEmployeBdd()" du controleur "EmployeController" mapp�e � l'url '/employes/delete/1'  -->
					<a
					href="${pageContext.request.contextPath}/matieres/delete/${matiere.idMatiere}">supprimer</a>
				</td>


			</tr>
		</c:forEach>

	</table>



</body>
</html>