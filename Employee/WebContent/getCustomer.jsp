<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">
#custdiv{
margin-left:25%;
margin-top:1%;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="companyBanner.html" %>

<div class="form-group col-sm-5" id="custdiv" >

	<form action="rest/customer/details" method="post">
		<label for="customerId">customerId</label>
		<input type="number" name="customerId" id="customerId" class="form-control  " /> <br/>
		
		<input type="submit" value="Get Customers Details" class="btn btn-success" />
	</form>
	
</div>	

</body>
</html>