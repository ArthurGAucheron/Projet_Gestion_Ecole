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

	<h1>
		<u>Liste des promotions</u>
	</h1>


	<table border="1" width="60%">

		<%-- en-tête de la table --%>

		<tr>
			<td colspan="5" align="right"><a
				style="background-color: lightBlue;"
				href="${pageContext.request.contextPath}/promotions/add-promotion-form">
					Ajouter une promotion </a></td>
		</tr>


		<tr>
			<th>ID promotion</th>
			<th>Libellé promotion</th>
			<th>liste des cours</th>
			<th>liste des étudiants</th>
			<th>Modifier</th>
			<th>Supprimer</th>
		</tr>

		<%-- données de la table --%>
		<c:forEach items="${attribut_liste_promotions}" var="promo">
			<tr>
				<td>${promo.idPromotion}</td>
				<td>${promo.libelle}</td>
				<td><ul>
						<c:forEach items="${promo.listeCours}" var="cours">
							<li>${cours.libelle}</li>
						</c:forEach>
					</ul>
					<ul>
						<c:forEach items="${promo.listeEtudiants}" var="etu">
							<li>${etu.nom}</li>
						</c:forEach>
					</ul></td>

				<!-- colonne pr la modif -->
				<td>
					<!-- envoi d'une req HTTP GET vers la méthode "afficherFormulaireModification()" du controleur "EmployeController" mappée à l'url '/employes/update-employe-form?idemploye=1'  -->
					<a
					href="${pageContext.request.contextPath}/promotions/update-promotion-form?idpromotion=${promo.idPromotion}">modifier</a>
				</td>

				<!-- colonne pr la supresssion -->
				<td>
					<!-- envoi d'une req HTTP GET vers la méthode "supprimerEmployeBdd()" du controleur "EmployeController" mappée à l'url '/employes/delete/1'  -->
					<a
					href="${pageContext.request.contextPath}/matieres/delete/${promo.idPromotion}">supprimer</a>
				</td>


			</tr>
		</c:forEach>

	</table>
</body>
</html>