<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<style>
.cont{
display: inline-block;
vertical-align: top;
margin-left: 2em;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboard"> Dashboard</a>
<h1>This is Song Detail </h1>
<div class="cont">
<p>Title</p>
<p>Artist</p>
<p>Rating/10</p>
		<form:form action="/songs/${song.id}/delete" method="post">
		<button class="delete" type="submit">Delete</button> 
		</form:form>
</div>
<div class="cont">
<p>${song.title}</p>
<p>${song.artist}</p>
<p>${song.rating}</p>
</div>
</body>
</html>