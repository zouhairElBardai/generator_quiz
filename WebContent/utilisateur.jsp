<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href ="public/CSS/style.css" />
<title>Utilisateur</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div align="left">
	<h3 align="center" >la liste des themes :</h3>
	<hr><br>
	
	<h4> Choix Multiples</h4>

	<ul style="list-style-type:none;">
		 <c:forEach var="fichier" items="${listCM}">
				<a href="userReponse?theme=${fichier.theme}&type_file=${fichier.type_file}"><c:out value="${fichier.theme}"/></a><br>
		</c:forEach>
	</ul>
	
	<h4>Texte à trous</h4>
	<ul style="list-style-type:none;">
	 	<c:forEach var="fichier" items="${listTT}">
			<a href="userReponse?theme=${fichier.theme}&type_file=${fichier.type_file}"><c:out value="${fichier.theme}"/></a><br>
		</c:forEach>
	</ul>
	
</div>

<%@ include file="footer.jsp" %>
</body>
</html>