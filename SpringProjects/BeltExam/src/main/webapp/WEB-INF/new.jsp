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

<title>Create a name</title>

</head>

<body>
	<div class="container">
		
		<h2>Add a name!</h2>
		
	<div>
		<form:form action="/names/new/success" method="POST" modelAttribute="newBabies">
		<input type="hidden" value="${userId }" name="user" />

			<p>
				<form:label path="name">New Name: </form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name" type="text" />
			</p>
			
			<p>
				<form:select path="gender"> Typical Gender:
					<form:option value="Female"></form:option>
					<form:option value="Male"></form:option>
					<form:option value="Neutral"></form:option>
				</form:select>
			</p>
			
			<p>
				<form:label path="origin">Origin: </form:label>
				<form:errors path="origin" class="text-danger"/>
				<form:input path="origin" type="text" />
			</p>
			
			<p>
				<form:label path="meaning">Meaning: </form:label>
				<form:errors path="meaning" class="text-danger"/>
				<form:textarea path="meaning"></form:textarea>
			</p>
			
	
			<a href="/home">Cancel</a>
			<input type="submit" value="Submit">
		</form:form>
	</div>
	

	</div>

</body>

</html>