<%@taglib prefix="c" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Header.jsp" %>

<html>
<head>
	
	<c:url value="/resources/cssfiles" var="css"/>
	<link rel="stylesheet" href="${css}/ordconfirm.css">
<style>
table, th, td {
    border: 3px solid blue;
    border-collapse: collapse;
    
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    margin: 4px 2px;
    cursor: pointer;
}
.tableinfo
{
height: 120px;
}
</style>
</head>
<body>
<p class="info"> YOUR  PRODUCT  INFORMATION </p>
  
  <div style="height:120px">
  <table width="100%">
  <tbody>
<tr style="align:center">
<th class="prodname"> PRODUCT IMAGE </th>
<th class="prodname"> NAME </th>
<th class="prodname"> PRICE </th>
</tr>


 <c1:if test="${prot!=null}">
      <tr >
        <td class="style"><img src="<c:url value='/resources/images/${prot.getProd_Id()}.jpg'/>" width="150px" height="200px"></td>
        <td class="style">${prot.getProd_Name()}</td>
<%--         <td>${prot.getDes()}</td>  --%>
<%--         <td style="border: 1px solid black">${prot.getCategory().getCatName()}</td> --%>
<%--         <td style="border: 1px solid black">${prot.getSupplier().getSupName()}</td> --%>
        <td class="style">${prot.getProd_price()}</td>
       </tr> 
      </c1:if>
    <c1:if test="${prot==null}">
     <c1:forEach items="${cartItems1}" var="c1">
      <tr>
        <td style="border: 2px solid blue; height:100px;"><img height="100px" src="<c:url value='/resources/images/${c1.getProd().getProd_Id()}.jpg'/>"></td>
        <td>${c1.getProd().getProd_Name()}</td>
<%--         <td>${c1.getproduct.getDes()}</td> --%>
          <td>${c1.getProd().getProd_price()}</td>
        
      </tr>
      </c1:forEach>
      </c1:if>
   

<!-- <tr style="align:center"> -->
<%-- <th align="center" >${prot.getProductID()}</th> --%>
<%-- <th align="center"> ${prot.getName()} </th> --%>
<%-- <th align="center">${prot.getPrice()} .Rs</th> --%>
<%-- <th align="center">${prot.getQty()}</th> --%>
<!-- </tr> -->
</div>
 
 <br>
<br>

 <table width="100%">
 <br>
 <br>
 <p class="bill">YOUR BILLING DETAILS</p>
<tr style="align:center">
<th align="center" >BILLING ID</th>
<th align="center"> NAME </th>
<th align="center">ADDRESS</th>
<th align="center">PHONE NO</th>
</tr>

<tr style="align:center">
<th align="center" >${billing.getBill_Id()}</th>
<th align="center"> ${billing.getBill_Name()} </th>
<th align="center">${billing.getAddress()}</th>
<th align="center">${billing.getCity()}</th>
</tr>
<br>
</tbody>
</table>
<br>

<table style="width:100%">
<p class="bill">YOUR SHIPPING DETAILS</p>
<tr style="align:center">
<th align="center" >SHIP ID</th>
<th align="center"> NAME </th>
<th align="center">ADDRESS</th>
<th align="center">PHONE NO</th>
</tr>

<tr style="align:center">
<th align="center" >${shippingAddress.getShip_Id()}</th>
<th align="center"> ${shippingAddress.getUser().getUser_Name()}</th>
<th align="center">${shippingAddress.getAddress()}</th>
<th align="center">${shippingAddress.getPhone()}</th>
</tr>
<%--     <c1:if test="${prot==null}"> --%>
<%--      <c1:forEach items="${cartItems}" var="c1"> --%>
<!--       <tr> -->
<!--         <td style="border: 1px solid black"><img src=""></td> -->
<%--         <td style="border: 1px solid black">${c1.getProduct().getName()}</td> --%>
<%-- <%--         <td>${c1.getproduct.getDes()}</td>  --%>
<%--         <td style="border: 1px solid black">${c1.getProduct().getCategory().getCategoryname()}</td> --%>
<%--         <td style="border: 1px solid black">${c1.getProduct().getSupplier().getName()}</td> --%>
<%--         <td style="border: 1px solid black">${c1.getProduct().getPrice()}</td> --%>
<%-- <!--       </tr> --> --%>
<%--       </c1:forEach> --%>
<%--       </c1:if> --%>
</table>

<button class="removeall"><a href="<c:url value=""/>">Cancel</a></button>
<button class="checkout"><a href="<c:url value="/pay"/>">PAY</a></button>



</body>
<%@ include file="Footer.jsp" %>
</html>