<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<% int i =1; %>
</head>
<body>
<h1> This is index</h1>
<a class="dlink" href="/songs/new">Add new</a>
<a class="dlink" href="/songs/search/topten">Top Songs</a>

	<form class="dlink searchbox " action="/songs/search/" method="post">
		<input class="" type="text" name="searchstr" placeholder="Search by Artist"/>
		<button>Search</button>
	</form>
<table>
<thead>
<tr>
	<th>Result #</th>
	<th>Title</th>
	<th>Rating</th>
	<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="song" items="${songs}">
	<tr>
		<td><%=  i++ %> </td>
		<td><a href="/songs/${song.id}">${song.title}</a></td>
		<td>${song.rating}</td>
		<td>
		<form:form action="/songs/${song.id}/delete" method="post">
		<button class="delete" type="submit">Delete</button> 
		</form:form>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>