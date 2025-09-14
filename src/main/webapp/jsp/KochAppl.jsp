<%@page import="de.hwg_lu.bwi520.bean.AccountBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ab" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session"></jsp:useBean>
<%
String registrieren = request.getParameter("Registrieren");
String anmelden = request.getParameter("Anmelden");
if(registrieren == null) registrieren ="";
if(anmelden == null) anmelden = "";
System.out.println(registrieren);
System.out.println(anmelden);
String username = request.getParameter("username");
String passwort = request.getParameter("passwort");

<<<<<<< Updated upstream
if (registrieren.equals("Registrieren")){
	ab.register(username, passwort);
} else if (anmelden.equals("Anmelden")){
	ab.login(username, passwort);
=======
if (registrieren.equals("registrieren")){
	
	response.sendRedirect("./StartView.jsp");
} if (anmelden.equals("anmelden")){
	
	response.sendRedirect("./StartView.jsp");
}else{
	response.sendRedirect("./StartView.jsp");
>>>>>>> Stashed changes
}
response.sendRedirect("./StartView.jsp");		
		
%>
</body>
</html>