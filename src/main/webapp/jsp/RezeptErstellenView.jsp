<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezept Erstellen</title>
</head>
<body>
    <h1>Rezept Erstellen</h1>
    <p>Hier kannst du ein neues Rezept erstellen.</p>
	<form action="./KochAppl.jsp" method="get">
		<table>
			<tr> 
				<td>
					<label for="titel">Titel</label>
				</td>
				<td>
					<input type="text" name="titel" id="titel">
				</td>
			</tr>
			<tr>
				<td>
					<label>Zutat hinzuf&uuml;gen</label>
				</td>
			</tr>
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
						<option>TL</option>
						<option>ML</option>
						<option>L</option>
						<option>G</option>
						<option>KG</option>
						<option>St&uuml;ck</option>
					</select>
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
		</table>

			<label>Zubereitung</label><br>
			<textarea rows="20" cols="50" name="zubereitung"></textarea><br>
			<input type="submit" name="rezeptErstellen" value="Erstellen">
	</form>
</body>
</html>