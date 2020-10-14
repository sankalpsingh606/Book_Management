<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

 <style>
      p{
	color: white;
	font:  Arial, Helvetica, sans-serif;
	margin: 0;
	padding-right: 10px;
	text-align: right;	
}

</style>
<title>Home Page</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><img src="image/logo.jpg"width="30" height="30" class="d-inline-block align-top" alt=""></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Login</a>
    <div class="dropdown-menu">
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="adminlogin.jsp">Login Admin</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="clientlogin.jsp">Login Client</a>
    </div>
    </li>
 		<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Register</a>
    <div class="dropdown-menu">
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="adminregister.jsp">Register Admin</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="clientregister.jsp">Register Client</a>
    </div>
    </li>				
			</ul>
	   </div>
    </nav>
    <!-- Image Slider -->

        
        <div id="myCarousel" class="carousel slide">
        
        <!-- Indicators -->
        <ul class="carousel-indicators">
          <li class="item1 active"></li>
          <li class="item2"></li>
          <li class="item3"></li>
          <li class="item4"></li>
          <li class="item5"></li>
          <li class="item6"></li>
        </ul>
        
        <!-- The slideshow -->
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="image/background 1.jpg"  class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="image/background 2.jpg"  class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="image/background 3.jpg"  class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="image/background 4.jpg"  class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="image/background 5.jpg"  class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="image/background 6.jpg"  class="d-block w-100" alt="...">
          </div>
        </div>
        
        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#myCarousel">
          <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel">
          <span class="carousel-control-next-icon"></span>
        </a>
      </div>
      
      
      

<div class="card-footer bg-dark border-success">

<!--<article class="bg-dark mb-3">--> 
  
      <p >
        © Copyright 2020 Sankalp Singh. All Rights Reserved.
      </p>
    
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="js/slider.js"></script>    
</body>
</html>