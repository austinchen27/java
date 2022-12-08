<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!-- Above for Date function  -->
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Above for c: tags -->
    
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>

<meta charset="UTF-8">

<title>Hello World</title>

</head>

<body>

	<h1 class="btn btn-primary">Hello World</h1>
	
	<% for (int i = 0; i < 5; i++) {  %>
		<h1><%= i %></h1>
	<% }  %>
	
	<h3>The time is: <%= new Date()  %></h3>
	
	<h1>Two plus two is:</h1>
	<h2><c:out value="${2+2}"/></h2>
	
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${fruit}"/></h2>
	<h2><c:out value="${fruit2}"/></h2>

</body>

</html>