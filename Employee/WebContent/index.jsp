<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="jquery1-7-2.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript">
$(function(){
	$.get("http://localhost:8080/InsuranceAgent/rest/insurance",function(resp){
		$("#msg").html(resp);
	});
});
</script>
<style>
a{

font-size:35px;
}
div#links{
margin-left:20%;
margin-top:2%;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="companyBanner.html" %>



<div id="links">
	<a href="Registration.jsp">Register Here</a><br/>
	<a href="login.jsp">Login</a>
</div>


<div id="msg"/>
</body>
</html>