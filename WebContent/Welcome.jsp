<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Main Page</title>
</head>
<body>


<form action="/" method =post>

<%-- <a href="<%=request.getContextPath() %>/register"> Add New User</a>  --%>
<a href="new">New</a> <br>
<!-- <a href='new'><button>New</button></a> -->
<a href="list">Show All User</a> <br>
		<table border="2" style="width: 80%;">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Country</th>
				<th>Date Of Birth</th>
				<th>Salary</th>
				<th>Address</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="res" items="${us}">
			<tr>
				<td><c:out value="${res.id}"/></td>
			     <td><c:out value="${res.name}"/></td>
			     <td><c:out value="${res.password}"/></td>
			     <td> <c:out value="${res.age}"/></td>
			     <td> <c:out value="${res.gender}"/></td>
			     <td> <c:out value="${res.country}"/></td>
			     <td> <c:out value="${res.dateofbirth}"/></td>
			     <td> <c:out value="${res.salary}"/></td>
			     <td> <c:out value="${res.address}"/></td>
			 	 <td> <c:out value="${res.description}"/></td>
			 	 <td>  
			 	 <a href="edit?id=<c:out value="${res.id}"/>  ">Edit </a>
			 	 <a href="delete?id=<c:out value="${res.id}"/> "> Delete</a>
			 	 </td>
			 	 
			</tr>
			</c:forEach>
		</table>
</form>

</body>
</html>