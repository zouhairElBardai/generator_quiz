<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Admin</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<div align="center">
		<h2> uploader un fichier :</h2>
		<hr /><br>
		
		<c:if test="${ !empty fichier }">
			<p>
				<c:out value="Le fichier ${ fichier } de type ${ quizzType } a été uploadé !" />
			</p>
		</c:if>
		
    <form method="post" action="uploadeFichier" enctype="multipart/form-data">
    	<table>
    	<tr>
    		<td>type de fichier : </td>
    		<td><select name="quizzType">
					<option value="choix multiples">choix multiples</option>	
					<option value="texteTrous">texte à trous</option>			
					</select></td>
    	</tr>
    	<tr>
    		<td><label for="fichier">Fichier à envoyer : </label></td>
    		<td><input type="file" name="fichier" id="fichier" /></td>
    	</tr>
    	</table>
		
        <input type="submit" value="uploader" />
    </form> 
    
    <%--  <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
    <form method="post" action="uploadeFile" enctype="multipart/form-data">
        <p>
            <label for="description">Description du fichier : </label>
            <input type="text" name="description" id="description" />
        </p>
        <p>
            <label for="fichier">Fichier à envoyer : </label>
            <input type="file" name="fichier" id="fichier" />
        </p>
        
        <input type="submit" />
    </form>
     --%>
	</div>
	
<%@ include file="footer.jsp" %>
</body>
</html>