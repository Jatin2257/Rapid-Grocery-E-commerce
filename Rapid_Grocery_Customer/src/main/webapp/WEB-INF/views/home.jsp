<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="java.util.Base64" %> --%>
<!-- Carousel Start -->
<div class="container-fluid mb-3">
	<div class="row px-xl-5">
		<div class="col-lg-12 col-lg-offset-4">
			<div id="header-carousel"
				class="carousel slide carousel-fade mb-30 mb-lg-0"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#header-carousel" data-slide-to="0" class="active"></li>
					<li data-target="#header-carousel" data-slide-to="1"></li>
					<li data-target="#header-carousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item position-relative active"
						style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-1.jpg" style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Fresh
									Fruits & Vegetables</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">
									All Fresh Fruits and Vegetables under affordable price and of
									the best quality<br> "You ask items, We delivery it"
								</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Order Now</a>
							</div>
						</div>
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-2.jpg" style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Groceries
								</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">Now
									Grocery Stores in your hand. Order Now for Exclusive offers</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Order Now</a>
							</div>
						</div>
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-3.jpg" style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Buy
									Sweets</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">
									Order Delicious & Sugary Food Now <br> Enjoy Free Delivery
									on your First Order
								</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Order Now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Carousel End -->

<!-- Categories Start -->
<!-- <div class="container-fluid pt-5">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Categories</span>
	</h2>
	<div class="row px-xl-5 pb-3">
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-1.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-2.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-3.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-4.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-4.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-3.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-2.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-1.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-2.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-1.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-4.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
		<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<a class="text-decoration-none" href="">
				<div class="cat-item img-zoom d-flex align-items-center mb-4">
					<div class="overflow-hidden" style="width: 100px; height: 100px;">
						<img class="img-fluid" src="assets/img/cat-3.jpg" alt="">
					</div>
					<div class="flex-fill pl-3">
						<h6>Category Name</h6>
						<small class="text-body">100 Products</small>
					</div>
				</div>
			</a>
		</div>
	</div>
</div> -->
<!-- Categories End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Products</span>
	</h2>
	<div class="row px-xl-5">
		<!-- here loop will start -->
		<c:if test="${!empty subproducts}">
			<c:forEach items="${subproducts}" var="subproduct">
				<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
					<div class="product-item bg-light mb-4">
						<div class="product-img position-relative overflow-hidden">
							<img class="img-fluid w-100"
								src="data:image/jpeg;base64,${subproduct.subproductImage}"
								alt="img">

							<div class="product-action">

								<c:choose>
									<c:when test="${subproduct.subproductQuantity == 0}">
										<a class="btn btn-outline-dark btn-square"
											onClick="message();"><i class="fa fa-shopping-cart"></i></a>
									</c:when>
									<c:otherwise>
										<c:if test="${not empty LoggerInfo}">
											<a class="btn btn-outline-dark btn-square"
												href="addToCartFromProducts?subproductId=${subproduct.subproductId}"><i
												class="fa fa-shopping-cart"></i></a>
										</c:if>

										<c:if test="${empty LoggerInfo}">
											<a class="btn btn-outline-dark btn-square"
												onClick="message_login();"><i
												class="fa fa-shopping-cart"></i></a>
										</c:if>
									</c:otherwise>
								</c:choose>

								<a class="btn btn-outline-dark btn-square"
									href="viewSubProduct?subproductId=${subproduct.subproductId}"><i
									class="fa fa-search"></i></a>
							</div>
						</div>
						<div class="text-center py-4">
							<a class="h6 text-decoration-none text-truncate"
								href="viewSubProduct?subproductId=${subproduct.subproductId}">${subproduct.subproductName}</a>
							<div
								class="d-flex align-items-center justify-content-center mt-2">
								<h5>
									<svg xmlns="http://www.w3.org/2000/svg" width="19" height="19"
										fill="currentColor" class="bi bi-currency-rupee"
										viewBox="0 0 16 16">
								  <path
											d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${subproduct.subproductPrice}</h5>
								<h6 class="text-muted ml-2">
									<del>
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-currency-rupee"
											viewBox="0 0 16 16">
								  <path
												d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${subproduct.subproductPrice+subproduct.subproductPrice * 5/100}</del>
								</h6>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<!-- loop ends -->
		<!-- <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
			<div class="product-item bg-light mb-4">
				<div class="product-img position-relative overflow-hidden">
					<img class="img-fluid w-100" src="assets/img/product-2.jpg" alt="">
					<div class="product-action">
						<a class="btn btn-outline-dark btn-square" href=""><i
							class="fa fa-shopping-cart"></i></a> <a
							class="btn btn-outline-dark btn-square" href=""><i
							class="far fa-heart"></i></a> <a
							class="btn btn-outline-dark btn-square" href=""><i
							class="fa fa-sync-alt"></i></a> <a
							class="btn btn-outline-dark btn-square" href=""><i
							class="fa fa-search"></i></a>
					</div>
				</div>
				<div class="text-center py-4">
					<a class="h6 text-decoration-none text-truncate" href="">Product
						Name Goes Here</a>
					<div class="d-flex align-items-center justify-content-center mt-2">
						<h5>$123.00</h5>
						<h6 class="text-muted ml-2">
							<del>$123.00</del>
						</h6>
					</div>
					<div class="d-flex align-items-center justify-content-center mb-1">
						<small class="fa fa-star text-primary mr-1"></small> <small
							class="fa fa-star text-primary mr-1"></small> <small
							class="fa fa-star text-primary mr-1"></small> <small
							class="fa fa-star text-primary mr-1"></small> <small
							class="fa fa-star-half-alt text-primary mr-1"></small> <small>(99)</small>
					</div>
				</div>
			</div>
		</div>		 -->
	</div>
</div>
<!-- Products End -->


<%@include file="footer.jsp"%>
<script>
	function message() {
		swal("This Product Is Currently Out of Stock!");
	}
	function message_login() {
		swal("Please Login First!!!");
	}
</script>