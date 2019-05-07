<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %><%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>


<html>
<head>
  <title>Supplier Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<c:url value="/resources/cssfiles" var="css"/>
<c:url value="/resources/jsfiles" var="js"/>

<link rel="stylesheet" href="${css}/supplier.css">
 <script src="${js}/supplier.js"></script>

</head>
<body>


   <div class="container">
     <h2>Supplier</h2>
    <c:url value="/addsup" var="sup"/>
 
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
           
            <p id="profile-name" class="profile-name-card">Supplier Details</p>
           
            <form:form class="form-signin" action="${sup}" method="post" commandName="supplier">
                <span id="reauth-email" class="reauth-email"></span>
                 
                     <form:input type="text" id="inputEmail" class="form-control" placeholder="Supplier Id" path="supId" required="required"/>
            
             
                    <form:input type="text" id="inputEmail" class="form-control" placeholder="Supplier Name" path="supName" required="required"/>
                
              
                     <form:input type="text" id="inputEmail" class="form-control" placeholder="Supplier EmailId" path="supE_mail" required="required"/>
           
                   
                   <form:input type="text" id="inputEmail" class="form-control" placeholder="Supplier Phone" path="phone_no" required="required"/>
               
                     
                     <form:input type="text" id="inputEmail" class="form-control" placeholder="Supplier Address" path="sup_Address" required="required"/>
                     <div  id="remember" class="checkbox">


                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
                    <button class="btn btn-lg btn-primary btn-block btn-signout" type="reset">Cancel</button>
                </div>
               
            </form:form>
          
        </div><!-- /card-container -->
   
 

  <div>
<table border="1px solid black"> 
<tr> 
<th>Supplier Id</th> 
<th>Supplier_Name</th> 
<th>Supplier Email</th> 
<th>Supplier Phone</th> 
<th>Supplier Address</th>
<th>Edit/Delete</th> 
</tr>
 <c1:forEach items="${suppliers}" var="sup">
  <tr> 
  
<td>${sup.getSupId()}</td>
<td>${sup.getSupName()}</td> 
<td>${sup.getSupE_mail()}</td>
<td>${sup.getPhone_no()}</td>
<td>${sup.getSup_Address()}</td>
<td><a href="<c:url value="/editsupplier/${sup.getSupId()}"/>">Edit</a>/<a href="<c:url value="/deletesupplier/${sup.getSupId()}"/>">Delete</a></td>

</tr> 
</c1:forEach> 
</table>
</div>
 </div>
 

</body>
<%@include file ="Footer.jsp" %>
</html>

