<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editGalleryItemServlet" method="post">
Title: <input type ="text" name = "title" value= "${itemToEdit.title}"><br/>
Artist Name: <input type = "text" name = "artistName" value= "${itemToEdit.artistName}"><br/>
Media: <input type = "text" name = "media" value= "${itemToEdit.media}"><br/>
Year: <input type = "text" name = "year" value= "${itemToEdit.year}"><br/>
Value: <input type = "text" name = "value" value= "${itemToEdit.value}"><br/>


<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>