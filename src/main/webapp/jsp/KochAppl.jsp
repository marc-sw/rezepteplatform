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
String registrieren = request.getParameter("registrieren");
String anmelden = request.getParameter("anmelden");
if(registrieren == null) registrieren ="";
if(anmelden == null) anmelden = "";

String username = request.getParameter("username");
String passwort = request.getParameter("passwort");

if (registrieren.equals("registrieren")){
	ab.register(username, passwort);
	response.sendRedirect("./StartView.jsp");
} if (anmelden.equals("anmelden")){
	ab.login(username, passwort);
	response.sendRedirect("./StartView.jsp");
}else{
	response.sendRedirect("./StartView.jsp");
}
		
		
%>
</body>
</html>