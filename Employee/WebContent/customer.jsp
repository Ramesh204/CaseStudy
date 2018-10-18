<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">
a{

font-size:25px;
}

div#linksdiv{
margin-left:5%;
margin-top:2%;
}
div#infmdiv{

margin-top:2%;
}


</style>
<script type="text/javascript" src="jquery1-7-2.js"></script>
<script type="text/javascript">
$(function(){
	$("#button").on('click',function(){
		var carNumber = $("#carNumber").val();
		
		$.get("http://localhost:8080/InsuranceAgent/rest/insurance/allPolicies/"+carNumber,function(data){
			$('#infm').text(JSON.stringify(data));
		})
		
		
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
<%@include file="companyBanner.html" %>

<div class="form-group col-sm-5"  id="linksdiv" >
<a href="addCustomer.jsp">Add Customer Details</a> <br/>
<a href="getCustomer.jsp">Get Customer Details</a> <br/>
<a href="updateCustomer.jsp">UpdateCustomer Details</a> <br/>
<a href="deleteCustomer.jsp">DeleteCustomer Details</a> <br/>
<a href="addService.jsp">Add Service Details</a>  <br/>
<a href="getService.jsp">Get Service Details</a>
</div>

<div class="col-sm-5"  id="infmdiv">
<form>
<label for="carNumber">CarNumber</label>
<p>Enter the car number to get all Policies </p>
<input type="text" name="carNumber" id="carNumber" class="form-control  " /> <br/>
<input type="button" value="submit" id="button"  class="btn btn-success" />
</form>
</div>

<p id="infm"></p>
</body>
</html>