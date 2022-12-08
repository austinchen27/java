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

<title>Insert title here</title>

</head>

<body>

	<div class="container">
	<h2>All Books</h2>
	
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th># of Pages</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="oneBook" items="${bookList}">
				<tr>
					<td><c:out value="${oneBook.id}"/></td>
					<td><a href="/show/${oneBook.id}"><c:out value="${oneBook.title}"/></a></td>
					<td><c:out value="${oneBook.language}"/></td>
					<td><c:out value="${oneBook.numberOfPages}"/></td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
	
	</div>

</body>

</html>