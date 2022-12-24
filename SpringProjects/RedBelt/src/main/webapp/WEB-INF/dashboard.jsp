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

<title>Joy Bundler Dashboard</title>

</head>

<body>
	<div class="container">
	
		<div class="d-flex align-items-baseline justify-content-between">
			<h1>Hello, <c:out value="${username }"/>. Here are some name suggestions..</h1>
			<p><a href="/logout">Logout</a></p>
		</div>
		
		<div class="d-flex justify-content-between">
			<h3>Baby Names</h3>
			<h3>Votes</h3>
		</div>
		
		<table class="table table-primary">
			<thead>
				<tr>
					<th>Action</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Origin</th>
					<th>Votes</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="oneBaby" items="${babyList }">
				<tr>
					<td>upvote button</td>
					<td><a href="/names/${oneBaby.id}"><c:out value="${oneBaby.name }" /></a></td>
					<td><c:out value="${oneBaby.gender }" /></td>
					<td><c:out value="${oneBaby.origin }" /></td>
					<td></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<a href="/names/new">< New Name</a>



	</div>
</body>

</html>