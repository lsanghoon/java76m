<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <script type="text/javascript" src="enhance.js"></script> 
  <script type="text/javascript">
    // Run capabilities test
    enhance({
      loadScripts: [
        {src: 'excanvas.js', iecondition: 'all'},
        'jquery.min.js',
        'visualize.jQuery.js',
        'example.js'
      ],
      loadStyles: [
        'visualize.css',
        'visualize-dark.css'
      ] 
    });   
  </script>

<table >
  <caption>2009 Employee Sales by Department</caption>
  <thead>
    <tr>
      <td></td>
      <c:forEach var="chart" items="${charts}">
      <th scope="col">${chart.m}</th>
      </c:forEach>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">Purchase</th>
      <c:forEach var="chart" items="${charts}">
        <td scope="col">${chart.s}</td>
      </c:forEach>
    </tr>
  </tbody>
</table>  

