<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="Header.jsp" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
<html>
<head>
<title>Product Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  <link rel="stylesheet" href="${css}/product.css">
 <script src="${js}/product.js"></script>
   
  
  
</head>
<body>
<div class="container">
  
    <h2>Product</h2>
  <c:url value="/addprod" var="prod"/>
 
        <div class="card card-container">
 
   <p id="profile-name" class="profile-name-card">Product Details</p>
    
    <form:form class="form-signin" action="${prod}" method="post" commandName="product" enctype="multipart/form-data">
  
            <span id="reauth-email" class="reauth-email"></span>
            
              <form:input type="text" id="inputEmail" class="form-control" placeholder="Product Id" path="prod_Id" required="required"/>
                
                <form:input type="text" id="inputEmail" class="form-control" placeholder="Product Name" path="prod_Name" required="required"/>
          
                 <form:input type="text" id="inputEmail" class="form-control" placeholder="Product Price" path="prod_price" required="required"/>
               
              
               <form:input type="text" id="inputEmail" class="form-control" placeholder="Product Description" path="prod_description" required="required"/>
               
           
               <form:input type="text" id="inputEmail" class="form-control" placeholder="Product Quantity" path="prod_Qty" required="required"/>
              
                <form:input path="pimg" type="file" name="image" value="upload file"/>
		
                    
                                  <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
                    <button class="btn btn-lg btn-primary btn-block btn-signout" type="reset">Cancel</button>
                </div>
          
           	</form:form>
   
    </div>
  </div>



<table border="1px solid black"> 
<tr> 
<th>Product_Id</th> 
<th>Product_Name</th> 
<th>Description</th> 
<th>Price</th> 
<th>Quantity</th>
<th>image</th> 
<th>Edit/Delete</th> 
</tr>
 <c1:forEach items="${products}" var="prod">
  <tr> 
  
<td>${prod.getProd_Id()}</td> <td>${prod.getProd_Name()}</td> 
<td>${prod.getProd_description()}</td> <td>${prod.getProd_price()}</td> 
<td>${prod.getProd_Qty()}</td> 
<td><img src="<c:url value="/resources/images/${prod.getProd_Id()}.jpg"/>"style="width:100px; height:100px margin-left:20px"></td> 
<td><a href="<c:url value="/editproduct/${prod.getProd_Id()}"/>">Edit</a>/<a href="<c:url value="/deleteproduct/${prod.getProd_Id()}"/>">Delete</a></td>

</tr> 
</c1:forEach> 
</table>


</body> 
<%@include file="Footer.jsp" %>
</html>

