<!-- Used for Prefix and Date -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 <!-- Used for c:out -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<title>Ninja Gold Game</title>

</head>

<body>

	<div>
		<div>
			<h3>Your Gold: <c:out value="${total }"/></h3> 
		</div>
		<div class="d-flex justify-content-evenly">
		
			<form action="/gold" method="POST">
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<input class="button" type="submit" name="farm" value="Find Gold!">
			</form>
			
			<form action="/gold" method="POST">
			<h3>Cave</h3>
			<p>(earns 10-20 gold)</p>
			<input class="button" type="submit" name="farm" value="Find Gold!">
			</form>
			
			<form action="/gold" method="POST">
			<h3>House</h3>
			<p>(earns 10-20 gold)</p>
			<input class="button" type="submit" name="farm" value="Find Gold!">
			</form>
			
			<form action="/gold" method="POST">
			<h3>Quest</h3>
			<p>(earns/takes 0-50 gold)</p>
			<input class="button" type="submit" name="farm" value="Find Gold!">
			</form>
			
		</div>

	</div>

</body>

</html>