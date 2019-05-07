<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact us</title>
	
	   
	
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="${Contact}/Contact_images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_fonts/font-awesome-4.7.0">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_fonts/Linearicons-Free-v1.0.0">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_vendor/daterangepicker/daterangepicker.js">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_css/util.css">
	<link rel="stylesheet" type="text/css" href="${Contact}/Contact_css/main.css">
<!--===============================================================================================-->



</head>
<body>


	<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>

		<div class="wrap-contact100">
			<form class="contact100-form validate-form">
				<span class="contact100-form-title">
					Contact Us
				</span>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<input class="input100" type="text" name="name" placeholder="Full Name">
					<span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
					<input class="input100" type="text" name="email" placeholder="Email">
					<span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Message is required">
					<textarea class="input100" name="message" placeholder="Your Message"></textarea>
					<span class="focus-input100-1"></span>
					<span class="focus-input100-2"></span>
				</div>

				<div class="contact100-form-checkbox">
					<input class="input-checkbox100" id="ckb1" type="checkbox" name="copy-mail">
					<label class="label-checkbox100" for="ckb1">
						Send copy to my-email
					</label>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						Send Email
					</button>
				</div>
			</form>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/bootstrap/js/popper.js"></script>
	<script src="${Contact}/Contact_vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/daterangepicker/moment.min.js"></script>
	<script src="${Contact}/Contact_vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="${Contact}/Contact_js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="${Contact}/Contact_js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>
<%@include file="Footer.jsp" %>
    </body>
    </html>
    

