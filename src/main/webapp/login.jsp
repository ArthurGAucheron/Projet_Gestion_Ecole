<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<head>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<title>Portail de connexion</title>

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/styles/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/styles/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #666666;">
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>
	
	<c:url value="login" var="loginUrl"/>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="${loginUrl}" method="post">
					<span class="login100-form-title p-b-43">
						Portail de connexion
					</span>
	

					<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++ -->
					<!-- ++++++++ Affichage des messages d'erreurs ++++++++ -->
					<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++ -->
					<%-- en cas d'echec de l'authentification --%>
					<c:if test="${not empty param.error}">
						<font style="color: red; font-style: italic;">
							Erreur d'authentification. Identification ou mot de passe invalide. <br/>
							<b>Raison</b> : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
						</font>
					</c:if>
					

					<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++ -->
					<!-- +++++++++ Formulaire d'authentification ++++++++++ -->
					<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="username">
						<span class="focus-input100"></span>
						<span class="label-input100">Identifiant</span>
					</div>
					
					
					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" name="password">
						<span class="focus-input100"></span>
						<span class="label-input100">Mot de passe</span>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Se connecter
						</button>						
					</div>
					
							
				</form>

				<div class="login100-more" style="background-image: url('assets/images/img.png'); ">
				</div>
			</div>
		</div>
	</div>
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/footer.jsp"/>

<!--===============================================================================================-->
	<script src="assets/scripts/jquery-3.4.1.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/scripts/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="assets/scripts/main.js"></script>

</body>


</html>







