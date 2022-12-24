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
		<div class="d-flex justify-content-around">
			<h2>Project: <c:out value="${oneProject.title }" /></h2>
			<a href="/projects">Back to Dashboard</a>
		</div>
		
		<p>Project Lead: <c:out value="${oneProject.user.userName }" /></p>
		
		<p>
			<form:form action="/projects/${oneProject.id }/tasks/success" method="POST" modelAttribute="task">
			<form:errors path="name" class="text-danger"></form:errors>
				<form:label path="name">Add a task ticket for this team:</form:label>
				<form:input path="name" type="input"></form:input>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</p>
		
		<c:forEach var="oneTask" items="${oneProject.tasks }">
			<h5>Added by: <c:out value="${oneTask.creator.userName }" /> at 
			<fmt:formatDate value="${oneTask.createdAt }" pattern="hh:mm MMMM dd" />
			</h5>
			<p><c:out value="${oneTask.name }" /></p>
		</c:forEach>

	</div>
</body>

</html>