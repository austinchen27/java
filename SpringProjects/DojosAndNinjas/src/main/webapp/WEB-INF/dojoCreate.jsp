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

	

<div class="d-flex justify-content-around">
	<div>		
		<h1>New Dojo</h1>
		<form:form action="/dojos/new" method="POST" modelAttribute="newDojo">
		
			<p>
				<form:label path="name">Name: </form:label>
				<form:errors path="name" />
				<form:input path="name" type="text" />
			</p>
			
			<input type="submit" value="Create">
		</form:form>
	</div>
	
	
	<div>
		<table>
			<thead>
				<tr>
					<th>Dojos</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneDojo" items="${dojoList }">
					<tr>
						<td><a href="/dojos/${oneDojo.id }"><c:out value="${oneDojo.name }" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
		
		<a href="/ninjas">Add Ninja</a>
		
	</div>
	
	
</div>



</body>

</html>