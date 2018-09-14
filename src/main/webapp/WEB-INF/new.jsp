<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboard"> Dashboard</a>
<h1>This is add new</h1>
Form here:
title, artist, rating add song button
<form:form action="/songs/new" method="post" modelAttribute="song">
	<div>
	    <form:errors path="title"/>
	    <form:label path="title">Title</form:label>
	    <form:input path="title"/>
	</div>
	<div>
	    <form:errors path="artist"/>
	    <form:label path="artist">Artist</form:label>
	    <form:input path="artist"/>
	</div>
	<div>
	    <form:errors path="rating"/>
	    <form:label path="rating">Rating</form:label>
	    <form:input path="rating"/>
	</div>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>