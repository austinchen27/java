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

<title>Book Share</title>

</head>

<body>

	<div class="d-flex justify-content-around">
		<h1>Add a Book to Your Shelf!</h1>
		<p><a href="/books">Go back to the shelves</a></p>
	</div>
	
	<div>
		<form:form action="/books/new" method="POST" modelAttribute="newBooks">
		<input type="hidden" value="${userId }" name="user" />

			<p>
				<form:label path="title">Title: </form:label>
				<form:errors path="title" />
				<form:input path="title" type="text" />
			</p>
			
			<p>
				<form:label path="author">Author: </form:label>
				<form:errors path="author" />
				<form:input path="author" type="text" />
			</p>
			
			<p>
				<form:label path="thoughts">My thoughts: </form:label>
				<form:errors path="thoughts" />
				<form:textarea path="thoughts"></form:textarea>
			</p>
	
			<input type="submit" value="Submit">
		</form:form>
	</div>
	

</body>

</html>