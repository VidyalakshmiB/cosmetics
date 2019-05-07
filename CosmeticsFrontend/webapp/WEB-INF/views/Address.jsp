<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<c:url value="/resource" var="res" />

<!-- <link rel="stylesheet" ref="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${img}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${img}/css/style.css" />
<link rel="stylesheet" href="${img}/css/font-awesome/css/font-awesome.min.css" />

</head>
<body>
	<%@ include file="Header.jsp" %>
	<br>
	<div class="container box-shadow border-radius">

	<div class="row">

	<div class="col-md-4 col-sm-4 col-xs-12 billing-add">
		<h3 class="text-center">Billing Address</h3>
		<div class="col-md-6 col-sm-6 b-r"><b>Name :</b></div><div class="col-md-6 col-sm-6">${user.getUser_Name()} </div>
		<div class="col-md-6 col-sm-6 b-r"><b>Email :</b></div><div class="col-md-6 col-sm-6">${user.getUser_EmailId()}</div>
		<div class="col-md-6 col-sm-3 b-r"><b>Mobile :</b></div><div class="col-md-6 col-sm-6">${user.getUser_Phno()}</div>
		<div class="col-md-6 col-sm-3 b-r"><b>City :</b></div><div class="col-md-6 col-sm-6">${user.getUser_city()}</div>
		
		<div class="col-md-6 col-sm-6 b-r"><b>Address:</b></div><div class="col-md-6 col-sm-6">${user.getUser_Address()}<br></div>
		</div>
	
	</div>


	<div class="col-md-8 shipping col-sm-8 col-xs-12">
		<h3 class="text-center">shipping Address</h3>

		<hr>
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" commandName="shippingAddress">
		
	
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="UserName" path="ship_Id" required="required"/> 
			</div>
		</div>
		

		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="first_name" id="first_name" class="form-control input-sm" placeholder="Email id" path="Name" required="required"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" class="form-control input-sm" placeholder="User Address" path="Address" required="required"/> 
		</div>
</div>
   
         <div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" class="form-control input-sm" placeholder="User city"  path="city" required="required"/> 
		</div>
</div>
		
		
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="Mobile_no" class="form-control input-sm" placeholder="User phone" path="phone" required="required"/> 
		</div>
</div>
		
<!-- 		<div class="col-xs-12 col-sm-12 col-md-12"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<input type="text" class="form-control input-sm" placeholder="Address"  value="${billing.getAddress()}"/>                                                 --%>
                                           
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<input type="text"	class="form-control input-sm" placeholder="Bill id"  value="${billing.getBill_Id()}"/>  --%>
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<input type="text"	class="form-control input-sm" placeholder="Billing Name"  value="${billing.getBill_Name()}"/> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		
<!-- 		<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<input type="text" class="form-control input-sm" placeholder="Address"  value="${billing.getAddress()}"/>  --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	<div class="col-xs-12 col-sm-4 col-md-4"> -->
<!-- 			<div class="form-group"> -->
<%-- 				<input type="text" class="form-control input-sm" placeholder="City"  value="${billing.getCity()}"/>  --%>
<!-- 			</div> -->
<!-- 		</div> -->

	<div class="col-md-12">
		<input type="submit" class="btn btn-primary pull-right" value="Continue">
	</div>
   </form:form>
  
</div>
</div>
 <br>
</div>


<div class="copyright">
<div class="container">
	
	<span><br> </span>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>

  </body>
  <%@ include file="Footer.jsp" %> 
  
</html>