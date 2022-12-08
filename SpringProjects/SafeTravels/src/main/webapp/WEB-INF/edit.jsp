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

<title>Edit My Task</title>

</head>

<body>
   
   <div class="d-flex justify-content-around" style="width:500px">
	<h1>Edit Book</h1>
	<a href="/expenses">Go back</a>
	</div>
<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
					<p>
						<form:label path="name">Expense Name: </form:label>
						<form:errors path="name" />
						<form:input path="name"  type="text"/>
					</p>
					<p>
						<form:label path="vendor">Vendor: </form:label>
						<form:errors path="vendor" />
						<form:input path="vendor" type="text"/>
					</p>
					<p>
						<form:label path="amount">Amount: </form:label>
						<form:errors path="amount" />
						<form:input path="amount"  type="number"/>
					</p>
					<p>
						<form:label path="description">Description: </form:label>
						<form:errors path="description" />
						<form:textarea path="description"></form:textarea>
					</p>
					<button type="submit">Submit Edit</button>
</form:form>
</body>

</html>