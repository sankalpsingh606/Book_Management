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
    <link rel="stylesheet" href="recode.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="css/recode.css" />
<head>
<body>

    <div class="wrap">
        <div class="menu">
            <div class="mini-menu">
                <ul>
            <li class="sub">
                <a href="#">WOMAN</a>
                <ul>
                   <li><a href="#">Jackets</a></li>
                   <li><a href="#">Blazers</a></li>
                   <li><a href="#">Suits</a></li>
                   <li><a href="#">Trousers</a></li>
                   <li><a href="#">Jenas</a></li>
                   <li><a href="#">Shirts</a></li> 
                </ul>
            </li>
            <li class="sub">
                <a href="#">MAN</a>
                <ul>
                   <li><a href="#">Jackets</a></li>
                   <li><a href="#">Blazers</a></li>
                   <li><a href="#">Suits</a></li>
                   <li><a href="#">Trousers</a></li>
                   <li><a href="#">Jenas</a></li>
                   <li><a href="#">Shirts</a></li> 
                </ul>
            </li>
            <li class="sub">
                <a href="#">KIDS</a>
                <ul>
                    <li><a href="#">Jackets</a></li>
                   <li><a href="#">Blazers</a></li>
                   <li><a href="#">Suits</a></li>
                   <li><a href="#">Trousers</a></li>
                   <li><a href="#">Jenas</a></li>
                   <li><a href="#">Shirts</a></li> 
                </ul>
            </li>
            <li class="sub">
                <a href="#">Shoes&Bags</a>
                <ul>
                <li><a href="#">Jackets</a></li>
                   <li><a href="#">Blazers</a></li>
                   <li><a href="#">Suits</a></li>
                   <li><a href="#">Trousers</a></li>
                   <li><a href="#">Jenas</a></li>
                   <li><a href="#">Shirts</a></li> 
                </ul>
            </li>
        </ul>
            </div>
            <div class="menu-colors menu-item">
                <div class="header-item" >Colors</div>
                <ul class="color-row1">
                    <li class="color-circle" style="background:#4286f4"></li>
                    <li class="color-circle" style="background:#2acc4b"></li>
                    <li class="color-circle" style="background:#343534"></li>
                    <li class="color-circle" style="background:#5f605f"></li>
                    <li class="color-circle" style="background:#929392"></li>
                </ul>
                <ul class="color-row2">
                    <li class="color-circle" style="background:#9e8045"></li>
                    <li class="color-circle" style="background:#d3d3d3"></li>
                    <li class="color-circle" style="background:#6b6666"></li>
                    <li class="color-circle" style="background:#999797"></li>
                    <li class="color-circle" style="background:#923476"></li>
                </ul>
            </div>
            <div class="menu-size menu-item">
                <div class="header-item" >Size</div>
                <ul class="color-row1">
                    <li class="color-circle size-circle" ><p class="sizedouble">XS</p></li>
                    <li class="color-circle size-circle" style="background-color:#343534" ><p style="color:#999" class="size">S</p></li>
                    <li class="color-circle size-circle" ><p class="size">M</p></li>
                    <li class="color-circle size-circle" ><p class="size">L</p></li>
                    <li class="color-circle size-circle" ><p class="sizedouble">XL</p></li>
                </ul>
            </div>
            <div class="menu-price menu-item">
                <div class="header-item" >Price</div>
                <p>
                    <!--<label for="amount">Price range:</label>-->
                    <input type="text" readonly id="amount"  style="border:0; color:#f6931f; font-weight:bold;">
                </p>
                <div id="slider-range"></div>
            </div>
            
        </div>

<c:choose>
	<c:when test="${fn:length(list) gt 0 }">
    
        <div class="items">
        
            <div class="items">
             <c:forEach items="${list}" var="book">
                  <div data-price="290" class="item">
                      <img src="uploadfile/${book.filename}" alt="jacket" class="img-item"></img>
                          <div class="info">
                              <h3>Book:${book.bookname}</h3>
                              <p class="descroption">Book Description:${book.bookdescription}</p>
                              <h5>Price:${book.bookprice}</h5>
                          </div>
                      </div>
                      </c:forEach>
                      <button class="loadmore">Load More</button>
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