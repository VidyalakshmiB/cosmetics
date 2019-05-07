<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ include file="Header.jsp" %>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c1'%>
 
 
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Responsive Image  Gallery</title>
   <c:url value="/resources/cssfiles" var="css"/>
   <c:url value="/resources/jsfiles" var="js"/>
  
  
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>

      
      <link rel="stylesheet" href="${css}/acart.css">
  
</head>

<body>


  

  <div class="container" style="margin-top:50px;">
<div class="row"> <c1:forEach items="${products}" var="prod">
    <div class="col-md-4 col-sm-4 padcol ">
    
        <div class="col-3">
       
            <a href="#"><img src="<c:url value="/resources/images/${prod.getProd_Id()}.jpg"/>" class="img-responsive" alt="" > </a>
             
                <div class="col-pic">
           <h5> <a href="<c:url value="/addtocart/${prod.getProd_Id()}"/>"> Cart</a></h5>
         
            <h5>${prod.getProd_Name()}</h5>
            <h5>${prod.getProd_price()}</h5>
            <h5>${prod.getProd_description()}</h5>
					
                </div></a>
				
        </div>
	 
    </div></c1:forEach>	
    
     
      </div>
      </div>
      
<!--     <div class="col-md-4 col-sm-4 padcol "> -->
<!--         <div class="col-3"> -->
<%--             <a href="#"><img src="${img}/Lakme+Absolute+Skin+Gloss.png" class="img-responsive" alt=""> --%>
<!--                 <div class="col-pic"> -->
<!--                     <h5><a href="#">Cart</a></h5> -->
<!--                 </div></a> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="col-md-4 col-sm-4 padcol "> -->
<!--         <div class="col-3"> -->
<%--             <a href="#"><img src="${img}/Lakme-Youth-Infinity.png" class="img-responsive" alt="" height="100" width="10"> --%>
<!--                 <div class="col-pic"> -->
<!--                     <h5><a href="#">Cart</a></h5> -->
<!--                 </div></a> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="col-md-4 col-sm-4 padcol "> -->
<!--         <div class="col-3"> -->
<%--             <a href="#"><img src="${img}/Foundation.jpg" class="img-responsive" alt=""> --%>
<!--                 <div class="col-pic"> -->
<!--                     <h5><a href="#">Cart</a></h5> -->
<!--                 </div></a> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="col-md-4 col-sm-4 padcol "> -->
<!--         <div class="col-3"> -->
<%--             <a href="#"><img src="${img}/Lakme+Absolute+Skin+Gloss.png" class="img-responsive" alt=""> --%>
<!--                 <div class="col-pic"> -->
<!--                     <h5><a href="#">Cart</a></h5> -->
<!--                 </div></a> -->
<!--         </div> -->
<!--     </div> -->
<!--     <div class="col-md-4 col-sm-4 padcol "> -->
<!--         <div class="col-3"> -->
<%--             <a href="#"><img src="${img}/lakme eyeliner.png" class="img-responsive" alt=""> --%>
<!--                 <div class="col-pic"> -->
<!--                     <h5><a href="#">Cart</a></h5> -->
<!--                 </div></a> -->
<!--         </div> -->
<!--     </div> -->
<!-- </div> -->
<!--  </div> -->
  
  
<%@ include file="Footer.jsp" %> 
</body>

</html>
