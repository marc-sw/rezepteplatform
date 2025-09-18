<%@ page import="de.hwg_lu.bwi520.bean.AccountBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="ab" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session" />



<%
	String username = ab.generateUsernameHTML();


	if ("Gast".equals(username)) {
%>
        <h2>Favoriten</h2>
        <p> Bitte anmelden, um Favoriten sehen zu können.</p>
<%
    } 
%> 

</body>
</html>