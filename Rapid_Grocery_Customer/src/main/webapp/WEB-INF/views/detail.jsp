<%@include file="header.jsp"%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="/">Home</a> <a
					class="breadcrumb-item text-dark" href="">Product</a> <span
					class="breadcrumb-item active">Product Detail</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Detail Start -->
<div class="container-fluid pb-5">
	<div class="row px-xl-5">
		<div class="col-lg-5 mb-30">
			<div id="product-carousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner bg-light">
					<div class="carousel-item active">
						<img class="w-100 h-100"
							src="data:image/jpeg;base64,${subproduct.subproductImage}"
							alt="Image">
					</div>
				</div>
			</div>
		</div>

		<div class="col-lg-7 h-auto mb-30">
			<div class="h-100 bg-light p-30">
				<h3>${subproduct.subproductName}</h3>
				<div class="d-flex mt-2">
					<h3 class="font-weight-semi-bold mb-4">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-currency-rupee"
							viewBox="0 0 16 16">
								  <path
								d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${subproduct.subproductPrice}</h3>
					<h6 class="text-muted ml-2 mt-2">
						<del>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-currency-rupee"
								viewBox="0 0 16 16">
								  <path
									d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${subproduct.subproductPrice+subproduct.subproductPrice * 5/100}</del>
					</h6>
				</div>
				<div>

					<c:choose>
						<c:when test="${subproduct.subproductQuantity == 0}">
							<span style="color: red; font-weight: 700;">Out of Stock</span>
							<span>Total Items Left : ${subproduct.subproductQuantity}</span>
						</c:when>
						<c:when test="${subproduct.subproductQuantity > 0}">
							<span style="color: green; font-weight: 700;">In Stock</span>
							<span>Total Items Left : ${subproduct.subproductQuantity}</span>
						</c:when>
						<c:otherwise>
							<span>Total Items Left : ${subproduct.subproductQuantity}</span>
						</c:otherwise>
					</c:choose>
				</div>
				<br>
				<p class="mb-4">${subproduct.subproductDescription}</p>

				<c:choose>
					<c:when test="${subproduct.subproductQuantity == 0}">
						<div class="d-flex align-items-center mb-4 pt-2">
							<div class="input-group quantity mr-3" style="width: 130px;">
								<div class="input-group-btn">
									<button class="btn btn-primary btn-minus disabled">
										<i class="fa fa-minus"></i>
									</button>
								</div>
								<input type="text"
									class="form-control bg-secondary border-0 text-center"
									value="0" readonly>
								<div class="input-group-btn">
									<button class="btn btn-primary btn-plus disabled">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
							<button class="btn btn-primary px-3 disabled">
								<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
							</button>
						</div>
					</c:when>
					<c:when test="${subproduct.subproductQuantity > 0}">
						<form:form action="addToCart" method="post" modelAttribute="Cart">
							<div class="d-flex align-items-center mb-4 pt-2">
								<div class="input-group quantity mr-3" style="width: 130px;">
									<div class="input-group-btn">
										<button type="button" class="btn btn-primary btn-minus" id="btnMinus">
											<i class="fa fa-minus"></i>
										</button>
									</div>
									<form:input path="quantity" type="text" id="count"
										class="form-control bg-secondary border-0 text-center"
										value="1" readonly="true" /> 
									<form:hidden path="subproductId" value="${subproduct.subproductId}" />
									<div class="input-group-btn">
										<button type="button" class="btn btn-primary btn-plus" id="btnPlus">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
								<c:if test="${not empty LoggerInfo}">
									<button type="submit" class="btn btn-primary px-3">
										<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
									</button>
								</c:if>
								<c:if test="${empty LoggerInfo}">
									<button type="button" onClick="message_login();" class="btn btn-primary px-3">
										<i class="fa fa-shopping-cart mr-1"></i> Add To Cart
									</button>
								</c:if>
								
							</div>
						</form:form>
					</c:when>
					
					
					
					
				</c:choose>



				<div class="d-flex pt-2">
					<strong class="text-dark mr-2">Share on:</strong>
					<div class="d-inline-flex">
						<a class="text-dark px-2" href=""> <i
							class="fab fa-facebook-f"></i>
						</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-linkedin-in"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-pinterest"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="bg-light p-30">
				<div class="nav nav-tabs mb-4">
					<a class="nav-item nav-link text-dark active" data-toggle="tab"
						href="#tab-pane-1">Description</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Product Description</h4>
						<p>${subproduct.subproductDescription}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Shop Detail End -->

<%@include file="footer.jsp"%>

<script>
	var button = document.getElementById('btnMinus');
	var button2 = document.getElementById('btnPlus');
	var display = document.getElementById('count');
	var count = 0;
	if (display.value == 1)
		button.disabled = true;
	button.addEventListener('click', function() {
		if (display.value == 1)
			button.disabled = true;
		else {
			count--;
			display.value = count;
		}
	});
	button2.addEventListener('click', function() {
		if (display.value > 0)
			button.disabled = false;
		count++;
		display.value = count;
	});
</script>


<script>
    document.addEventListener("DOMContentLoaded", function() {
        var quantityInput = document.getElementById("count");
        var plusButton = document.getElementById("btnPlus");
        var minusButton = document.getElementById("btnMinus");

        plusButton.addEventListener("click", function() {
            var currentValue = parseInt(quantityInput.value);
            var databaseQuantity = parseInt("${subproduct.subproductQuantity}");

            if (currentValue < databaseQuantity) {
                quantityInput.value = currentValue + 1;
            }

            if (currentValue + 1 >= databaseQuantity) {
                plusButton.disabled = true;
            } else {
                plusButton.disabled = false;
            }
        });

        minusButton.addEventListener("click", function() {
            var currentValue = parseInt(quantityInput.value);
            if (currentValue > 1) {
                quantityInput.value = currentValue - 1;
            }

            if (currentValue <= "${subproduct.subproductQuantity}") {
                plusButton.disabled = false;
            }
        });
    });
</script>


<script>
	function message_login() {
		swal("Please Login First!!!");
	}
</script>
