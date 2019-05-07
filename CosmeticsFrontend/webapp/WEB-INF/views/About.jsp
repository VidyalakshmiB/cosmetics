<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
  <%@ include file="Header.jsp" %>

<head>
   <title>About us</title>
    
     <c:url value="/resources/cssfiles" var="css"/>
  
    
   <link rel="stylesheet" href="${css}/about.css">

</head>



<body>
<section class="home-about-area section-gap">
				<div class="container">
					<div class="row">
						<div class="col-lg-9">
<!-- 							<h6 class="text-uppercase"style="text-align:center;">Brand new app to blow your mind</h6> -->
							<h1 style="text-align:center;color:blue;">
							ABOUT US
							</h1>
							<p>
								<span>We are here to listen from you deliver exellence by any meansLorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod </span>
							</p>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temp or incididunt ut labore et dolore magna aliqua. Ut enim ad minim. Lorem ipsum dolor sit amet, 
								consectetur adipisicing elit, sed do eiusmod temp or incididunt ut labore et dolore magna aliqua. Ut enim ad minim.
							</p>
							<a class="primary-btn squire mx-auto mt-20" href="#">To Know more</a>						
						</div>
					</div>
				</div>	
				<img class="about-img" src="${img}/lipstick.jpg" alt="image12">
			</section>
			<br>
<br>
   
			
</body> 
<br>
<br>
<br>
<br>
<%@ include file="Footer.jsp" %> 
</html>