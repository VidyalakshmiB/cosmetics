<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
<%@ include file="Header.jsp" %>
<html lang="en">
<head>
  <title>Payment method</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<c:url value="/resources/cssfiles" var="css"/>
<link rel="stylesheet" href="${css}/pay.css">
 
</head>

<body>
<div style="margin-bottom:250px">
<c:url value="/paym" var="pay"/>
<form:form action="${pay}" method="post" commandName="payment">
<div class="box" >
   
     <p>Payment Method?</p>
   
        <input type="radio" name="paym" value="cod"/>Cash<span>
        </span>
 
   
        <input type="radio" name="paym" value="card"/>
        <span class="yes">Card </span>

    
        <input type="radio" name="paym" value="net"/>
        <span class="yes">Bank</span>
  <br>
  <br>
    <input type="submit" value="submit" style="background-color:green">
</div>
<br>
<br>
   
</form:form>

</body>
</div>
<br>
<br>
<br>
<br>
<%@ include file="Footer.jsp" %> 

</html>