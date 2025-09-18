<%@ page import="de.hwg_lu.bwi520.bean.RezeptBean" %>
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
<jsp:useBean id="rezept" class="de.hwg_lu.bwi520.bean.RezeptBean" scope="request" />


<%
    // Prüfen, ob ein User eingeloggt ist
    Integer userId = (Integer) session.getAttribute("userId");

    if (userId == null) {
%>
    <h2>Favoriten</h2>
    <p>Bitte anmelden, um Favoriten sehen zu können.</p>
<% } %>

</body>
</html>