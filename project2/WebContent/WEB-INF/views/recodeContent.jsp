<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<c:choose>
	<c:when test="${fn:length(list) gt 0 }">
		<table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Book Name</th>
          <th scope="col">Book Price</th>
          <th scope="col">Book Description</th>
          <th scope="col">Book Image</th>
          <th scope="col">Book Remove</th>
          <!-- <th scope="col">Book Update</th>-->
        </tr>
      </thead>
    	
		<tbody>
      <c:forEach items="${list}" var="book">
        <tr>
         <!--  <th scope="row"></th>--> 
          <td>${book.id}</td>
				<td>${book.bookname}</td>
				<td>${book.bookprice}</td>
				<td>${book.bookdescription}</td>
				<td><img src="uploadfile/${book.filename}" width="100" height="100"></td>
						<td><a href="admin?opt=4&id=${book.id}">remove</a> </td>
			<!--  	<td><a href="bookupdate?id=${book.id}">update</a> </td>-->
		</tr>
		</c:forEach>
		</tbody>
  		</table>
	</c:when>
	<c:otherwise>
		<h1>No Items.</h1>
	</c:otherwise>

</c:choose>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>