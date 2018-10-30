<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List Customer</title>
	</head>
	<body>
		
		<div id = "wrapper">
		
			<div id = "header">
			
				<h2>CM - Customer Management</h2>
				
			</div>
			
			<div id = "container">
			
				<div id = "content">
				
					<table>
					
						<tr>		
							<th>First Name</th>
							<th>Last  Name</th>
							<th>Email</th>
						</tr>
						
						<c:forEach var = "tempCustomer" items = "${customers}">
							<tr>
								<th>${tempCustomer.firstName}</th>
								<th>${tempCustomer.lastName}</th>
								<th>${tempCustomer.email}</th>
							</tr>
						</c:forEach>
					
					</table>
				
				
				</div>
			
			</div>
		
		</div>
		
	</body>
</html>