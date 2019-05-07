<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<c:url value="/resource" var="img" />

<!-- <link rel="stylesheet" ref="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${img}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${img}/css/style.css" />
<link rel="stylesheet" href="${img}/css/font-awesome/css/font-awesome.min.css" />

</head>
<body>
	<%@ include file="Header.jsp" %>
  
  <div class="container">

            <div class="row">
<h2 Style="text-align:center;">Thank You For the Order</h2>
<h3 Style="text-align:center;"><a href="<c:url value="/"/>">GO TO HOME PAGE</a></h3>
               </div>
               </div>
</body>

<%@ include file="Footer.jsp" %> 

</html>