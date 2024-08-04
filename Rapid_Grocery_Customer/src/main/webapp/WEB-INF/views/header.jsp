<%@page import="com.rapid.bean.LoggerInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<% 

// clear catch_ of browser
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
response.setHeader ("Clear-Site-Data", "cache");


LoggerInfo loggerInfo = (LoggerInfo)session.getAttribute("LoggerInfo");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Rapid Grocery</title>
    
<!--     no caching -->
    <meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    
    
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <!-- Favicon -->
    <link href="assets/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- Libraries Stylesheet -->
    <link href="assets/lib/animate/animate.min.css" rel="stylesheet">
    <link href="assets/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <!-- <div class="row bg-secondary py-1 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center h-100">
                    <a class="text-body mr-3" href="">About</a>
                    <a class="text-body mr-3" href="">Contact</a>
                    <a class="text-body mr-3" href="">Help</a>
                    <a class="text-body mr-3" href="">FAQs</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">My Account</button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <button class="dropdown-item" type="button">Sign in</button>
                            <button class="dropdown-item" type="button">Sign up</button>
                        </div>
                    </div>
                    <div class="btn-group mx-2">
                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">USD</button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <button class="dropdown-item" type="button">EUR</button>
                            <button class="dropdown-item" type="button">GBP</button>
                            <button class="dropdown-item" type="button">CAD</button>
                        </div>
                    </div>
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">EN</button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <button class="dropdown-item" type="button">FR</button>
                            <button class="dropdown-item" type="button">AR</button>
                            <button class="dropdown-item" type="button">RU</button>
                        </div>
                    </div>
                </div>
                <div class="d-inline-flex align-items-center d-block d-lg-none">
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-heart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                    <a href="" class="btn px-0 ml-2">
                        <i class="fas fa-shopping-cart text-dark"></i>
                        <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                    </a>
                </div>
            </div>
        </div> -->
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
            <div class="col-lg-4">
                <a href="/Rapid_Grocery_Customer" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">Rapid</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Grocery</span>
                </a>
            </div>
            <div class="col-lg-4 col-6 text-left">
               
                
<%--                  <form:form action="searchs" method="POST" modelAttribute="SubProduct">                 --%>
<!-- 	                <div class="input-group"> -->
	                  
	                  	
<%-- 					 	<form:input path="subproductName" type="text" class="form-control" placeholder="Search for products" /> --%>
					 	
<!-- 	                <input type="submit" class="main-btn primary-btn rounded-md btn-hover" value="Search"> -->
	                 
<!--                     </div> -->
<%--                 </form:form> --%>
            </div>
            <div class="col-lg-4 col-6 text-right">
                <p class="m-0">Customer Service</p>
                <h5 class="m-0">+919327087210</h5>
            </div>
        </div>
    </div>
    <!-- Topbar End -->

 <!-- Navbar Start -->
    <div class="container-fluid bg-dark mb-30">
        <div class="row px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                    <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown dropright">
                            
							<c:if test="${!empty categorys}">
								<c:forEach items="${categorys}" var="category">
								
									<a href="${category.categoryId}" id="comboCategory" class="nav-link dropdown-toggle comboCategory"
										data-toggle="dropdown">${category.categoryName}<i
										class="fa fa-angle-right float-right mt-1"></i></a>
									<div
										class="dropdown-menu position-absolute rounded-0 border-0 m-0 comboProduct">
                                           
<!-- 									<a href="" class="dropdown-item">Men's Dresses</a>  -->

									</div>
								</c:forEach>
							</c:if>
						</div>


					</div>
				</nav>
			</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<script>
$(document).ready(function(){
	console.log("Perfectly click");
 	$('.comboCategory').click(function(){
 		
 		var category = $(this).attr('href');
 		console.log("Perfectly click2");
        $.ajax({
        	type: 'GET',
        	url: '${pageContext.request.contextPath}/showProducts/'+category,
        	success: function(result){
        		var result = JSON.parse(result);
        		console.log(result);
        		var s= '';
        		for(var i=0;i < result.length;i++){
        			
        			s +='<a href="search?productId='+result[i][0]+'" class="dropdown-item">'+result[i][1]+'</a> ';
        		console.log(s);
        		}
        		$('.comboProduct').html(s);
        	}
        	
        	/*'+result[i][0]+'  */
        });
		
        
 	});
	
 	
	
});

</script>
      
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <span class="h1 text-uppercase text-dark bg-light px-2">Rapid</span>
                        <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Grocery</span>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="/Rapid_Grocery_Customer" class="nav-item nav-link active">Home</a>
                            <a href="about" class="nav-item nav-link">About Us</a>
                            <a href="contact" class="nav-item nav-link">Contact</a>
                            <a href="checkout" class="nav-item nav-link">Checkout</a>
                              <a href="search" class="nav-item nav-link"><i class="fa fa-search"></i> </a>
                        
                            <div class="nav-item dropdown">
                                                        
<!--  if user is logged in -->

						<c:if test="${not empty LoggerInfo}">
							<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Welcome, <%= loggerInfo.getUserName() %> <i class="fa fa-angle-down mt-1"></i></a>
                                <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                    <a href="profile" class="dropdown-item">Profile</a>
                                    <a href="logout" class="dropdown-item">Logout</a>
                                </div>
						</c:if>

						<c:if test="${empty LoggerInfo}">
							<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">MY Account <i class="fa fa-angle-down mt-1"></i></a>
                                <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                    <a href="login" class="dropdown-item">Sign In</a>
                                    <a href="register" class="dropdown-item">Sign Up</a>
                                </div>
						</c:if>
                                
                            </div>
                        </div>
                        <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                            <a href="cart" class="btn px-0 ml-3">
                                <i class="fas fa-shopping-cart text-primary"></i>
                                <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->