<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>



<html lang="en">
 <head>
    <c:url value="/resources/cssfiles" var="css"/>
    <c:url value="/resources/jsfiles" var="js"/>
    
   <link rel="stylesheet" href="${css}/bil.css">
 <script src="${js}/bil.js"></script>
   
</head>


<body>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        
        
        <form:form id="ms-form" action="${ship}" method="post" >
            <!-- progressbar -->
            <ul id="progressbar">
                <li class="active">Billing</li>
                <li>Shipping</li>
                <li>Order confirm</li>
            </ul>
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Billing </h2>
                <h3 class="fs-subtitle">Billing information</h3>
                
                <input type="text" name="phone" placeholder="BillId" value="${billing.getBill_Id()}" required="required"/>
                
                <input type="text" name="lname" placeholder="Billing Name" value="${billing.getBill_Name()}" required="required"/>
                <input type="text" name="address" placeholder="Billing Address" value="${billing.getAddress()}" required="required"/>
                <input type="text" name="city" placeholder="Billing city" value="${billing.getCity()}" required="required"/>
                
            </fieldset>
          </form:form> 
          
        <a href="<c:url value="/shipping"/>">
                
                 <button type="submit" name="next" class="btn btn-primary" value="Next"/>Next</button>
            </a></div>
</div>

</body>
<%@ include file="Footer.jsp" %> 

</html>