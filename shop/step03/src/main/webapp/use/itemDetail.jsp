<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<link rel="stylesheet" type="text/css" href="../css/chartStyle.css" />

<form name="myForm" method="post" enctype="multipart/form-data">
	<table style="background-color: white;margin-left: auto; margin-right: auto;">
	  <tr>
	    <td rowspan="5" width="400px">
	     <img src="../productfile/${product.pphoto}" width="400px" height="400px">
	     <input type="hidden" name="cpphoto" value="${product.pphoto}" />
	    </td>
	    <td width="100px"></td>
	    <td width="500px" height="50"></td>
	  </tr>
	  <tr>
	    <td height="50"></td>
	    <td>
	     <h1>
	       <input type="text" name="cpname" value="${product.pname}" style="border:none;">
	       <input type="hidden" name="bpname" value="${product.pname}">
	      </h1>
	     <hr>
	    </td>
	  </tr>
	  <tr>
	    <td></td>
	    <td height="80" style="font-size: 26px;">
	     가격: <input type="text" name="cpcost" value="${product.pcost}" readonly style="border:none;">
	    </td>
	  </tr>
	  <tr>
	    <td height="50"></td>
	    <td style="font-size: 23px;">
	     개수: <input type="number" name="cstock" value="1" min="1" max="${product.pstock}" style="width: 65px;"/>
	    </td>
	  </tr>
	  <tr>
	    <td></td>
	    <td height="80"></td>
	  </tr>
	</table>
	
	<hr>
	  <p style="text-align: center;">
	    <button type="submit" class="button" onclick='mySubmit(1)'>즉시구매</button>
	    &nbsp; &nbsp; &nbsp; &nbsp;
	    <button type="submit" class="button" onclick='mySubmit(2)'>장바구니</button>
	  </p>
	<hr>
</form>

<table style="background-color: white;margin-left: auto; margin-right: auto;">
<tr>
  <td><img src="../productfile/${product.fimage}"></td>
</tr>
<tr>
  <td><img src="../productfile/${product.simage}"></td>
</tr>
</table>


<script type="text/javascript">
  function mySubmit(index) {
    if (index == 1) {
      document.myForm.action='../purchase/adddir.do';
    }
    if (index == 2) {
      document.myForm.action='../cart/add.do';
    }
    document.myForm.submit();
  }
</script>