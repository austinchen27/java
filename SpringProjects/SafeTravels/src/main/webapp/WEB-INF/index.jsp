<!-- Used for Prefix and Date -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 <!-- Used for c:out -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

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

<title>Read Share</title>

</head>

<body>

<div class="container">
	<h1>Safe Travels</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="oneExpense" items="${allExpenses }">
				<tr>
					<td><a href="/expenses/show/${oneExpense.id }"><c:out value="${oneExpense.name }"/></a></td>
					<td><c:out value="${oneExpense.vendor }"/></td>
					<td><c:out value="${oneExpense.amount }"/></td>
					<td><a href="/expenses/edit/${oneExpense.id }">edit</a></td>
					<td>
						<form action="/expenses/delete/${oneExpense.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<form:form action="/expenses/create" method="POST" modelAttribute="newExpense">
			<div>
				<h3>Add an expense:</h3>
					<p>
						<form:label path="name">Expenses: </form:label>
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
					<button type="submit">Add new expense</button>
			</div>
		</form:form>

</div>

</body>

</html>