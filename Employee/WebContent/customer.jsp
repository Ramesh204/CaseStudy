<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
Hello
<a href="addCustomer.jsp">Add Customer</a>

<form>
<label for="carNumber">CarNumber</label>
<input type="text" name="carNumber" id="carNumber" />
<input type="button" value="submit" id="button"/>
</form>

<p id="infm"></p>
</body>
</html>