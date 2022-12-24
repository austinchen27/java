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

<title>Read Share</title>

</head>

<body>

	<div class="d-flex justify-content-between">
		<div>
			<h1>Welcome, <c:out value="${userName }" /></h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div>
			<p><a href="/logout">Logout</a></p>
			<p><a href="/bookmarket">Go to the book market</a></p>
			<p><a href="/books/new">+ Add a book to my shelf!</a></p>
		</div>
	</div>
	
	<div>
		<table class="table table-primary">
			<thead class="thead-dark">
				<tr>
					<th scope="row">ID</th>
					<th scope="row">Title</th>
					<th scope="row">Author Name</th>
					<th scope="row">Posted By</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="allBooks" items="${bookList }">
				<tr>
					<td class="table-light"><c:out value="${allBooks.id }" /></td>
					<td class="table-light"><c:out value="${allBooks.title }" /></td>
					<td class="table-light"><c:out value="${allBooks.author }" /></td>
					<td class="table-light"><c:out value="${allBooks.user.userName }" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
	</div>

</body>

</html>







