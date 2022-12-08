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

<title>Omikuji Form</title>

</head>

<body>

<div class="h-100 d-flex align-items-center justify-content-center flex-column pt-5">
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji/show/submit" method="POST">
	<div class="form-control">
		<div>
			<p>Pick any number from 5 to 25</p>
			<input type="number" name="years">
		</div>
		<div>
			<p>Enter the name of any city:</p>
			<input type="text" name="city">
		</div>
		<div>
			<p>Enter the name of any real person:</p>
			<input type="text" name="person">
		</div>
		<div>
			<p>Enter professional endeavor or hobby:</p>
			<input type="text" name="job">
		</div>
		<div>
			<p>Enter any type of living thing:</p>
			<input type="text" name="charm">
		</div>
		<div>
			<p>Say something nice to someone:</p>
			<textarea name="wish"></textarea>
		</div>
		<button class="btn btn-primary">Submit</button>
	</div>
	</form>

</div>


</body>

</html>