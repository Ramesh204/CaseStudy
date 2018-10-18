<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<style type="text/css">
div#a1{
display:none;
margin-left:25%;
margin-top:1%;
}

div#servdiv{
margin-left:25%;
margin-top:1%;
}
h2{
color:blue;
text-align:center;
}
#frm2{

}
</style>
<script type="text/javascript" src="jquery1-7-2.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#button").on('click',function(){
		
		var carNumber= $("#carNumber").val();
		var policyName = $("#policyName").val();
		var serviceId = $("#serviceId").val();
		var grassAmount = $("#grassAmount").val();
		
		console.log(carNumber+","+policyName+","+serviceId+','+grassAmount);
		
		$.get("http://localhost:8080/InsuranceAgent/rest/insurance/policyAmount/"+carNumber+"/"+policyName,function(data){
			
			var netAmount = 0;
			if((netAmount = grassAmount - data)>0)
			{
				
				$("#netAmunt").val(netAmount);
			}
			else if(data==0){
				netAmount =grassAmount;
				
				$("#netAmunt").val(netAmount);
				}
			else{
				netAmount = 0;
				$("#netAmount").val(netAmount);
			}
			
			
			
			$('#servdiv').slideUp();
			
			$('#a1').slideDown('slow',function(){
				
				$("#servId").val(serviceId);
				$("#carNum").val(carNumber);
				$("#servType").val(policyName);
				$("#grassAmunt").val(grassAmount);
				$("#insAmunt").val(data);
				
				
			});
			
			
				
		});
		

		
		
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="companyBanner.html" %>


<div id="servdiv" class="form-group col-sm-5">
	
<form >
	<h2>Create A CarService </h2>
	<label for="serviceId">serviceId</label>
	<input type="number" name="serviceId" id="serviceId" class="form-control" /> <br/>
	
	<label for="carNumber">carNumber</label>
	<input type="text" name="carNumber" id="carNumber" class="form-control " /> <br/>
	
	<label for="policyName">Select Policy</label>
	<select name="policyName" id="policyName" class="form-control " >
		<option value="Polishing">Polishing</option>
		<option value="WheelBalancing">WheelBalancing</option>
		<option value="AccessoriesReplacement">AccessoriesReplacement</option>
		<option value="CollisionCoverage">CollisionCoverage</option>
	</select> <br/>
	
	<label for="grassAmount">grassAmount</label>
	<input type="number" name="grassAmount" id="grassAmount" class="form-control " /> <br/>
	
	<input type="button"  id="button" value="submit" class="btn btn-success" />
</form>  
</div>





<div id="a1"  class="form-group col-sm-5" >
	
<form action="rest/service/add" method="post" id="frm2">
	<h2>Check All Details To Confirm A Service</h2>
	<label for="serviceId">serviceId</label> 
	<input type="number" name="serviceId"  id="servId" class="form-control" />
	
	<label for="carNumber">carNumber</label>
	<input type="text" name="carNumber" id="carNum" class="form-control "  />
	
	<label for="serviceType">serviceType</label>
	<input  type="text" name="serviceType"  id="servType" class="form-control "  />
	
	<label for="grassAmount">grassAmount</label>
	<input type="number" name="grassAmount"  id="grassAmunt" class="form-control "  />
	
	<label for="insuranceAmount">insuranceAmount</label>
	<input type="text" name="insuranceAmount"  id="insAmunt"  class="form-control  " />
	
	<lable for="netAmount">netAmount</lable>
	<input type="text" name="serviceAmount"  id="netAmunt" class="form-control "  />
	
	<input type="submit"  id="btn" value="submit" class="btn btn-success" />
</form>  
</div>

</body>
</html>