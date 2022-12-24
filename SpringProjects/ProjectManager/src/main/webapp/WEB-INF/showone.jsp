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

<title>Project Details</title>

</head>

<body>

	<div class="container">
		<div class="d-flex justify-content-around">
			<h2>Project Details</h2>
			<a href="/projects">Back to Dashboard</a>
		</div>

		<p>Project: <c:out value="${oneProject.title }" /></p>
		<p>Description: <c:out value="${oneProject.description }" /></p>
		<p>Due Date: <fmt:formatDate value="${oneProject.dueDate }" pattern="MM/dd/YYYY"/></p>
		
		<a href="/projects/${oneProject.id }/tasks">See Tasks!</a>

		<form action="/projects/delete/${oneProject.id}" method="POST">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
		

	</div>
</body>

</html>