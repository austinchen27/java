<!-- Used for Prefix and Date -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 <!-- Used for c:out -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

	<h1>Donation Dashboard</h1>
	<p><a href="/users/new">New User</a></p>
	<p><a href="/donations/new">New Donation</a></p>
	<table>
		<thead>
			<tr>
				<th>Donation</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachDonation" items="${donationList }">
				<tr>
					<td><a href="/donations/${eachDonation.id }"><c:out value="${eachDonation.donationName }" /></a></td>
					<td><c:out value="${eachDonation.quantity}" /></td>
					<td><c:out value="${eachDonation.donor.getUserName() }" /></td> <!-- or donor.userName -->
					<td>
						<a href="/donations/edit/${eachDonation.id }">Edit</a>
						<form:form method="post" action="/donations/delete/${eachDonation.id }">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit">Delete</button>
							</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>User Dashboard</h1>
	<p><a href="/users/new">New User</a></p>
	<p><a href="/donations/new">New Donation</a></p>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Number of Donations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachUser" items="${userList }">
				<tr>
					<td><a href="/users/${eachUser.id }"><c:out value="${eachUser.id }" /></a></td>
					<td><c:out value="${eachUser.userName}" /></td>
					<td><c:out value="${eachUser.email }" /></td> <!-- or donor.userName -->
					<td>
					${eachUser.donatedItems.size() }
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>

</html>
