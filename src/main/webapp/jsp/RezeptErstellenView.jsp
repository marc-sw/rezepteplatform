<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="de.hwg_lu.bwi520.bean.RezeptErstellenBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezept Erstellen</title>
</head>
<body>
	<jsp:useBean id="rezeptErstellen" class="de.hwg_lu.bwi520.bean.RezeptErstellenBean" scope="session" />
    <h1>Rezept Erstellen</h1>
    <p>Hier kannst du ein neues Rezept erstellen.</p>
	<form action="${pageContext.request.contextPath}/RezeptServlet" method="post" enctype="multipart/form-data">
		<table>
			<tr> 
				<td>
					<label for="titel">Titel</label>
				</td>
				<td>
					<input type="text" name="titel" id="titel">
				</td>
			</tr>
			<%= rezeptErstellen.getZutatenHTML() %>
			<tr>
				<td>
					<label>Zutat</label>
				</td>
				<td>
					<input type="text" name="zutatName">
				</td>
			</tr>
			<tr>
				<td>
					<label>Menge</label>
				</td>
				<td>
					<input type="number" step="0.25" name="zutatMenge">
					<select name="zutatEinheit">
						<option>ml</option>
						<option>l</option>
						<option>g</option>
						<option>kg</option>
						<option>TL</option>
						<option>EL</option>
						<option>Priese</option>
						<option selected>St&uuml;ck</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" name="zutatHinzufuegen" value="Zutat hinzuf&uuml;gen">
				</td>
			</tr>

			<tr>
				<td>
					<label>Bild</label>
				</td>
				<td>
					<input type="file" accept="image/*" name="bild">
				</td>
			</tr>
			<tr>
				<td>
					<label>Dauer (Minuten)</label>
				</td>
				<td>
					<input type="number" name="dauer">
				</td>
			</tr>
			<tr>
				<td>
					<label>Kategorie</label>
				</td>
				<td>
					
					<select name="kategorie">
						<option>Suppe</option>
						<option selected>Hauptspeise</option>
						<option>Beilage</option>
						<option>Salat</option>
						<option>Dessert</option>
					</select>
				</td>
			</tr>
		</table>

			<label>Zubereitung</label><br>
			<textarea rows="20" cols="50" name="zubereitung"></textarea><br>
			<input type="submit" name="rezeptErstellen" value="Erstellen">
	</form>
</body>
</html>