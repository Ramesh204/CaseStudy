<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="rest/customer/add" method="post">
		<label for="customerId">customerId</label>
		<input type="text" name="customerId" id="customerId" />
		<label for="customerName">customerName</label>
		<input type="text"  name="customerName" id="customerName" />
		<label for="mobileNumber">mobileNumber</label>
		<input type="text" name="mobileNumber" id="mobileNumber" />
		<label for="carNumber">carNumber</label>
		<input type="text" name="carNumber" id="carNumber" />
		<label for="carModel">carModel</label>
		<input type="text" name="carModel" id="carModel" />
		
		<input type="submit" value="addCustomer" />
	</form>
</body>
</html>