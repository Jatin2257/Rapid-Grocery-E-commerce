<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:if test="${empty LoggerInfo}"> --%>
<%-- 	<c:redirect url="login.jsp"/> --%>
<%-- </c:if> --%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="/">Home</a> <a
					class="breadcrumb-item text-dark" href="shop">Shop</a> <span
					class="breadcrumb-item active">Shopping Cart</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Cart Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-lg-8 table-responsive mb-5">
			<table
				class="table table-light table-borderless table-hover text-center mb-0">
				<thead class="thead-dark">
					<tr>
						<th>Products</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody class="align-middle">

					<!-- here loop will start -->
					<c:if test="${!empty cartsubproducts}">
						<c:forEach items="${cartsubproducts}" var="cartsubproduct">
							<tr>
								<td class="align-middle">
<%-- 									<img class="img-fluid w-100" src="data:image/jpeg;base64,${cartsubproduct.subproductImage}" alt="img"> --%>
									${cartsubproduct.subproductName}</td>
								<td class="align-middle"><svg
										xmlns="http://www.w3.org/2000/svg" width="20" height="20"
										fill="currentColor" class="bi bi-currency-rupee"
										viewBox="0 0 16 16">
								  <path
											d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${cartsubproduct.subproductPrice}</td>
								<td class="align-middle">
									<div class="input-group quantity mx-auto" style="width: 100px;">


<!--counter -->




				<div class="input-group-btn">
					<a href="updateQuantityMinus?cartId=${cartsubproduct.cartId}">
					<button id="btnMinus" type="button"
						class="btn btn-sm btn-primary btn-minus" class="decrement"
						>
						<i class="fa fa-minus"></i>
					</button>
					</a>
				</div>
		<input type="hidden" name="cartsubProductId" id="cId" value="${cartsubproduct.cartId}" />


<input type="text" class="form-control form-control-sm bg-secondary border-0 text-center" id="qty"
       value="${cartsubproduct.quantity}" readonly="true" />

<c:set var="buttonDisabled" value="${cartsubproduct.quantity ge cartsubproduct.subproductQuantity}" />
<div class="input-group-btn">
    <c:if test="${not buttonDisabled}">
        <a href="updateQuantityPlus?cartId=${cartsubproduct.cartId}">
            <button id="btnPlus" type="button" class="btn btn-sm btn-primary btn-plus increment">
                <i class="fa fa-plus"></i>
            </button>
        </a>
    </c:if>
    <c:if test="${buttonDisabled}">
        <button id="btnPlus" type="button" class="btn btn-sm btn-primary btn-plus increment" disabled>
            <i class="fa fa-plus"></i>
        </button>
    </c:if>

	
					</div>


									</div>
								</td>
								<td class="align-middle"><svg
										xmlns="http://www.w3.org/2000/svg" width="20" height="20"
										fill="currentColor" class="bi bi-currency-rupee"
										viewBox="0 0 16 16">
								  <path
											d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${cartsubproduct.totalAmount} <!-- calculating the total of all itms -->
									<c:set var="total"
										value="${total + cartsubproduct.totalAmount}" /></td>
								<td class="align-middle"><a
									href="removeCartItem?cartId=${cartsubproduct.cartId}">
										<button class="btn btn-sm btn-danger">
											<i class="fa fa-times"></i>
										</button>
								</a></td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>
		</div>
		<div class="col-lg-4">
			<form class="mb-30" action="">
				<div class="input-group">
					<input type="text" class="form-control border-0 p-4"
						placeholder="Coupon Code">
					<div class="input-group-append">
						<button class="btn btn-primary">Apply Coupon</button>
					</div>
				</div>
			</form>
			<h5 class="section-title position-relative text-uppercase mb-3">
				<span class="bg-secondary pr-3">Cart Summary</span>
			</h5>
			<div class="bg-light p-30 mb-5">
				<div class="border-bottom pb-2">
					<div class="d-flex justify-content-between mb-3">
						<h6>Subtotal</h6>
						<h6>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
								fill="currentColor" class="bi bi-currency-rupee"
								viewBox="0 0 16 16">
								  <path
									d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${total}</h6>
					</div>
					<div class="d-flex justify-content-between">
						<h6 class="font-weight-medium">Shipping</h6>
						<h6 class="font-weight-medium">
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
								fill="currentColor" class="bi bi-currency-rupee"
								viewBox="0 0 16 16">
								  <path
									d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>
							0
						</h6>
					</div>
				</div>
				<div class="pt-2">
					<div class="d-flex justify-content-between mt-2">
						<h5>Total</h5>
						<h5>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
								fill="currentColor" class="bi bi-currency-rupee"
								viewBox="0 0 16 16">
								  <path
									d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${total}</h5>
<%-- 								<input type="text" name="total" value="${cartsubproduct.cartId}">  --%>
					</div><a href="proceedToCheckout?cartId=${cartsubproduct.cartId}">
					<button
						class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed
						To Checkout</button></a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Cart End -->



<%@include file="footer.jsp"%>

<!-- <script>
	let counter = 0;
	function get() {
	  return counter;
	}
	const inc = document.getElementsByClassName("increment");
	const input = document.getElementById("qty");
	const dec = document.getElementsByClassName("decrement");
	
	inc.addEventListener("click", () => {
		counter++;
	  	input.value = get();
	});
	
	dec.addEventListener("click", () => {
	  if (input.value > 0) {
		  counter--;
	  }
	  input.value = get();
	});
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

<script type="text/javascript">

function updateQuantity(id){
	console.log(id);
	$.ajax({
		url: '/updateQuantity?cartId='+id,
		method: 'GET',
		dataType: 'json',
		
		success: function(data){
			console.log(data);
			$('#qty').val(data.quantity);
			$('#cId').val(data.cartId);			
		},
		error: function(error){
			console.log(error);
			alert(error); 
		}
	})
}
</script> -->







