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

<title>Donations</title>

</head>

<body>

	<h1>New Donation</h1>
	<form:form action="/donations/new" method="POST" modelAttribute="newDonation">
	
		<p>
			<form:label path="donationName">Donation Name: </form:label>
			<form:errors path="donationName" />
			<form:input path="donationName" />
		</p>
		<p>
			<form:label path="quantity">Quantity: </form:label>
			<form:errors path="quantity" />
			<form:input type="number" path="quantity" />
		</p>
		<p>
			<form:label path="description">Description: </form:label>
			<form:errors path="description" />
			<form:textarea path="description"></form:textarea>
		</p>
		
		<p>
		<form:label path="donor">Donor: </form:label>
		<!--  THE CODE BELOW WILL NOT BEFORE AFTER AUTH -->
		<form:select path="donor">
			<c:forEach var="eachUser" items="${userList }">
			<form:option value ="${eachUser.id }"> ${eachUser.userName } (${eachUser.email })</form:option>
			</c:forEach>
		</form:select>
		</p>
		
		<button type="submit">Add new donation</button>
		
	</form:form>

</body>

</html>