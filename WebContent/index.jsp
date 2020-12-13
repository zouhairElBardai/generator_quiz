<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href ="public/CSS/style.css" />
<title>Accueil</title>
</head>
<body>
<%@ include file="header.jsp" %>

<div>
<p>On souhaite la creation d'un generateur de questionnaires de type quizz et de textes a 
trous en JEE.<br> Ce travail comporte deux parties distinctes : </p>
</div>
<div>
<p>- Admin est une interface permettant d'inserer dans la base de donnees des questions ou des textes a trous </p>
<a href = "identification.jsp?action=admin">Admin</a>


<p>- Utilisateur est une interface permettant de tester le quizz ou les textes a trous</p>
<a href = "identification.jsp?action=user">Utisateur</a>

</div>



<%@ include file="footer.jsp" %>
</body>
</html>