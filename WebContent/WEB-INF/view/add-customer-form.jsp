<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Add Customer</title>
	</head>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
		  
	<body>
		
		<div id = "wrapper">
		
			<div id = "header">
				<h2>CM - Customer Management</h2>
			</div>
		
		</div>
		
		<div id = container>
		
			<h3>Create New Customer</h3>
			
			<form:form action = "saveCustomer" modelAttribute = "customer" method = "POST">
				
				<form:hidden path = "id"/>
				
				<table>
					
					<tbody>
					
						<tr>
							<td> <label> First Name * </label> </td>
							<td> <form:input path = "firstName"/> <form:errors path = "firstName"/> </td>	
						<tr>
							<td> <label> Last Name * </label> </td>
							<td> <form:input path = "lastName"/> <form:errors path = "lastName"/> </td>
						</tr>
						<tr>	
							<td> <label> Email * </label> </td>
							<td> <form:input path = "email"/> <form:errors path = "email"/></td>
						</tr>
						<tr> 
							<td> * Required field </td> 
						</tr>	
						<tr>		
							<td> <input type = "submit" value = "save" class = "save"/> </td>	
							<td> <input type = "button" value = "List customer" onclick = "window.location.href='list';return false"  class = "save"/> </td>		
						</tr>
					
					</tbody>
				
				</table>
			
			</form:form>
			
			
		</div>
		
	</body>
	
</html>