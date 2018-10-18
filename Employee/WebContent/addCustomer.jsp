<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
#custdiv{
margin-left:25%;
margin-top:1%;
}
h2{
color:blue;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery1-7-2.js"></script>
<script type="text/javascript">

</script>
</head>
<body>

<%@include file="companyBanner.html" %>

<div class="form-group col-sm-5" id="custdiv" >
	<h2>Enter the Customer Details</h2> <br/>
	<form action="rest/customer/add" method="post">
		<label for="customerId" >customerId</label>
		<input type="text" name="customerId" id="customerId" class="form-control  "/> <br/>
		<label for="customerName">customerName</label>
		<input type="text"  name="customerName" id="customerName"  class="form-control  " /> <br/> 
		<label for="mobileNumber">mobileNumber</label>
		<input type="text" name="mobileNumber" id="mobileNumber" class="form-control "  /> <br/> 
		<label for="carNumber">carNumber</label>
		<input type="text" name="carNumber" id="carNumber" class="form-control  " /> <br/> 
		<label for="carModel">carModel</label>
		<input type="text" name="carModel" id="carModel" class="form-control " /> <br/> 
		
		<input type="submit" id="" value="addCustomer"   class="btn btn-success"  />
	</form>
</div>
</body>
</html>