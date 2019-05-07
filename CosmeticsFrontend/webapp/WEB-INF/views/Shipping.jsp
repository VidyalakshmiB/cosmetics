<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>


<html lang="en">
 
  <head>
  
  <link rel="stylesheet" href="${css}/bil.css">
 <script src="${js}/bil.js"></script>
    
</head>


<body>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
    <c:url value="/orderConfirm" var="a"/>
         <form:form id="ms-form" action="${a}" method="post" commandName="shippingAddress">
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Billing</li>
                <li class="active">Shipping</li>
                <li>Order confirm</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Shipping</h2>
                <h3 class="fs-subtitle">Your Shipping Information</h3>
                <form:input type="text" name="fname" placeholder="Shipping ID" path="ship_Id" required="required"/>
                <form:input type="text" name="lname" placeholder="Shipping Name" path="Name" required="required"/>
                <form:input type="text" name="phone" placeholder="Shipping phone" path="phone" required="required"/>
                <form:input type="text" name="address" placeholder="Shipping address 1" path="Address" required="required"/>
                <form:input type="text" name="city" placeholder="Shipping city" path="city" required="required"/>
            
                

                <button type="submit" name="next" class="btn btn-primary" value="Next"/>Next</button>
            </fieldset>
                  </form:form>
      </div>  
</div>
</body>

<%@ include file="Footer.jsp" %> 

</html>