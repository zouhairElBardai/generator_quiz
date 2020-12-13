<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href ="public/CSS/style.css" />
<title>Identification</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div align="center">
	<%
		String action=request.getParameter("action");		
		if(action.equals("admin")){
	%>
	
	<h2>identification d'administrateur</h2>
	<hr /><br>
	
	<p>saisir votre login et password </p>
	<form action="verifierAdmin" method="post">
		<table>
			<tr>
				<td>login :</td>	
				<td><input type="text" name="login"/></td>	
			</tr>
			<tr>
				<td>password :</td>	
				<td><input type="text" name="password" /></td>	
			</tr>
			<tr>
				<td><input type="submit" value="valider" /></td>	
				<td><input type="reset" value="annuler" /></td>	
			</tr>
		</table>
	</form>
	<% } if(action.equals("user")){ %>
	
	<h2>identification d'utilisateur</h2>
	<hr /><br>
	
	<p>saisir votre nom et prenom </p>
	<form action="addUtilisateur" method="post">
		<table>
			<tr>
				<td>nom :</td>
				<td><input type="text" name="nom" /></td>
			</tr>	
			<tr>
				<td>prenom :</td>
				<td><input type="text" name="prenom" /></td>
			</tr>	
			<tr>
				<td><input type="reset" value="annuler" /></td>
				<td><input type="submit" value="valider"/></td>
			</tr>		
		</table>
	
	</form>
		
	<% } %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>