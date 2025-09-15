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
<jsp:useBean id="account" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session"></jsp:useBean>
<%	
	String username = request.getParameter("username");
	String passwort = request.getParameter("passwort");	
	
	if (request.getParameter("Registrieren") != null)
	{
		account.register(username, passwort);
	} 
	else if (request.getParameter("Anmelden") != null)
	{
		account.login(username, passwort);
	} 
	else if (request.getParameter("abmelden") != null) 
	{
		account.logout();
	}
	response.sendRedirect("./StartView.jsp");		
		
%>
</body>
</html>