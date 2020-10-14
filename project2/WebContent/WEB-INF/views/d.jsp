<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/6.0.0/normalize.min.css">
    
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="css/d.css" />
<head>
<body>
<c:choose>
	<c:when test="${fn:length(list) gt 0 }">
  <div class="container">
        
        <div class="row">
        <c:forEach items="${list}" var="book">
            <div class="col-md-3 col-sm-6">
             
                <div class="product-grid">
                    <div class="product-image">
                    
                        <a href="#">
                            <img class="pic-1" src="uploadfile/${book.filename}">
                           
                        </a>
                        
                        <span class="product-new-label">Sale</span>
                        <span class="product-discount-label">20%</span>
                    </div>
                    
                    <div class="product-content">
                        <h3 class="title">${book.bookname}</h3>
                        <h3 class="title">${book.bookdescription}</h3>
                        <div class="price">$ ${book.bookprice}
                            <span></span>
                        </div>
                        
                        <!--   <a class="add-to-cart" href="client?opt=5&id=${book.id}&bookname=${book.bookname}&bookdescription=${book.bookdescription}&bookprice=${book.bookprice}&filename=${book.filename}">+ Add To Cart</a>
  -->                      
                        <!--   <a class="add-to-cart" href="${pageContext.request.contextPath }/Cart?id=${book.id}">+ Add To Cart</a>
                     -->
                     
                      <a class="add-to-cart" href="client?opt=5&id=${book.id}">+ Add To Cart</a>
                       
                     </div>
                   
                </div>
                
            </div>
   </c:forEach>
   
        </div>
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