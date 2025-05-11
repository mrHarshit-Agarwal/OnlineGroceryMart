<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>Grocery Details</b>
	<br>
	<br>
	<table border="2">
		<tr>
			<!-- Table header row -->
			<th>GROCERY ID</th>
			<th>GROCERY NAME</th>
			<th>CATEGORY</th>
			<th>PRICE</th>
			<th>STOCK QUANTITY</th>
		</tr>

		<tr>
			<td>${grocery.id}</td>
			<td>${grocery.name}</td>
			<td>${grocery.category}</td>
			<td>${grocery.price}</td>
			<td>${grocery.stockQuantity}</td>
		</tr>
	</table>

	<a href="index.jsp">HOME</a>

</body>
</html>