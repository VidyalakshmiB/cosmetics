<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<head>
<c:url value="/resource" var="img" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>


	<script>
var app=angular.module('myApp',[]);
app.controller('myctrl',function($scope, $http) {
	$http.get("http://localhost:8080/CosmeticsFrontend/SendMail")
});
</script>
	
	

</head>
<body>
<%@ include file="Header.jsp" %>
		

	<div class="container">
		<c:url value="/payment" var="addcard" />
		
		<form:form action="${addcard}" method="POST" commandName="payment">
		
		     <div class="form-group" style="margin-top: 50px";>
				<label for="Card_no">Card_No </label>
				<input type="text" class="form-control" name="card_Name"/>
			</div>
			<div class="form-group">
				<label for="Holder_name">Holder_Name</label>
				<input type="text" class="form-control" name="holder_Name"/>
			</div>
			<div class="form-group">
				<label for="Exp_date">Exp_Date </label>
				<input type="number" class="form-control" name="exp_Date"/>
			</div>
			<div class="form-group">
				<label for="Exp_month">Exp_Month </label>
				<input type="number" class="form-control" name="exp_Month"/>
			</div>
			<div class="form-group">
				<label for="Exp_year">Exp_Year</label>
				<input type="number" class="form-control" name="exp_year"/>
			</div>
			
			<div class="form-group">
				<label for="Exp_year">Enter the OTP which is sent to your mail</label>
				<input type="text" ng-app="myApp" ng-controller="myctrl" class="form-control" name="otp"/>
			</div>
			
			
			<button type="submit" class="btn btn-success" value="save">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form:form>
		
		
</body>
<%@ include file="Footer.jsp" %> 

</html>