<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.task2.model.User"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to TASK2</title>
</head>
<body>

<div align="center">
	<form action="<%=request.getContextPath()%>/insert" method=post  >
		     <% User user=(User) request.getAttribute("existingUser");
		     
		      out.println(" :: user ::"+user); 
		      
		     %>
		     
		     
		   <h1> New Registration Form </h1>
		    
	 <table border="3" style="border-width: 100%;"> 
				<tr>
					    <td><input type="hidden" name="reqType" value=<%=user!=null?user.getTypeofrequest():"new"%>></td>
						
				</tr>
				<tr>
					<td><input type="hidden" name="id" value=<%=user!=null?user.getId():""%>></td>
						
				</tr>
		<tr>
				<td>Name</td>
				<td > <input type="text" name="name"  value="<%=user!= null? user.getName():"" %>">  </td>
		</tr>
		  <tr> 
				<td>Password</td>
			 	<td> <input type="password" name="password"  value="<%=user!= null?user.getPassword():"" %>">  </td>
		</tr>
		<tr>
				<td>Age</td>
				<td> <input type="number" name ="age" value="<%=user!=null?user.getAge():"" %>"> </td>
		</tr>
		<tr>
				<td>Gender</td>
				<td> <input type="radio" name="gender" value="<%=user!=null? user.getGender():"Male" %>" > Male </td>
				<td> <input type="radio" name="gender" value="<%=user!=null? user.getGender():"Female" %>" > FeMale </td>
		</tr>
		<tr>
				<td>Country</td>
			 	<td> 
			 	<select name="country">  
			 	<option value="<%=user!=null? user.getCountry():"Singapore" %>">Singapore </option>
			 	<option value="<%=user!=null?user.getCountry():"India" %>"  > India </option>
			 	<option value=" <%=user!=null?user.getCountry():"To Payoh" %>">Topayoh </option>
			 	</select>  
			 	</td>
		</tr>
		<tr>
				<td>Date Of Birth</td>
				<td>   <input type="date" name="dateofbirth" id="dateofbirth" value="<%=user!=null?user.getDateofbirth():"" %>">      </td>
		</tr>
		<tr>
				<td>Salary</td>
				<td> <input type="number" name="salary"  value="<%=user!=null?user.getSalary():"" %>" > </td>
		</tr>
		<tr>
				<td>Address</td>
				<td> <input type="text" name="address" value="<%=user!=null?user.getAddress():"" %>"> </td>
		</tr>
		<tr>
				<td>Description</td>
				<td> <input type="text" name="description" value="<%=user!=null?user.getDescription():"" %>"> </td>
		</tr>  
		</table> 
		 <input type="submit" value="Submit">
		 <input type="reset" value="Cancel">
	
		</form>
	</div>

<a href='list'><button>Show User</button></a>


</body>
</html>