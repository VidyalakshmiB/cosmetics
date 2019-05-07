<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
  <%@ include file="Header.jsp" %>
  
<html lang="en">
<head>
<title>Signup </title>
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
 
 <link rel="stylesheet" href="${css}/signup.css">
 <script src="${js}/signup.js"></script>
</head>
<body>

<div class="container">
  <h2 style="text-align:center;">Signup</h2>
 
 
  <c:url value="/adduse" var="user1"/>
   
   <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
           
            <p id="profile-name" class="profile-name-card">User Details</p>
            <form:form action="${user1}" method="post" commandName="user">
            
               <span id="reauth-email" class="reauth-email"></span>
               
               <form:input type="text" id="inputEmail" class="form-control" placeholder="User ID" path="User_Id" required="required"/>
               
               
               <form:input type="text" id="inputEmail" class="form-control" placeholder="User Name" path="User_Name" required="required"/>
                
               
               
                 
                 <form:input type="text" id="inputEmail" class="form-control" placeholder="User Address" path="User_Address" required="required"/>
                
                
                <form:input type="email" id="inputEmail" class="form-control" placeholder="User Email" path="User_EmailId" required="required"/>
             
                
                 <form:input type="text" id="inputEmail" class="form-control" placeholder="User phone" path="User_Phno" required="required"/>
             
               
                     <form:input type="text" id="inputEmail" class="form-control" placeholder="User password" path="User_password" required="required"/>
                           
                <form:input type="text" id="inputEmail" class="form-control" placeholder="User city" path="User_city" required="required"/>
                <div  id="remember" class="checkbox">
               
           
               
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Submit</button>
                    <button class="btn btn-lg btn-primary btn-block btn-signout" type="submit">Cancel</button>
                </div>
               
            </form:form>
          
        </div><!-- /card-container -->
    </div>
    
   
   
   

</body> 
<%@ include file="Footer.jsp" %> 
</html>