<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="rest/customer/update" method="post">
	<label for="customerId">customerId</label>
	<input type="number" name="customerId" id="customerId" />
	<select name="property" id="property">
		<option value="customerName">customerName</option>
		<option value="mobileNumber">mobileNumber</option>
	</select>
	<label for="updateVal">updateVal</label>
	<input type="text" name="updateVal" id="updateVal" />
	
	<input type="submit" value="update"/>
	
</form>
</body>
</html>