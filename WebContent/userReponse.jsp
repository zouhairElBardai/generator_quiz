<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href ="public/CSS/style.css" />
<title>Utilisateur reponse</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h3 align="center">la liste des questions :</h3>
<hr><br>

	<h3 align="center"><c:out value="${title}"/></h3>
	<c:if test="${typeFile=='choix multiples'}" >
	    <form action="addUtilisateur" method="post">
	<ul style="list-style-type:none;">
		
		 <c:forEach var="listQ" items="${listQC}">
			<c:out value="${listQ.enonce}"/></a><br>
			
			<c:forEach var="listChoix" items="${listQ.choix}">
					<li><input type="radio" name="${listQ.enonce}" value="${listChoix.valeurChoix}" /><c:out value="${listChoix.valeurChoix}"/></a></li>
			</c:forEach>
		</c:forEach>
	</ul>
	<input type="submit" value="valider" />
	<input type="reset" value="annuler" />
	
	</form>    
	</c:if>
	
	<c:if test="${typeFile=='texteTrous'}" >
	<div align="center">
		<form action="addUtilisateur" method="post">
	  <table>
		 <c:forEach var="listTT" items="${questionTT}">
			<tr>
				<td>
					<c:out value="${listTT}"/>
				</td>
				<td>
					<input type="text" name="reponse"/>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<input type="submit" value="valider" />
	<input type="reset" value="annuler" />
	</form>    
	</c:if>
	</div>
	  
	
<%@ include file="footer.jsp" %>
</body>
</html>