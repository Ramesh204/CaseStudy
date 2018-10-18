<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style type="text/css">
#regdiv{
margin-left:25%;
margin-top:5%;
}
</style>
<title>Insert title here</title>
</head>
<body>

<%@include file="companyBanner.html" %>

<div class="form-group col-sm-5" id="regdiv">
<form action="addemp" method="post">
	<label for="employeeName">Employee Name</label>
	<input type="text"  class="form-control  "/><br/>
	<label for="userName">UserName</label>
	<input type="text" name="userName" class="form-control  "/><br/>
	<label for="passWord">PassWord</label>
	<input type="text"  name="passWord" class="form-control  "/><br/>
	<input type="submit" value="Register" class="btn btn-success" />
</form>
<div>

</body>
</html>