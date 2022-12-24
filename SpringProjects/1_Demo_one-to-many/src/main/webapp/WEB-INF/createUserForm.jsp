<!-- Used for Prefix and Date -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 <!-- Used for c:out -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

<title>Donations</title>

</head>

<body>

	<h1>Create User</h1>
		<form:form action="/users/new" method="POST" modelAttribute="newUser">
		
			<p>
				<form:label path="userName">Donation Name: </form:label>
				<form:errors path="userName" />
				<form:input path="userName"  type="text"/>
			</p>
			
			<p>
				<form:label path="email">Email: </form:label>
				<form:errors path="email" />
				<form:input path="email" type="email"/>
			</p>
			

		<button type="submit">Add new user</button>
		</form:form>

</body>

</html>