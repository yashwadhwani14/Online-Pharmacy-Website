<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
   prefix = "c" %>	
<!doctype html>
<html lang="en">
   <head>
      <!-- Favicons -->
      <link rel="icon" type="image/png" href="Homepage/assets/img/favicon.png">
      <title>Admin Registration</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="Homepage/AdminLoginRegister/css/style.css">
      <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.29.2/sweetalert2.all.min.js"></script>    
      <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   </head>
   <style>
      body {
      padding-top:50px;
      }
      fieldset {
      border: thin solid #ccc; 
      border-radius: 4px;
      padding: 20px;
      padding-left: 40px;
      background: #fbfbfb;
      }
      legend {
      color: #678;
      }
      .form-control {
      width: 95%;
      }
      label small {
      color: #678 !important;
      }
      span.req {
      color:maroon;
      font-size: 112%;
      }
      legend {	
      margin-top:200px;
      }
   </style>
   <style>
      #btnsub{
      background-color:#1997cc;
      }		
   </style>
   <script type="text/javascript">
      function email_validate(email){
      	var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;
      
          if(regMail.test(email) == false){
          	document.getElementById("status").innerHTML = "<span class='warning'>Email address is not valid yet.</span>";
          }
          else{
          	document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";	
          }
      }
   </script>
   <body class="img js-fullheight" style="background-image: url(Homepage/assets/img/pharmaimg.jpg);">
      <section class="ftco-section">
         <div class="container">
            <c:if test="${param.msg == 'adminRegFail'}">
               <c:set var="message" value="Registration Failed !!!"/>
            </c:if>
            <c:if test="${not empty message}">
               <script>
                  if ("${message}" !== "") {
                     	swal({
                     	    title: 'Message From Server',
                             text: '${message.trim()}',
                             icon: 'error'
                      });
                  }
               </script>
            </c:if>
            <div class="row justify-content-center">
               <div class="col-md-6 text-center mb-5">
                  <h3 class="heading-section">ADMIN  REGISTRATION</h3>
               </div>
            </div>
            <div class="row justify-content-center">
               <div class="col-md-6 col-lg-4">
                  <div class="login-wrap p-0">
                     <form action="registerAdmin"class="form" name="regform" id="regform">
                        <div class="form-group">
                           <input type="text" class="form-control" placeholder="Enter AdminID"  
                              maxlength="30" id="Userid" name="userid"  onchange="email_validate(this.value);" 
                              required>
                        </div>
                        <div class="form-group">
                           <input  type="password" class="form-control" placeholder="Enter Password" 
                              maxlength=16 id="password" name="userpassword" required>
                           <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group">
                           <button id="btnsub" type="submit" class="form-control btn submit px-3">REGISTER</button>
                        </div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <script src="Homepage/AdminLoginRegister/js/jquery.min.js"></script>
      <script src="Homepage/AdminLoginRegister/js/popper.js"></script>
      <script src="Homepage/AdminLoginRegister/js/bootstrap.min.js"></script>
      <script src="Homepage/AdminLoginRegister/js/main.js"></script>
   </body>
</html>