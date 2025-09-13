<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BWI520</title>
<link rel="stylesheet" href="../css/kochCSS.css">
</head>
<body>

	<header>
        <h1>(name)</h1>
        <p>Finde und teile deine leckeren Rezepte!</p>
        
        <div class="login-box">
            <form action="LoginView.jsp" method="post">
                <table>
                    <tr>
                        <td><input type="text" name="email" placeholder="E-Mail"></td>
                   </tr>
                    <tr> 
                    	<td><input type="password" name="passwort" placeholder="Passwort"></td> 
                    </tr>
                     <tr> 
                       <td><button type="submit">Anmelden</button> 
                       <button type="button" >Registrieren</button></td>
                    </tr>
                </table>
            </form>
        </div>
        
    </header>
    <nav>
        <a href="RezeptErstellenView.jsp">+ Rezept erstellen</a>
        <a href="SucheView.jsp?zutat=">🔍 Rezepte suchen</a>
        <a href="FavoritHinzufuegenView.jsp">⭐ Favoriten</a>
    </nav>
    
    <main>
    
        <h2>Willkommen!</h2> <!-- Wenn man eingeloggt ist, dann soll da stehen "Willkommen, (Benutzername)!" -->
        <p>Nutze das Menü, um dein Lieblingsrezept zu finden oder selbst eines zu erstellen!</p>

        
    </main>
    		
    <footer>
        &copy; 2025 (name) Projekt | BWI520
    </footer>
    
</body>
</body>
</html>