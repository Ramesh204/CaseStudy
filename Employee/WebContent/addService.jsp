<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
div#a1{
display:none;
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
			
			net = grassAmount - data;
			$('#amount').text(net);
			
			$('#servdiv').slideUp();
			
			$('#a1').slideDown('slow',function(){
				
				$("#servId").val(serviceId);
				$("#carNum").val(carNumber);
				$("#servType").val(policyName);
				$("#grassAmunt").val(grassAmount);
				$("#insAmunt").val(data);
				$("#netAmunt").val(net);
				
			});
			
				
		});
		

		
		
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div id="servdiv">
<form >
	<label for="serviceId">serviceId</label>
	<input type="number" name="serviceId" id="serviceId"/>
	
	<label for="carNumber">carNumber</label>
	<input type="text" name="carNumber" id="carNumber"/>
	
	<select name="policyName" id="policyName">
		<option value="Polishing">Polishing</option>
		<option value="WheelBalancing">WheelBalancing</option>
		<option value="AccessoriesReplacement">AccessoriesReplacement</option>
		<option value="CollisionCoverage">CollisionCoverage</option>
	</select>
	
	<label for="grassAmount">grassAmount</label>
	<input type="number" name="grassAmount" id="grassAmount"/>
	
	<input type="button"  id="button" value="submit"/>
</form>  
</div>


<p id="amount"></p>


<div id="a1">
<form action="rest/service/add" method="post">
	<label for="serviceId">serviceId</label>
	<input type="number" name="serviceId"  id="servId"  />
	
	<label for="carNumber">carNumber</label>
	<input type="text" name="carNumber" id="carNum"   />
	
	<label for="serviceType">serviceType</label>
	<input  type="text" name="serviceType"  id="servType"   />
	
	<label for="grassAmount">grassAmount</label>
	<input type="number" name="grassAmount"  id="grassAmunt"   />
	
	<label for="insuranceAmount">insuranceAmount</label>
	<input type="text" name="insuranceAmount"  id="insAmunt"   />
	
	<lable for="netAmount">netAmount</lable>
	<input type="text" name="serviceAmount"  id="netAmunt"   />
	
	<input type="submit"  id="btn" value="submit"/>
</form>  
</div>

</body>
</html>