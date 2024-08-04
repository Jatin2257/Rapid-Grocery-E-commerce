<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div class="container pt-10">
	<div class="row justify-content-md-center">

		<div class="col-lg-6 col-8 text-left ">
			<div class="col-md-auto">


				<form:form action="searchs" method="POST"
					modelAttribute="SubProduct">
					<div class="input-group">


						<form:input path="subproductName" type="text" class="form-control"
							placeholder="Search for products" />

						<input type="submit"
							class="main-btn primary-btn rounded-md btn-hover " value="Search">

					</div>
				</form:form>
			</div>
		</div>
	</div>

</div>


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
								<%-- src="assets/Products_images_Project/${subproduct.subproductImage}" --%>
<%-- 								src="data:image/jpeg;base64,${subproduct.subproductImage}" --%>
									src="data:image/jpeg;base64,${subProductImage}"
								alt="img">

							<div class="product-action">

								<c:choose>
									<c:when test="${subproduct.subproductQuantity == 0}">
										<a class="btn btn-outline-dark btn-square"
											onClick="message();"><i class="fa fa-shopping-cart"></i></a>
									</c:when>
									<c:otherwise>
										<a class="btn btn-outline-dark btn-square" href="/"><i
											class="fa fa-shopping-cart"></i></a>
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
									<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
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

	</div>
</div>
<!-- Products End -->


<%@include file="footer.jsp"%>
<script>
	function message() {
		swal("This Product Is Currently Out of Stock!");
	}
</script>