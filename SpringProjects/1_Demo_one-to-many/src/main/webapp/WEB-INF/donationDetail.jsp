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
	<h1>Donation Details</h1>
	
	<h2>Donation name:
	<c:out value="${donation.donationName }" />
	</h2>
	
	<h2>Quantity:
	<c:out value="${donation.quantity }" />
	</h2>
	
	<h2>Description:
	<c:out value="${donation.description }" />
	</h2>
	
	<h2>Donor:
	<c:out value="${donation.donor.userName }" />
	</h2>
	
	<p>Contact the donor at <c:out value="${donation.donor.email}" /></p>
	
	<form action="/donations/delete/${donation.id }" method="POST">
	<input type="hidden" name="_method" value="delete" />
	<button type="submit">Delete</button>
	</form>

</body>

</html>