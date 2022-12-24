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

<title>Project Manager Dashboard</title>

</head>

<body>

	<div class="container">
		<div class="d-flex align-items-baseline">
			<h2>Welcome, <c:out value="${userName}" />!</h2>
			<p><a href="/logout">Logout</a></p>
		</div>
		
		<div class="d-flex justify-content-between">
		<p>All Projects</p>
		<a href="/projects/new">+ New Project</a>
		</div>
		<table class="table table-primary">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="allProjects" items="${unassignedProjects }">
			<c:if test="${allProjects.user.id != userId}">
				<tr>
					<td class="table-light">
					<a href="/projects/show/${allProjects.id}"><c:out value="${allProjects.title }" /></a>
					</td>
					<td class="table-light"><c:out value="${allProjects.user.userName }" /></td>
					<td class="table-light"><fmt:formatDate value="${allProjects.dueDate }"  pattern="MMMM dd"/></td>
					<td class="table-light">
					
						<form action="/team/join/${allProjects.id }" method="POST">
							<input type="hidden" name="_method" value="put" />
							<input type="submit" value="Join team" class="btn btn-primary"></input>
						</form>
						
					</td>
				</tr>
			</c:if>
			</c:forEach>
			</tbody>
		</table>
		
		<p>Your Projects</p>
		<table class="table table-warning">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="oneProject" items="${oneUser.projectItems }">
					<tr>
						<td class="table-light">
							<a href="/projects/show/${oneProject.id }"><c:out value="${oneProject.title }" /></a>
						</td>
						<td class="table-light"><c:out value="${oneProject.user.userName }" /></td>
						<td class="table-light"><fmt:formatDate value="${oneProject.dueDate}" pattern="MMMM dd" /></td>
						<td class="table-light">
							<a href="/projects/edit/${oneProject.id }">Edit</a>
							<form action="/projects/delete/${oneProject.id }" method="POST">
								<input type="hidden" name="_method" value="delete" />
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
						<td>${oneProject.users.size()}</td>
					</tr>
				</c:forEach>
			
				<c:forEach var="oneProject" items="${oneUser.teams }">
				<tr>
					<td class="table-light">
					<a href="/projects/show/${oneProject.id}"><c:out value="${oneProject.title }" /></a>
					</td>
					<td class="table-light"><c:out value="${oneProject.user.userName }" /></td>
					<td class="table-light"><fmt:formatDate value="${oneProject.dueDate }" pattern="MMMM dd" /></td>
					<td class="table-light">
						<form action="/team/leave/${oneProject.id }" method="POST">
							<input type="hidden" name="_method" value="put" />
							<button class="btn btn-warning">Leave Team</button>
						</form>
					</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
	</div>
	
</body>

</html>