<%@page import="com.Rapid.bean.LoggerInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false"%>
<% 

// clear catch_ of browser
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
response.setHeader ("Clear-Site-Data", "cache");

LoggerInfo loggerInfo = (LoggerInfo)session.getAttribute("LoggerInfo");
Integer userTypeId = loggerInfo.getUserTId();
%>

<!DOCTYPE html>
<html lang="en"> 
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="shortcut icon"
      href="assets/images/favicon.svg"
      type="image/x-icon"
    />
    <title>Rapid Grocery</title>

    <!-- ========== All CSS files linkup ========= -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/lineicons.css" />
    <link rel="stylesheet" href="assets/css/materialdesignicons.min.css" />
    <link rel="stylesheet" href="assets/css/fullcalendar.css" />
    <link rel="stylesheet" href="assets/css/fullcalendar.css" />
    <link rel="stylesheet" href="assets/css/main.css" />
    <link rel="stylesheet" href="assets/css/toggle.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.1.0/css/v4-shims.min.css" integrity="sha512-p++g4gkFY8DBqLItjIfuKJPFvTPqcg2FzOns2BNaltwoCOrXMqRIOqgWqWEvuqsj/3aVdgoEo2Y7X6SomTfUPA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>
  
    <c:set var="userTypeId1" scope="session" value="<%= userTypeId %>"/>
    
    <!-- ======== sidebar-nav start =========== -->
    <aside class="sidebar-nav-wrapper">
      <div class="navbar-logo">
        <a href="/" style="text-decoration:none">
<!--           <img src="assets/images/logo/logos.svg" alt="logo" /> -->

	<p style="font-size:24px; color:black"><b>Rapid</b>Grocery</p>
        </a>
      </div>
      <nav class="sidebar-nav">
        <ul>
          <li class="nav-item nav-item-has-children">
            <a
              href="#0"
              data-bs-toggle="collapse"
              data-bs-target="#ddmenu_1"
              aria-controls="ddmenu_1"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="icon">
                <svg width="22" height="22" viewBox="0 0 22 22">
                  <path
                    d="M17.4167 4.58333V6.41667H13.75V4.58333H17.4167ZM8.25 4.58333V10.0833H4.58333V4.58333H8.25ZM17.4167 11.9167V17.4167H13.75V11.9167H17.4167ZM8.25 15.5833V17.4167H4.58333V15.5833H8.25ZM19.25 2.75H11.9167V8.25H19.25V2.75ZM10.0833 2.75H2.75V11.9167H10.0833V2.75ZM19.25 10.0833H11.9167V19.25H19.25V10.0833ZM10.0833 13.75H2.75V19.25H10.0833V13.75Z"
                  />
                </svg>
              </span>
              <span class="text">Dashboard</span>
            </a>
            <ul id="ddmenu_1" class="collapse show dropdown-nav">
              <li>
              	<c:if test="${not empty LoggerInfo}">
                	<a href="eCommerce" class="active"> eCommerce </a>
                </c:if>
                <c:if test="${empty LoggerInfo}">
                	<a href="signin" class="active"> eCommerce </a>
                </c:if>
              </li>
            </ul>
          </li>
          

        <c:if test="${userTypeId1 eq 1 or userTypeId1 eq 2}"> 
          <li class="nav-item nav-item-has-children">
            <a
              href="#0"
              class="collapsed"
              data-bs-toggle="collapse"
              data-bs-target="#ddmenu_2"
              aria-controls="ddmenu_2"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="icon">
<i class="lni lni-list"></i>
              </span>
              <span class="text">Manage Category</span>
            </a>
            <ul id="ddmenu_2" class="collapse dropdown-nav">
              <li>
              <c:if test="${not empty LoggerInfo}">
                <a href="category"> Category </a>
                  </c:if>
               <c:if test="${empty LoggerInfo}">
                <a href="signin"> Category </a>
                </c:if>
              </li>
              
              
              <li>
              <c:if test="${not empty LoggerInfo}">
                <a href="category_list"> Category List </a>
	                </c:if>
	                <c:if test="${empty LoggerInfo}">
	                 <a href="signin"> Category List </a>
	                 </c:if>
	              </li>
	            </ul>
	          </li>
			  	  
        
	          <li class="nav-item nav-item-has-children">
	            <a
	              href="#0"
	              class="collapsed"
	              data-bs-toggle="collapse"
	              data-bs-target="#ddmenu_3"
	              aria-controls="ddmenu_3"
	              aria-expanded="false"
	              aria-label="Toggle navigation"
	            >
	              <span class="icon">
	                <!-- <svg
	                  width="22"
	                  height="22"
	                  viewBox="0 0 22 22"
	                  fill="none"
	                  xmlns="http://www.w3.org/2000/svg"
	                >
	                  <path
	                    d="M12.8334 1.83325H5.50008C5.01385 1.83325 4.54754 2.02641 4.20372 2.37022C3.8599 2.71404 3.66675 3.18036 3.66675 3.66659V18.3333C3.66675 18.8195 3.8599 19.2858 4.20372 19.6296C4.54754 19.9734 5.01385 20.1666 5.50008 20.1666H16.5001C16.9863 20.1666 17.4526 19.9734 17.7964 19.6296C18.1403 19.2858 18.3334 18.8195 18.3334 18.3333V7.33325L12.8334 1.83325ZM16.5001 18.3333H5.50008V3.66659H11.9167V8.24992H16.5001V18.3333Z"
	                  /> 
	                </svg>-->
	                <i class="lni lni-shopping-basket"></i
	                      >
	              </span>
	              <span class="text">Manage Products</span>
	            </a>
	            <ul id="ddmenu_3" class="collapse dropdown-nav">
	              <li>
	               <c:if test="${not empty LoggerInfo}">
	                <a href="product"> Products </a>
	                  </c:if>
	                <c:if test="${empty LoggerInfo}">
	                 <a href="signin"> Products </a>
	                 </c:if>
	              </li>
	              
	              
	              <li>
	              <c:if test="${not empty LoggerInfo}">
	                <a href="product_list"> Products List </a>
	                </c:if>
	                <c:if test="${empty LoggerInfo}">
	                 <a href="signin"> Products List </a>
	                 </c:if>
	              </li>
	            </ul>
	          </li>
	          
	          
	          
	          
	          <li class="nav-item nav-item-has-children">
	            <a
	              href="#0"
	              class="collapsed"
	              data-bs-toggle="collapse"
	              data-bs-target="#ddmenu_4"
	              aria-controls="ddmenu_4"
	              aria-expanded="false"
	              aria-label="Toggle navigation"
	            >
	              <span class="icon">
	              <!--   <svg
	                  width="22"
	                  height="22"
	                  viewBox="0 0 22 22"
	                  fill="none"
	                  xmlns="http://www.w3.org/2000/svg"
	                >
	                  <path
	                    d="M12.9067 14.2908L15.2808 11.9167H6.41667V10.0833H15.2808L12.9067 7.70917L14.2083 6.41667L18.7917 11L14.2083 15.5833L12.9067 14.2908ZM17.4167 2.75C17.9029 2.75 18.3692 2.94315 18.713 3.28697C19.0568 3.63079 19.25 4.0971 19.25 4.58333V8.86417L17.4167 7.03083V4.58333H4.58333V17.4167H17.4167V14.9692L19.25 13.1358V17.4167C19.25 17.9029 19.0568 18.3692 18.713 18.713C18.3692 19.0568 17.9029 19.25 17.4167 19.25H4.58333C3.56583 19.25 2.75 18.425 2.75 17.4167V4.58333C2.75 3.56583 3.56583 2.75 4.58333 2.75H17.4167Z"
	                  />
	                </svg> -->
	                <i class="lni lni-cart-full"></i>
	              </span>
	              <span class="text">Manage Sub Products</span>
	            </a>
	            <ul id="ddmenu_4" class="collapse dropdown-nav">
	              <li>
	              <c:if test="${not empty LoggerInfo}">
	                <a href="subproduct"> Sub Products </a>
	                </c:if>
	                <c:if test="${empty LoggerInfo}">
	                <a href="signin"> Sub Products </a>
	                </c:if>
	              </li>
	              <li>
	              <c:if test="${not empty LoggerInfo}">
	                <a href="subproduct_list"> Sub Products List </a>
	                </c:if>
	                <c:if test="${empty LoggerInfo}">
	                <a href="signin"> Sub Products List </a>
	                </c:if>
	                
	              </li>
	            </ul>
	          </li>

	          <li class="nav-item nav-item-has-children">
	            <a
	              href="#0"
	              class="collapsed"
	              data-bs-toggle="collapse"
	              data-bs-target="#ddmenu_5"
	              aria-controls="ddmenu_5"
	              aria-expanded="false"
	              aria-label="Toggle navigation"
	            >
	               <span class="icon">
	              <!--  <svg
	                  width="22"
	                  height="22"
	                  viewBox="0 0 22 22"
	                  fill="none"
	                  xmlns="http://www.w3.org/2000/svg"
	                >
	                  <path
	                    d="M3.66675 4.58325V16.4999H19.2501V4.58325H3.66675ZM5.50008 14.6666V6.41659H8.25008V14.6666H5.50008ZM10.0834 14.6666V11.4583H12.8334V14.6666H10.0834ZM17.4167 14.6666H14.6667V11.4583H17.4167V14.6666ZM10.0834 9.62492V6.41659H17.4167V9.62492H10.0834Z"
	                  />
	                </svg> -->
	                 <i class="lni lni-consulting"></i>
	              </span>
	              <span class="text">Manage Employees </span>
	            </a>
	            <ul id="ddmenu_5" class="collapse dropdown-nav">
	              <li>
	               <c:if test="${not empty LoggerInfo}">
	                <a href="employee"> Employee  </a>
	                </c:if>
	                 <c:if test="${empty LoggerInfo}">
	                <a href="signin"> Employee  </a>
	                </c:if>
	                
	              </li>
	              <li>
	                <c:if test="${not empty LoggerInfo}">
	                 <a href="employee_list"> Employee List </a>
	                </c:if>
	                 <c:if test="${empty LoggerInfo}">
	                <a href="signin"> Employee List  </a>
	                </c:if>
	              </li>
	              
	            </ul>
	          </li>
	          
	          </c:if> 
	          
        <c:if test="${userTypeId1 eq 1 or userTypeId1 eq 2 or userTypeId1 eq 4}">   
	           <li class="nav-item nav-item-has-children">
	            <a
	              href="#0"
	              class="collapsed"
	              data-bs-toggle="collapse"
	              data-bs-target="#ddmenu_8"
	              aria-controls="ddmenu_8"
	              aria-expanded="false"
	              aria-label="Toggle navigation"
	            >
	              <span class="icon">
	               <!--  <svg
	                  width="22"
	                  height="22"
	                  viewBox="0 0 22 22"
	                  fill="none"
	                  xmlns="http://www.w3.org/2000/svg"
	                >
	                  <path
	                    d="M3.66675 4.58325V16.4999H19.2501V4.58325H3.66675ZM5.50008 14.6666V6.41659H8.25008V14.6666H5.50008ZM10.0834 14.6666V11.4583H12.8334V14.6666H10.0834ZM17.4167 14.6666H14.6667V11.4583H17.4167V14.6666ZM10.0834 9.62492V6.41659H17.4167V9.62492H10.0834Z"
	                  />
	                </svg> -->
	                 <i class="lni lni-remove-file"></i
	                      >
	              </span>
	              <span class="text">Orders</span>
	            </a>
	            <ul id="ddmenu_8" class="collapse dropdown-nav">	              
	              <li>	              
	               <c:if test="${not empty LoggerInfo}">
	                   <a href="order_list"> View Orders </a>
	                </c:if>
	                 <c:if test="${empty LoggerInfo}">
	                <a href="signin"> View Orders </a>
	                </c:if>
	             
	              </li>
	              
	            </ul>
	          </li>
</c:if>	              

		<c:if test="${userTypeId1 eq 1 or userTypeId1 eq 2}">
	          <li class="nav-item nav-item-has-children">
	            <a
	              href="#0"
	              class="collapsed"
	              data-bs-toggle="collapse"
	              data-bs-target="#ddmenu_55"
	              aria-controls="ddmenu_55"
	              aria-expanded="false"
	              aria-label="Toggle navigation"
	            >
	              <span class="icon">
	                <!-- <svg
	                  width="22"
	                  height="22"
	                  viewBox="0 0 22 22"
	                  fill="none"
	                  xmlns="http://www.w3.org/2000/svg"
	                >
	                  <path
	                    d="M1.83325 19.25V17.4167H18.3333V19.25H1.83325ZM18.3333 7.33333V4.58333H16.4999V7.33333H18.3333ZM18.3333 2.75C18.8195 2.75 19.2858 2.94315 19.6296 3.28697C19.9734 3.63079 20.1666 4.0971 20.1666 4.58333V7.33333C20.1666 7.81956 19.9734 8.28588 19.6296 8.6297C19.2858 8.97351 18.8195 9.16667 18.3333 9.16667H16.4999V11.9167C16.4999 12.8891 16.1136 13.8218 15.426 14.5094C14.7383 15.197 13.8057 15.5833 12.8333 15.5833H7.33325C6.36079 15.5833 5.42816 15.197 4.74053 14.5094C4.05289 13.8218 3.66659 12.8891 3.66659 11.9167V2.75H18.3333ZM14.6666 4.58333H5.49992V11.9167C5.49992 12.4029 5.69307 12.8692 6.03689 13.213C6.38071 13.5568 6.84702 13.75 7.33325 13.75H12.8333C13.3195 13.75 13.7858 13.5568 14.1296 13.213C14.4734 12.8692 14.6666 12.4029 14.6666 11.9167V4.58333Z"
	                  />
	                </svg> -->
	                <i class="lni lni-users"></i>
	              </span>
	              <span class="text">Manage Users</span>
	            </a>
	            <ul id="ddmenu_55" class="collapse dropdown-nav">	              
	              <li>
	               <c:if test="${not empty LoggerInfo}">
	                 <a href="user_list"> User List </a>
	                </c:if>
	                 <c:if test="${empty LoggerInfo}">
	                <a href="signin"> User List </a>
	                </c:if>
	               
	              </li>
	            </ul>
	          </li>
	          
	          
	          
	           <li class="nav-item">
	           
	           <c:if test="${not empty LoggerInfo}">
	                 <a href="feedback_list">
	              <span class="icon"><i class="lni lni-envelope"></i> </span> <span class="text">View Feedbacks</span>
	            </a>
	                </c:if>
	                 <c:if test="${empty LoggerInfo}">
	                <a href="signin">View Feedbacks</a>
	                </c:if>
	            
	          </li>   
        </c:if>                 
        
        </ul>
      </nav>
    </aside>
    <div class="overlay"></div>
    <!-- ======== sidebar-nav end =========== -->