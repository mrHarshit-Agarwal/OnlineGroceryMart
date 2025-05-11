<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Grocery Purchase Bill</h2>
	<br>
	<br> Name: ${grocery.name}
	<br>
	<br> Category: ${grocery.category}
	<br>
	<br> Price per unit: ${grocery.price}
	<br>
	<br> Quantity Purchased: ${quantity}
	<br>
	<br>

	<b>Total Bill:</b> Rs.${total}

	<br>
	<br>

	<a href="index.jsp">HOME</a>


</body>
</html>