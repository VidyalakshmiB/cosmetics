<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
<%@ include file="Header.jsp" %>

<html lang="en">
<head>
  <title>otp</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>
var app=angular.module('myApp',[]);
app.controller('myctrl',function($scope, $http) {
	$http.get("http://localhost:8080/CosmeticsFrontend/SendMail")
});
</script>



<c:url value="/resources/cssfiles" var="css"/>
<link rel="stylesheet" href="${css}/otp.css">
 

</head>
<body>
<div style="margin-bottom:250px">

<c:url value="/payment" var="pay"/>
<div class="box">
	<p>Payment Method</p>
	 <form:form action="${pay}" method="post" commandName="payment">
      
      <div class="form-group">
      <label for="email">cash on delivery</label>
     <input type="text" ng-app="myApp" ng-controller="myctrl" class="form-control" id="email"  placeholder="Enter your OTP" name="otp">
   
    
    <button type="submit" class="btn btn-success">pay</button>
    </div>
    
    </form:form>
    </div>
</body>
</div>
<br>
<br>
<br>
<br>
<%@ include file="Footer.jsp" %> 

</html>
