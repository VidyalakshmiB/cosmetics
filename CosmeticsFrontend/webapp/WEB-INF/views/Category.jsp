
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>

  
<html lang="en">
<head>
  <title>Category Details</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



 <link rel="stylesheet" href="${css}/category.css">
 <script src="${js}/category.js"></script>
 
 
   
 </head>
<body>

  <div class="container">
  
   <h2>Category</h2>
 
  <c:url value="/addcat" var="cat"/>
  
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
           
            <p id="profile-name" class="profile-name-card">Catogery</p>
            <form:form class="form-signin" action="${cat}" method="post" commandName="category">
            
               <span id="reauth-email" class="reauth-email"></span>
               
               <form:input type="text" id="inputEmail" class="form-control" placeholder="Catogery ID" path="catId" required="required"/>
                
               
               <form:input type="text" id="inputEmail" class="form-control" placeholder="Catogery Name" path="catName" required="required"/>
                
               
                <div  id="remember" class="checkbox">
                    
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
                    <button class="btn btn-lg btn-primary btn-block btn-signout" type="submit">Cancel</button>
                </div>
               
            </form:form>
          
        </div><!-- /card-container -->
    </div>
    
    
<table border="1px solid black">
<tr>
 <th>catId</th> 
<th>catName</th> 
<th>Edit/Delete</th> 
</tr>
 <c1:forEach items="${categories}" var="cat1"> 
 <tr> 
 
<td>${cat1.getCatId()}</td>
<td>${cat1.getCatName()}</td> 
<td><a href="<c:url value="/editcategory/${cat1.getCatId()}"/>">Edit</a>/<a href="<c:url value="/deletecategory/${cat1.getCatId()}"/>">Delete</a></td>
</tr>
 </c1:forEach>
 </table>



<%@ include file="Footer.jsp" %>
</body>
</html>