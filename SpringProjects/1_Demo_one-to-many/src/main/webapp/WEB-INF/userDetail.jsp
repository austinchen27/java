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
	<h1>User Details</h1>
	<h2>Username: <c:out value="${user.userName }" /></h2>
	<h2>Email: <c:out value="${user.email }" /></h2>
	
	<table>
		<thead>
			<tr>
				<th>Donation</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${user.donatedItems }">
				<tr>
					<td><a href="/donations/${eachDonation.id }"><c:out value="${eachDonation.donationName }" /></a></td>
					<td><c:out value="${eachDonation.quantity}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/">Go back</a>

</body>

</html>