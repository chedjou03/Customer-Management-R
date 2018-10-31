<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>List Customer</title>
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	
	<body>
		
		<div id = "wrapper">
		
			<div id = "header">
			
				<h2>CM - Customer Management</h2>
				
			</div>
		</div>
		
		<input type = "button" value = "Add Customer" onclick = "window.location.href='showCustomerAddForm';return false"  class = "add-button"/>
		
		<div id = "container">
			
				<div id = "content">
				
					<table>
					
						<tr>		
							<th>First Name</th>
							<th>Last  Name</th>
							<th>Email</th>
							<th>Action</th>
						</tr>
						
						<c:forEach var = "tempCustomer" items = "${customers}">
						
							<c:url var = "updateLink" value = "/customer/updateCustomer">
								<c:param name="customerId" value = "${tempCustomer.id}"/>
							</c:url>
							
							<c:url var = "deleteLink" value = "/customer/deleteCustomer">
								<c:param name="customerId" value = "${tempCustomer.id}"/>
							</c:url>
							
							<tr>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td><a href = "${updateLink}">Update</a> | <a href = "${deleteLink}">Delete</a></td>
							</tr>
						</c:forEach>
					
					</table>
				
				</div>
		
		</div>
			
	</body>
</html>