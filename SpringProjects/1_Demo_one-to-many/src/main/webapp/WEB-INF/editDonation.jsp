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

	<h1>Edit Donation</h1>
	<form:form action="/donations/edit/${donation.id }" method="POST" modelAttribute="donation">
	<input type="hidden" name="_method" value="put" />
	
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
			<form:hidden path="donor" />
		</p>
		
		<button type="submit">Add new donation</button>
		
		</form:form>

</body>

</html>