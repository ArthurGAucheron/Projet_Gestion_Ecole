<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- taglib core des jsp --%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%-- taglibs s de spring security --%>
<%@taglib prefix="s" uri="http://www.springframework.org/security/tags" %>   

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<a href="${pageContext.request.contextPath}/index" style="text-decoration: none"><img src="${pageContext.request.contextPath}/assets/images/logo.jpg" style="max-width: 50px; margin-right: 15px" ></a>
	<a class="navbar-brand"	href="${pageContext.request.contextPath}/index"><spring:message code="header.universite"/></a>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
		
		<s:authorize access="hasAnyRole('ROLE_ADMIN')">
			<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="header.gerer"/></a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listeadmin"><spring:message code="header.personnel"/></a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listemat"><spring:message code="header.matierte"/></a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listecours"><spring:message code="header.cours"/></a>
          		<a class="dropdown-item" href="${pageContext.request.contextPath}/admin/listepromo"><spring:message code="header.promotion"/></a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/aide"><spring:message code="header.aide"/></a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/absence"><spring:message code="header.absence"/></a>
       			</div>       			
      		</li>     	
      </s:authorize>
      	
      <s:authorize access="hasAnyRole('ROLE_ENS')">
      		<li class="nav-item dropdown">

        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="header.consulter"/></a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/listecours"><spring:message code="header.cours"/></a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/absence"><spring:message code="header.absence.recp"/></a>
       			</div>
      		</li>
      		<li class="nav-item dropdown">
        		<a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="header.gerer"/></a>
       			<div class="dropdown-menu" aria-labelledby="dropdown01">
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/mesCours"><spring:message code="header.cours.mes"/></a>
         		<a class="dropdown-item" href="${pageContext.request.contextPath}/ens/absence"><spring:message code="header.absence"/></a>
       			</div>
      		</li>
        </s:authorize>
      	
      	 <s:authorize access="hasAnyRole('ROLE_ETU')">
      		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/etu/mesCours"><spring:message code="header.cours.mes"/></a></li>
      		<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/etu/absence"><spring:message code="header.absence.mes"/></a></li>
      	</s:authorize>

			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/emailForm"><spring:message code="header.contact"/></a></li>
			<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/aide"><spring:message code="header.aide"/></a></li>
		
		</ul>
		
		<ul class="navbar-nav mt-2 mt-md-2" style="align-content: right;" >
			<li class="nav-item dropdown">
        		<div class="btn-group dropleft">
  				<a style="color: white; font-weight: bold;" class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  				<spring:message code="header.identifiant"/> : <s:authentication property="name"/></a>
			  <div class="dropdown-menu">
			   	<a class="dropdown-item" href="#"><spring:message code="header.compte"/></a>
          	    <a class="dropdown-item" href="<c:url value='/logout'/>"><spring:message code="header.deco"/></a>
			  </div>
			</div>
      		</li>
		</ul>
	
	
		
	</div>
	</nav>
	</header> 

</body>
</html>