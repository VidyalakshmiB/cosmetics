<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
  <title>shopping cart</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> 
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">

<c:url value="/resources/images" var="img"/> 
<c:url value="/resources/cssfiles" var="css"/> 
 
 
 
   <link rel="stylesheet" href="${css}/home.css">
  <link rel="stylesheet" href="${css}/footer.css">
    <script src="${js}/home.js"></script>
</head>
<body>
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<div id="flipkart-navbar">
    <div class="container">	
        <div class="row row1">
            <ul class="largenav pull-right">
                <li class="upper-links"><a class="links" href="<c:url value="/"/>">Home</a></li>
                <c1:if test="${pageContext.request.userPrincipal.name!=null}">
                
                <security:authorize access="hasRole('ROLE_ADMIN')">
               <li class="upper-links dropdown"><a class="links" href="#">Admin</a>
                    <ul class="dropdown-menu">
                        <li class="profile-li"><a class="profile-links" href="<c:url value="/Category"/>">Add Catogery</a></li>
                        <li class="profile-li"><a class="profile-links" href="<c:url value="/Supplier"/>">Add Supplier</a></li>
                        <li class="profile-li"><a class="profile-links" href="<c:url value="/Product"/>">Add Product</a></li>
                       
                    </ul>
                </li>
                </security:authorize>
                </c1:if>
                <li class="upper-links"><a class="links" href="<c:url value="/About"/>">Aboutus</a></li>
                <li class="upper-links"><a class="links" href="<c:url value="/Contact"/>">Contact</a></li>
                <li class="upper-links"><a class="links" href="<c:url value="/ProductGal"/>">ProductGallery</a></li>
                <c1:if test="${pageContext.request.userPrincipal.name==null}">
                
                <li class="upper-links"><a class="links" href="<c:url value="/User"/>">Signup</a></li>
                <li class="upper-links"><a class="links" href="<c:url value="/login"/>">Login</a></li>
               
                </c1:if>
                <c1:if test="${pageContext.request.userPrincipal.name!=null}">
               
                <li class="upper-links"><a class="links" href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
                
                </c1:if>
              <li class="upper-links"> Welcome ${pageContext.request.userPrincipal.name}</li>
            </ul>
        </div>
        <div class="row row2">
            <div class="col-sm-2">
                <h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()">☰ Cosmetics</span></h2>
                <h1 style="margin:0px;"><span class="largenav">Cosmetics</span></h1>
            </div>
            <div class="flipkart-navbar-search smallsearch col-sm-8 col-xs-11">
                <div class="row">
                    <input class="flipkart-navbar-input col-xs-11" type="" placeholder="Search for Products, Brands and more" name="">
                    <button class="flipkart-navbar-button col-xs-1">
                        <svg width="15px" height="15px">
                            <path d="M11.618 9.897l4.224 4.212c.092.09.1.23.02.312l-1.464 1.46c-.08.08-.222.072-.314-.02L9.868 11.66M6.486 10.9c-2.42 0-4.38-1.955-4.38-4.367 0-2.413 1.96-4.37 4.38-4.37s4.38 1.957 4.38 4.37c0 2.412-1.96 4.368-4.38 4.368m0-10.834C2.904.066 0 2.96 0 6.533 0 10.105 2.904 13 6.486 13s6.487-2.895 6.487-6.467c0-3.572-2.905-6.467-6.487-6.467 "></path>
                        </svg>
                    </button>
                </div>
            </div>
            <div class="cart largenav col-sm-2">
                <a class="cart-button" href="<c:url value="/viewcart"/>">
                    <svg class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 " fill="#fff "></path>
                    </svg> Link
                    <span class="item-number ">${items}</span>
                </a>
            </div>
        </div>
    </div>
</div>
<div id="mySidenav" class="sidenav">
    <div class="container" style="background-color: #2874f0; padding-top: 10px;">
        <span class="sidenav-heading">Home</span>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    </div>
    <a href="#">Link</a>
    <a href="#">Link</a>
    <a href="#">Link</a>
    <a href="#">Link</a>
</div>

  
  <div class="container" Style ="width : 100%;">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="${img}/Bouquet-Collection_HARRODS.COM_262.47x105.13_V5-Cosmetics-Banner.jpg" alt="image3" style="width:100%; height:800px">
        
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>
      </div>

      <div class="item">
        <img src="${img}/banner_20170821_170306.png" alt="image1" style="width:100%; height:800px">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>
      </div>
    
      <div class="item">
        <img src="${img}/Banner-Design1.jpg" alt="image2" style="width:100%; height:800px">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
<%@ include file="Footer.jsp" %>
</html>
