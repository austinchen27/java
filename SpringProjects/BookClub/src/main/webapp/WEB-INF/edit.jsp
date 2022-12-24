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
	<div class="d-flex justify-content-between">
		<div>
			<h2>Change your Entry</h2>
		</div>
		<div>
			<p><a href="/bookmarket">Go to the book market</a></p>
			<p><a href="/books">Back to Shelves</a></p>
		</div>
	</div>
	
	<p>--validations--</p>
	
	<div>
		<form:form action="/books/edit/success/${oneBook.id }" method="POST" modelAttribute="oneBook">
		<input type="hidden" name="_method" value="put" />
		<form:input type="hidden" path="user" />
		<form:input type="hidden" path="borrower" />
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