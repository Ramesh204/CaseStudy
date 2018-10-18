<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="jquery1-7-2.js"></script>
<script type="text/javascript">
	$(function(){
		$('#button').on('click',function(){
		
			var customerId = $('#customerId').val();
			console.log(customerId);
			
			$.get("http://localhost:8080/AutomobileService/rest/customer/details/"+customerId,function(data){
				//$("#custData").text(JSON.stringify(data));
				
				var customerId = data['customerId'] ;
			
				
				$('#a1').slideDown('fast',function(){
					$('#c1').text(customerId);
					$('#c2').text(data['customerName']);
					$('#c3').text(data['mobileNumber']);
					$('#c4').text(data.car['carNumber']);
					$('#c5').text(data.car['carModel']);
					
				});
			});
			
		});
	})
</script>
<style type="text/css">

#custdiv{
margin-left:25%;
margin-top:1%;
}
div#a1{
display:none;
float:left;
margin-left:25%;
}
table,th,td{
border:1px solid black;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="companyBanner.html" %>

<div class="form-group col-sm-5" id="custdiv" >

	<form >
		<label for="customerId">customerId</label>
		<input type="number" name="customerId" id="customerId" class="form-control  " /> <br/>
		
		<input type="button" id="button" value="Get Customers Details" class="btn btn-success" />
	</form>
	
</div>	

<p id="custData"></p>

<div id="a1" >
<p>Customer Details :</p>
	<table>
	<tr>
		<th>CustomerId</th>
		<th>CustomerName</th>
		<th>MobileNumber</th>
		<th>CarNumber</th>
		<th>CarModel</th>
	</tr>
		<tr>
		<td id="c1"></td>
		<td id="c2"></td>
		<td id="c3"></td>
		<td id="c4"></td>
		<td id="c5"></td>
		</tr>
	</table>
</div>


</body>
</html>