<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">
div#servdiv{
margin-left:25%;
margin-top:1%;
}
div#a1{
display:none;
float:left;
}
table,th,td{
border:1px solid black;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery1-7-2.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").on('click',function(){
		var serviceId = $("#serviceId").val();
		console.log(serviceId);
		
		$.get("http://localhost:8080/AutomobileService/rest/service/details/"+serviceId,function(data){
					
			var str1 = data['serviceId'];
			var str2 = data['serviceAmount'];
			$('#a1').slideDown('fast',function(){
				$('#c1').text( data.car['carNumber']);
				$('#c2').text( str1);
				$('#c3').text( str2);
				$('#c4').text( data['serviceType']);
			});
		
		});
		
	
	});
});
</script>
</head>
<body>
<%@include file="companyBanner.html" %>

<!-- 
<div class="form-group col-sm-5" id="servdiv" >
<form action="rest/service/details" method="post">
	<label for="serviceId">serviceId</label>
	<input type="number" name="serviceId" id="serviceId" class="form-control" /> <br/>
	
	<input type="submit" value="Get Service" class="btn btn-success" />
</form>

</div>

 -->

<div class="form-group col-sm-5" id="servdiv" >
<form >
	<label for="serviceId">serviceId</label>
	<input type="number" name="serviceId" id="serviceId" class="form-control" /> <br/>
	
	<input type="button" value="Get Service" class="btn btn-success" id="btn" />
</form>
</div>



<div id="a1" >
<p>Service Details :</p>
	<table>
	<tr>
		<th>CarNumber</th>
		<th>ServiceId</th>
		<th>ServiceAmount</th>
		<th>ServiceType</th>
	</tr>
		<tr>
		<td id="c1"></td>
		<td id="c2"></td>
		<td id="c3"></td>
		<td id="c4"></td>
		</tr>
	</table>
</div>


</body>
</html>