<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezepte Suchen</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel ="stylesheet" href="css/bootstrap.min.css">
<link rel ="stylesheet" href="../css/kochCSS.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<%-- 
	
	<form action="rezeptAppl.jsp" method="get">
		<div class="p-3 mb-2 bg-dark text-white"></div>
		<table>
		<tr>
		<td>
		<h3>Rezept suche</h3></td>
	    <td><input type="text" name="suchbegriff" placeholder="Rezept eingeben..."/></td>
		<td><input type="submit" name="btnSuchen" value="suchen"></td>
		</tr>
		</table>
		<table>
		<tr>
		<td class ="category"><a href="Suppen.jsp"><img src="../img/suppen.jpg" class="card-img-top"/><br>Suppen</a></td>
		<td class="category"><a href="Hauptspeissen.jsp"><img src="../img/hauptspeisse.jpg" class="card-img-top"/><br>Hauptspeissen</a></td>
		<td class="category"><a href="Beilagen.jsp"><img src="../img/beilage.jpg" class="card-img-top"/><br>Beilagen</a></td>
		<td class="category"><a href="Desserts.jsp"><img src="../img/desserts.jpg" class="card-img-top"/><br>Desserts</a></td>
		<td class="category"><a href="Salate.jsp"><img src="../img/salat.jpg" class="card-img-top"/><br>Salate</a></td>
		</tr>	
		</table>	
	</form>
</body>
</html>

--%>

<form action="rezeptAppl.jsp" method="get">

<%--Rezepte Suche -> Navbar --%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Rezepte Suche</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a href="StartView.jsp" class="btn btn-secondary">Startseite</a>
      <a class="nav-link active" href="RezeptErstellenView.jsp">+ Rezept erstellen <span class="sr-only"></span></a>
  	  <a class="nav-link active" href="SucheView.jsp">🔍 Rezepte suchen <span class="sr-only"></span></a>
  	  <a class="nav-link active" href="Favoriten.jsp">⭐ Favoriten <span class="sr-only"></span></a> 
    </div>
  </div>
</nav>
<%-- Search Navbar --%>
<nav class="navbar navbar-light bg-light">
  <form class="form-inline">
    <input class="form-control mr-sm-2" type="suchen" placeholder="Rezepte eingeben..." aria-label="Suchen">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Suchen</button>
  </form>

</nav>
<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="3000">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="4"></li>
  </ol>
<%-- 1.Slide --%>
  <div class="carousel-inner">
    <div class="carousel-item active">
       <a href="Suppen.jsp">
      <img src="../img/suppen.jpg" class="d-block w-100" alt="Suppen">
      <div class="carousel-caption d-none d-md-block">
        <h5>Suppen</h5>
        <p>Leckere Suppenrezepte entdecken</p>
      </div>
      </a>
    </div>
   <%-- 2.Slide --%>
    <div class="carousel-item">
    <a href = "Hauptspeissen.jsp">
      <img src="../img/hauptspeisse.jpg" class="d-block w-100" alt="Hauptspeisen">
      <div class="carousel-caption d-none d-md-block">
        <h5>Hauptspeissen</h5>
        <p>Herzhafte Hauptgerichte für jede Gelegenheit</p>
      </div>
	</a>
    </div>
 <%-- 3.Slide --%>
    <div class="carousel-item">
     <a href ="Beilagen.jsp">
      <img src="../img/beilagen.jpg" class="d-block w-100" alt="Beilagen">
      <div class="carousel-caption d-none d-md-block">
        <h5>Beilagen</h5>
        <p>Perfekte Ergänzungen für deine Gerichte</p>
      </div>
     </a>
    </div>
   <%-- 4.Slide --%>
    <div class="carousel-item">
		<a href ="Desserts.jsp">
      <img src="../img/desserts.jpg" class="d-block w-100" alt="Desserts">
      <div class="carousel-caption d-none d-md-block">
        <h5>Desserts</h5>
        <p>Süße Versuchungen zum Abschluss</p>
      </div>
		</a>
    </div>
   <%--5.Slide --%>
    <div class="carousel-item">
		<a href ="Salat.jsp">
      <img src="../img/salat.jpg" class="d-block w-100" alt="Salate">
      <div class="carousel-caption d-none d-md-block">
        <h5>Salate</h5>
        <p>Frische und gesunde Rezepte</p>
      </div>
    </div>
		</a>
  </div>
<%-- weiter/zueruck buttons --%>
  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
		
    <footer>
        &copy; 2025 (Rezept Manager) Projekt | BWI520
    </footer>
</form>