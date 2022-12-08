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

<title>Your Omikuji</title>

</head>

<body>

<div class="h-100 d-flex align-items-center justify-content-center flex-column pt-5">
	<h1>Here's Your Omikuji!</h1>
	<div>
		<p>
			In <c:out value="${years}"/> years, you will live in <c:out value="${city}"/> 
			with <c:out value="${person}"/> as your partner, <c:out value="${job}"/> 
			for a living. The next time you see a <c:out value="${charm}"/>,
			you will have good luck. Also, <c:out value="${wish}"/>.
		</p>
	</div>

</div>

</body>

</html>