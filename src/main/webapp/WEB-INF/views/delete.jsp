<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML form to delete an item by ID -->
<form action="remove">
  
  <!-- Label and input field to enter the grocery item ID -->
  <b>ENTER THE GROCERY ID TO DELETE THE DETAILS : <input type="number" name="id"> 
  </b>
  <br><br>

  <!-- Submit button to send the form data to the /remove URL -->
  <input type="submit" value="DELETE GROCERY ITEM">

</form>
</body>
</html>
