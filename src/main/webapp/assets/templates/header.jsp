<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- taglib core des jsp --%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- taglibs s de spring security --%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a href="${pageContext.request.contextPath}/index.jsp" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logo.jpg" style="max-width: 50px; margin-right: 15px" ></a>
	<a class="navbar-brand"	href="${pageContext.request.contextPath}/index.jsp">Universit� du Poitou</a>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
		
		<c:if test =  "${role == 'admin'}">
			<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">G�rer (admin)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listeadmin">Le personnel</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/matieres/liste">Les mati�res</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/cours/liste">Les cours</a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/promotions/liste">Les promotions</a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/aide">La page aide</a>
         		<a class="dropdown-item" href="#">Les absences</a>
       			</div>       			
      		</li>     	
      	</c:if>
      	
      	<c:if test =  "${role == 'ens'}">
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Consulter (ense)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/cours/liste">Les cours</a>
         		<a class="dropdown-item" href="#">R�capulatif des absences</a>
       			</div>
      		</li>
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">G�rer (ense)</a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="#">Mes cours</a>
         		<a class="dropdown-item" href="#">Les absences</a>
       			</div>
      		</li>
      	</c:if>
      	
      	<c:if test =  "${role == 'etu'}">
      		<li class="nav-item"><a class="nav-link" href="#">Mes cours (etu)</a></li>
      		<li class="nav-item"><a class="nav-link" href="#">Mes absences (etu)</a></li>
      	</c:if>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emailForm">Contact</a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aide">Aide</a></li>
		
		</ul>
		
		<ul class="navbar-nav mt-2 mt-md-2" style="align-content: right;" >
			<li class="nav-item dropdown">
        		<div class="btn-group dropleft">
  				<a style="color: white; font-weight: bold;" class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Identifiant</a>
			  <div class="dropdown-menu">
			   	<a class="dropdown-item" href="#">Mon Compte</a>
          		<a class="dropdown-item" href="#">Se d�connecter</a>
			  </div>
			</div>
      		</li>
		</ul>
		
		<%-- access : une condition sur le role de l'utilisateur --%>
		<s:authorize access="hasAnyRole('ens', 'admin', 'etu')">
			<%-- d�ja connect� => bouton se d�connecter --%>
			<a href="<c:url value='/logout'/>">Se d�connecter</a>
		</s:authorize>
		

		
	</div>
	</nav>
	</header> 

</body>
</html>