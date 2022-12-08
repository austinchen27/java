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

<title>Fruity Loops</title>

</head>

<body>

<div class="container">
	<h1>Fruit Store</h1>
	<table class="table">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="oneFruit" items="${fruits}">
			<tr>
				<td><c:out value="${oneFruit.name}"></c:out></td>
				<td><c:out value="${oneFruit.price}"></c:out></td>
			</tr>
			</c:forEach>
		</tbody>

	</table>

</div>

</body>

</html>