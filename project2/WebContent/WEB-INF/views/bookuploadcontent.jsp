<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous"></head>
   <link rel="stylesheet" href="/css/addproduct.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
     
</head>
<body>
<div class="container product">
    <div class="row">
        <div class="col-md-3 product-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Welcome</h3>
            
        </div>
        <div class="col-md-9 product-right">
                    <h3 class="register-heading">Book Upload</h3>
                    <div class="row product-form">
                        <div class="col-md-9">
                            <form action="admin?opt=3" method="post" enctype="multipart/form-data">
                    

                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"> <i class="fa fa-book" aria-hidden="true"></i> </span>
                                     </div>
                                    <input name="bookname" id="bookname" class="form-control" placeholder="Book name" type="text">
                                </div> <!-- form-group// -->
                                        
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class='fas fa-dollar-sign'></i>  </span>
                                    </div>
                                    <input name="bookprice" id="bookprice" class="form-control" placeholder="Book Price " type="text">
                                </div> <!-- form-group// -->    
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"> <i class="fa fa-book" aria-hidden="true"></i> </span>
                                     </div>
                                     <textarea  class="form-control" name="bookdescription" id="bookdescription" placeholder="Description of Book" rows=5 cols=30 maxlength=100></textarea>
                                    </div> 
                                 <!-- form-group// -->
                                  <div class="form-group input-group">
                                <div class="input-group-prepend">
                                <span class="input-group-text">upload
                                    </span>
                                  </div>
                                  <div class="custom-file">
                                  <input type="file" class="custom-file-input" id="filename" name="filename">
                                  <label class="custom-file-label" for="customFile">Choose file</label>
                                  </div>
                                  </div> 
                                  <!-- form-group// -->                     
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block" value="bookupload" id="btn"> Book Upload  </button>
                                </div> <!-- form-group// -->      
                                                                                                 
                            </form>
                            



                         </div>
                </div>
        </div>


<script>
// Add the following code if you want the name of the file appear on select
$(".custom-file-input").on("change", function() {
  var fileName = $(this).val().split("\\").pop();
  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});
</script>
</body>
</html>