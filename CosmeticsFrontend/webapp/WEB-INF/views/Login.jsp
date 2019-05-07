 <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
<%@ include file="Header.jsp" %>


  <html lang="en">
   <head>
  <title>login </title>
  <meta charset="utf-8">
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  <c:url value="/resources/images" var="img"/>

<c:url value="/resources/cssfiles" var="css"/>
<c:url value="/resources/jsfiles" var="js"/>

 <link rel="stylesheet" href="${css}/login.css">
 <link rel="stylesheet" href="${css}/footer.css">
 
 <script src="${js}/login.js"></script>

</head>
<body>

    <div class="container">
        <div class="card card-container">
         <h2>User Login</h2>
         <c:url value="/j_spring_security_check" var="login"/>
           
            <img id="profile-img" class="profile-img-card" src="${img}/user-icon-white-silhouette-on-blue-round-vector-20326082.jpg" />
            <p id="profile-name" class="profile-name-card"></p>
           
           
            <form:form class="form-signin" action="${login}" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" id="inputEmail" class="form-control" name="j_username" placeholder="Email address" required autofocus>
                <input type="password" id="inputPassword" class="form-control" name="j_password"  placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
                 <button class="btn btn-lg btn-primary btn-block btn-signout" type="submit">Cancel</button>
             </form:form>
           
           	
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    <%@include file="Footer.jsp" %>
    </body>
    </html>
    