<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="de.hwg_lu.bwi520.bean.AccountBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BWI520</title>
<link rel="stylesheet" href="../css/kochCSS.css">
</head>
<body>
	<jsp:useBean id="account" class="de.hwg_lu.bwi520.bean.AccountBean" scope="session" />
	<header>
        <h1>(name)</h1>
        <p>Finde und teile deine leckeren Rezepte!</p>
        
        <div class="login-box">
            <%=account.generateAccountHTML() %>
        </div>
        
    </header>
    <nav>
        <a href="RezeptErstellenView.jsp">+ Rezept erstellen</a>
        <a href="SucheView.jsp?zutat=">🔍 Rezepte suchen</a>
        <a href="FavoritHinzufuegenView.jsp">⭐ Favoriten</a>
    </nav>
    
    <main>
    
        <h2>Willkommen <%=account.generateUsernameHTML() %>!</h2> <!-- Wenn man eingeloggt ist, dann soll da stehen "Willkommen, (Benutzername)!" -->
        <p>Nutze das Menü, um dein Lieblingsrezept zu finden oder selbst eines zu erstellen!</p>

        
    </main>
    		
    <footer>
        &copy; 2025 (name) Projekt | BWI520
    </footer>
    
</body>
</body>
</html>