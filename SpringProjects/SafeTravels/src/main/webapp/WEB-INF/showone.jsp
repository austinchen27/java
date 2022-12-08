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

<title>Show Expense</title>

</head>

<body>

<div class="d-flex justify-content-around" style="width:500px">
	<h3>Expense Details</h3>
	<a href="/expenses">Go back</a>
</div>



	<div>
		<p>Expense Name: <c:out value="${expense.name}"/></p>
		<p>Expense Description: <c:out value="${expense.description}"/></p>
		<p>Vendor: <c:out value="${expense.vendor}"/></p>
		<p>Amount: <c:out value="${expense.amount}"/></p>
	</div>



</body>

</html>