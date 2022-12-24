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
	<h1>New Ninja</h1>
	
	<form:form action="/ninjas" method="POST" modelAttribute="newNinja">
	<p>
		<form:select path="dojo">
		<c:forEach var="oneDojo" items="${dojoList }">
			<form:option value="${oneDojo.id }"><c:out value="${oneDojo.name }" /></form:option>
		</c:forEach>
		</form:select>
	</p>
	
	<p>
		<form:label path="firstName">First Name: </form:label>
		<form:errors path="firstName" />
		<form:input path="firstName"  type="text"/>
	</p>
	
	<p>
		<form:label path="lastName">Last Name: </form:label>
		<form:errors path="lastName" />
		<form:input path="lastName"  type="text"/>
	</p>
	
	<p>
		<form:label path="age">Age: </form:label>
		<form:errors path="age" />
		<form:input path="age"  type="number"/>
	</p>
	
	<button type="submit">Create New Ninja</button>
	</form:form>

</body>

</html>