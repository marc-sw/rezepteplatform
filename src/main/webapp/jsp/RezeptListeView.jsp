<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezepte nach Kategorien</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel ="stylesheet" href="../css/bootstrap.min.css">
<link rel ="stylesheet" href="../css/kochCSS.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<jsp:useBean id ="rb" class ="de.hwg_lu.bwi520.bean.RezeptBean" scope ="session" />

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><%= rb.generateKategoriesucheHTML() %> Suche</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a href="StartView.jsp" class="btn btn-secondary">Rezept Liste</a>
      <a class="nav-link active" href="RezeptErstellenView.jsp">+ Rezept erstellen <span class="sr-only"></span></a>
  	  <a class="nav-link active" href="SucheView.jsp">🔍 Rezepte suchen <span class="sr-only"></span></a>
  	  <a class="nav-link active" href="Favoriten.jsp">⭐ Favoriten <span class="sr-only"></span></a> 
    </div>
  </div>
</nav>
	
	<%= rb.getRezepteByKategorie() %>

</body>
</html>