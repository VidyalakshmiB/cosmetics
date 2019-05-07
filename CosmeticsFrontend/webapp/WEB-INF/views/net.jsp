<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
<%@ include file="Header.jsp" %>
<html lang="en">
<head>
  <title>net Banking</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>




<c:url value="/resources/cssfiles" var="css"/>
	<link rel="stylesheet" href="${css}/net.css">
		</head>

<body>

<div class="loader" style="margin-top:80px">
<h2 Style="text-align:center;">Processing</h2>
</div>
<h3 Style="text-align:center;"><a href="<c:url value="/"/>">Click Here for more Shopping</a></h3>
<div>

<c:url value="/netpayment" var="pay"/>
<div class="box" style="margin-top: 50px">
	<p>Payment Method</p>
	 <form:form action="${pay}" method="post" commandName="payment">
      
    
    <button type="submit" class="btn btn-success">pay</button>
   
    
    </form:form>
    </div> </div>
</body>
</div>
<br>
<br>
<br>
<br>

<%@ include file="Footer.jsp" %> 
</html>