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

<title>Login Demo</title>

</head>

<body>
	<div class="h-100 d-flex align-items-center justify-content-center flex-column pt-5">
		<h3>Login</h3>
		<p><c:out value="${error}"/></p>
		<form action="/login" method="POST">
			<label>Email:</label>
			<input type="text" name="email">
			<label>Password</label>
			<input type="password" name="password">
			<input type="submit" value="Log In">
		</form>
	</div>


</body>

</html>