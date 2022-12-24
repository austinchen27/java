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

<title>Insert title here</title>

</head>

<body>
	<div class="container">
		<div class="d-flex justify-content-between">
			<h2>Edit Project</h2>
			<a href="/projects">Edit My Task</a>
		</div>
	
		<form:form action="/projects/edit/${oneProject.id }/success" method="POST" modelAttribute="oneProject">
			<input type="hidden" name="_method" value="put" />
			<form:input type="hidden" path="users"></form:input>
			<form:input type="hidden" path="user"></form:input> <!-- important for joins to keep user name -->
			<p>
				<form:errors path="title" class="text-danger"></form:errors>
				<form:label path="title">Project Title:</form:label>
				<form:input path="title" type="text"></form:input>
			</p>
			
			<p>
				<form:errors path="description" class="text-danger"/>
				<form:label path="description">Project Description: </form:label>
				<form:textarea path="description"></form:textarea>
			</p>
			
			<p>
				<form:errors path="dueDate" class="text-danger"></form:errors>
				<form:label path="dueDate">Due Date:</form:label>
				<form:input path="dueDate" type="date"></form:input>
			</p>
			
			<a href="/projects">Cancel</a>
			<button class="btn btn-warning">Submit</button>
		
		</form:form>
	</div>
</body>

</html>