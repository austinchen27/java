<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<!-- Above for Date function  -->
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Above for c: tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!-- Above for forms and errors -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!-- Above for form:form -->

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

<title>BookClub Login And Registration</title>

</head>

<body>

	<div class="container mt-5">
		<h1>Register</h1>
		<form:form action="/register" method="POST" modelAttribute="newUser">
			<!-- register form -->
			<div class="form-group">
				<form:label path="userName">User Name:</form:label>
				<form:input path="userName" class="form-control" />
				<form:errors path="userName" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path= "email">Email:</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input path="password" class="form-control" type="password" />
				<form:errors path="password" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="confirm">Confirm password:</form:label>
				<form:input path="confirm" class="form-control" type="password" />
				<form:errors path="confirm" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form:form>

		<h1>Login</h1>
		<form:form action="/login" method="POST" modelAttribute="newLogin">
			<!-- login form -->
			<div class="form-group">
				<form:label path= "email">Email:</form:label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:input path="password" class="form-control" type="password" />
				<form:errors path="password" class="text-danger" />
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form:form>
		
	</div>


</body>

</html>