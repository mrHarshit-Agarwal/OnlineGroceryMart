<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Displaying All Grocery Details -->
	<b>ALL GROCERY DETAILS</b>
	<br> <br>
	<b>------------------------------</b>
	<br> <br>

	<!-- HTML table with border for displaying grocery data -->
	<table border="2">
		<tr>
			<!-- Table header row -->
			<th>GROCERY ID</th>
			<th>GROCERY NAME</th>
			<th>CATEGORY</th>
			<th>PRICE</th>
			<th>STOCK QUANTITY </th>
		</tr>

		<!-- JSTL forEach tag to iterate over the list of employees passed from the controller -->
		<c:forEach items="${grocerylist}" var="grocery">
			<tr>
				<td>${grocery.id}</td>
				<td>${grocery.name}</td>
				<td>${grocery.category}</td>
				<td>${grocery.price}</td>
				<td>${grocery.stockQuantity}</td>
			</tr>
		</c:forEach>
	</table>
	<br> <br>
	
	<a href="index.jsp">Home</a>

</body>
</html>

