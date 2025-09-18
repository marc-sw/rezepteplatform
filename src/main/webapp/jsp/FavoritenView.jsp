<%@ page import="de.hwg_lu.bwi.jdbc.ConnectionManager" %>
<%@ page import="de.hwg_lu.bwi520.bean.AccountBean" %>
<%@ page import="de.hwg_lu.bwi.jdbc.FavoritTable" %>
<%@ page import="de.hwg_lu.bwi520.model.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="account" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session" />


<%
    String username = account.generateUsernameHTML();
    if ("Gast".equals(username)) {
%>
    <h2>Favoriten</h2>
    <p> Bitte anmelden, um Favoriten sehen zu können.</p>
    <%= account.generateAccountHTML() %>
<%
    } else {
    	FavoritTable favTable = new FavoritTable(ConnectionManager.getSharedConnection());
    	List<Rezept> rezepte = favTable.findRezepteByUser(username);
    	

        if (rezepte.isEmpty()) {
%>
            <p> Noch keine Favoriten gespeichert.</p>
<%
        } else {
%>
            <h2>Deine Favoriten</h2>
            <ul>
<%
            for (Rezept r : rezepte) {
%>
                <li>
                    <b><%= r.getTitel() %></b> – <%= r.getDauerMinuten() %> Minuten
                    <br>
                   <!--  <img src="images/ %= r.getBildname() %>" width="200px">-->
                </li>
<%
            }
%>
            </ul>
<%
        }
    }
%>

</body>
</html>