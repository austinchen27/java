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

<title>Book Lender Dashboard</title>

</head>

<body>

	<div class="d-flex justify-content-around">
		<div>
			<h5>Hello ${userName}, Welcome to..</h5>
			<h2>The Book Broker!</h2>
		</div>
		<div>
			<p><a href="/books">Back to the shelves</a></p>
		</div>
	</div>
	
	
<div class="container">
	<div>
		<p>Available Books to Borrow</p>
		<table class="table table-primary">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Owner</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="oneBook" items="${bookList }">
				<tr>
					<td class="table-light"><a href="/books/${oneBook.id}"><c:out value="${oneBook.id }" /></a></td>
					<td class="table-light"><c:out value="${oneBook.title }" /></td>
					<td class="table-light"><c:out value="${oneBook.author }" /></td>
					<td class="table-light"><c:out value="${oneBook.user.userName}" /></td>
					
					<td class="table-light">
					
						<c:if test="${oneBook.borrower == null && oneBook.user.id != userId }" >
							<a href="/borrow/add/${oneBook.id }">Borrow</a>
						</c:if>

							<c:if test="${oneBook.user.id == userId }">
								<a href="/books/edit/${oneBook.id }">Edit</a>
								<form action="/books/delete/${oneBook.id}" method="POST">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete">
								</form>
							</c:if>
							
					</td>
				</tr>
			</c:forEach>
			
			</tbody>
		</table>
	</div>
	
		<div>
		<p>Books I'm Borrowing</p>
		<table class="table table-warning">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Owner</th>
				 	<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="oneBook" items="${oneUser.borrows }">
				<tr>
					<td class="table-light"><a href="/books/${oneBook.id}"><c:out value="${oneBook.id }" /></a></td>
					<td class="table-light"><c:out value="${oneBook.title }" /></td>
					<td class="table-light"><c:out value="${oneBook.author }" /></td>
					<td class="table-light"><c:out value="${oneBook.user.userName}" /></td>
					<td class="table-light">
						<a href="/borrow/delete/${oneBook.id }">Return</a>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</div>

</body>

</html>