<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>add grocery details here...</h1>
	<br>
	<br>

	<form:form action="save" modelAttribute="grocery">
		<%-- <form:label path="id"> grocery id:</form:label>
		<form:input path="id" />
		<br>
		<br> --%>
		<form:label path="name"> grocery name: </form:label>
		<form:input path="name" />
		<br>
		<br>
		<form:label path="category"> category: </form:label>
		<form:input path="category" />
		<br>
		<br>
		<form:label path="price"> price: </form:label>
		<form:input path="price" />
		<br>
		<br>
		<form:label path="stockQuantity"> stockQuantity: </form:label>
		<form:input path="stockQuantity" />
		<br>
		<br>
		<input type="submit" value="add grocery">
	</form:form>
	
	<br><br> 

<!-- Link to navigate back to the home page (index.jsp) -->
<a href="index.jsp">HOME</a>
	

</body>
</html>