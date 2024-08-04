 <%@include file="sidebar.jsp" %>
<%@include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- ========== section start ========== -->
      <section class="section">
        <div class="container-fluid">
          <!-- ========== title-wrapper start ========== -->
          <div class="title-wrapper pt-30">
            <div class="row align-items-center">
              <div class="col-md-6">
                <div class="title mb-30">
                  <h2>eCommerce Dashboard</h2>
                </div>
              </div>
              <!-- end col -->
              <div class="col-md-6">
                <div class="breadcrumb-wrapper mb-30">
                  <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                      <li class="breadcrumb-item">
                        <a href="#0">Dashboard</a>
                      </li>
                      <li class="breadcrumb-item active" aria-current="page">
                        eCommerce
                      </li>
                    </ol>
                  </nav>
                </div>
              </div>
              <!-- end col -->
            </div>
            <!-- end row -->
          </div>
          <!-- ========== title-wrapper end ========== -->
          <div class="row">
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon purple">
                  <i class="lni lni-user"></i>
<!--                   lni lni-cart-full  -->
                </div>
                <div class="content">
                  <h6 class="mb-10">Total Users</h6>
                  <h3 class="text-bold mb-10">${usercounts}</h3>
                  
                </div>
              </div>
             
              
              
              
              
              
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon success">
                  <i class="lni lni-users"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Total Employee</h6>
                  <h3 class="text-bold mb-10">${empcounts}</h3>
                  
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon primary">
                  <i class="lni lni-list"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Today' Orders</h6>
                  <h3 class="text-bold mb-10">${ordercounts}</h3>
                  
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon orange">
                  <i class="lni lni-timer"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Order Pending</h6>
                  <h3 class="text-bold mb-10">${orderpendcounts}</h3>
                 
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
          </div>
          <!-- End Row -->
        </div>
        <!-- end container -->
      </section>
      
        <section class="section">
        <div class="container-fluid">
         
          <!-- ========== title-wrapper end ========== -->
          <div class="row">
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon purple">
                  <i class="lni lni-cart-full"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Order Delivered</h6>
                  <h3 class="text-bold mb-10">${ordercomcounts}</h3>
                  
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon success">
                  <i class="lni lni-check-box"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Total Sub Products</h6>
                  <h3 class="text-bold mb-10">${subproductscounts}</h3>
                  
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon primary">
                  <i class="lni lni-check-box"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Total Products</h6>
                  <h3 class="text-bold mb-10">${productscounts}</h3>
                 
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
            <div class="col-xl-3 col-lg-4 col-sm-6">
              <div class="icon-card mb-30">
                <div class="icon orange">
                  <i class="lni lni-write"></i>
                </div>
                <div class="content">
                  <h6 class="mb-10">Today's Feedbacks</h6>
                  <h3 class="text-bold mb-10">${feedbackcounts}</h3>
                  
                </div>
              </div>
              <!-- End Icon Cart -->
            </div>
            <!-- End Col -->
          </div>
          <!-- End Row -->
        </div>
        <!-- end container -->
      </section>
      <!-- ========== section end ========== -->
<%@include file="footer.jsp" %>
      