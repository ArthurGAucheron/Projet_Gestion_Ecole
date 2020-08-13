<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Email</title>

<%-- Insertion feuille de style --%>
<spring:url value="/assets/styles/bootstrap.min.css" var="bootstrapCSS"></spring:url>
<link href="${bootstrapCSS}" rel="stylesheet">

<spring:url value="/assets/styles/styleperso.css" var="styleperso"></spring:url>

<%-- Insertion JS --%>
<spring:url value="/assets/scripts/bootstrap.bundle.min.js" var="bootstrapJS"></spring:url>
<spring:url value="/assets/scripts/jquery-3.5.1.min.js" var="jquery"></spring:url>
 	
 	<style type="text/css">
            #sendEmailBtn {
                float: left;
                margin-top: 22px;
            }
    </style>
</head>

<body>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////  header ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/header.jsp"/>
	
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--///////////////////////////////////////////////////////////   Contenu ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<main role="main" class="flex-shrink-0">
		<center>
		<br></br>	<br></br>	<br></br>
            <h2>Spring MVC Email Example</h2>
            <form id="sendEmailForm" method="post" action="sendEmail" enctype="multipart/form-data">
                <table id="emailFormBeanTable" border="0" width="80%">
                    <tr>
                        <td>Email To: </td>
                        <td><input id="receiverMail" type="text" name="mailTo" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Subject: </td>
                        <td><input id="mailSubject" type="text" name="subject" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Message: </td>
                        <td><textarea id="mailMessage" cols="50" rows="10" name="message"></textarea></td>
                    </tr>
                    <tr>
                        <td>Attachment: </td>
                        <td><input id="mailAttachment" type="file" name="attachFileObj" size="60" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input id="sendEmailBtn" type="submit" value="Send Email" /></td>
                    </tr>
                </table>
            </form>
        </center>
	</main>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<%--////////////////////////////////////////////////////////////   Footer ///////////////////////////////////////////////////////////////////////// --%>
	<%--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// --%>
	<jsp:include page="/assets/templates/footer.jsp"/>
	
	<%-- Scripts JS --%>
	<script src="${jquery}"></script>
	<script src="${bootstrapJS}"></script>
	
</body>
</html>