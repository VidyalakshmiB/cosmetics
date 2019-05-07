<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Header.jsp" %>

<html>
<head>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

 
 <c:url value="/resources/images" var="img"/> 
 <link rel="stylesheet" href="${img}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${img}/css/style.css" />
 
<c:url value="/resources/cssfiles" var="css"/>
<c:url value="/resources/jsfiles" var="js"/>

 <link rel="stylesheet" href="${css}/vcart.css">
 <script src="${js}/vcart.js"></script>
 
</head>

<body>
<h1>${items} ViewCart </h1>
 
<div class="shopping-cart">
 
  <div class="column-labels">
    <label class="product-image">Image</label>
    <label class="product-details">Productdescription</label>
    <label class="product-price">Price</label>
     <label class="product-removal">Remove</label>
  </div>
  
   <c1:forEach items="${cartItems}" var="pro">
   
  <div class="product">
    <div class="product-image">
      <img src="<c:url value='/resources/images/${pro.getProd().getProd_Id()}.jpg'/>">
      
      
          </div>
    <div class="product-details">
      <div class="product-title">${pro.getProd().getProd_Name()}</div>
      <p class="product-description">${pro.getProd().getProd_description()}</p>
    </div>
    <div class="product-price">${pro.getProd().getProd_price()}</div>
    
   
   <div class="product-removal">
      <a href="<c:url value="/Remove/${pro.getCartitems_Id()}"/>"><button class="remove-product">
        Remove
      </button></a>
    </div>
 
  
    
     <div class="btn-group">
    <a href="<c:url value="/Buy/${pro.getProd().getProd_Id()}/${pro.getCartitems_Id()}"/>"><button type="button" class="btn btn-primary">Buy</button></a>
   </div>
   </div>
    
  <!-- <div class="product-line-price"></div> -->
  
   
 
        </c1:forEach>
         <div class="totals-item totals-item-total" style="margin-left:1250px">
      <h1>Grand Total</h1>
      <div class="totals-value" id="cart-total">${gtotal}</div>
    </div>
         
      <button class="checkout"><a href="<c:url value="/Buyall"/>">Buy ALL</a></button>
       <button class="removeall"><a href="<c:url value="/Removeall"/>">Remove ALL</a></button>
 </div></div>
</div>
</body>
<%@ include file="Footer.jsp" %> 
</html>