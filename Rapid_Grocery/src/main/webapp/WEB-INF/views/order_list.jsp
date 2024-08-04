 <%@include file="sidebar.jsp"%>
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="table-components">
	<div class="container-fluid">
		<!-- ========== title-wrapper start ========== -->
		<div class="title-wrapper pt-30">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="title mb-30">
						<h2>Manage Order</h2>
					</div>
				</div>
				<!-- end col -->
				<div class="col-md-6">
					<div class="breadcrumb-wrapper mb-30">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#0">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									Order Listing</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<!-- ========== title-wrapper end ========== -->

		<!-- ========== tables-wrapper start ========== -->
		<div class="tables-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="card-style mb-30">
						<h6 class="mb-10">Order Listing</h6>
						<div class="table-wrapper table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th><h6>Order ID</h6></th>
										<th><h6>User ID</h6></th>
										<th><h6>Name</h6></th>
										<th><h6>Cart ID</h6></th>
										<th><h6>Billing Address</h6></th>
										<th><h6>Shipping Address</h6></th>
										<th><h6>Order Date</h6></th>
										<th><h6>Total Amount</h6></th>
										<th><h6>Order Status</h6></th>
										<th><h6>Cancel Order</h6></th>

									</tr>
									<!-- end table row-->
								</thead>

								<c:if test="${!empty orders}">
									<c:forEach items="${orders}" var="order">
										<tbody>
											<tr>
												<td class="min-width"><c:out value="${order.orderId}" /></td>
												<td class="min-width"><c:out
														value="${order.userMasterId}" /></td>
												<td class="min-width"><c:out
														value="${order.userMasterFirstName }" /> <c:out
														value="${order.userMasterLastName}" /></td>
												<td class="min-width"><c:out value="${order.cartId}" /></td>
												<td class="min-width"><c:out
														value="${order.billingAddress}" /></td>
												<td class="min-width"><c:out
														value="${order.shippingAddress}" /></td>
												<td class="min-width"><c:out
														value="${order.orderDate}" /></td>
												<td class="min-width"><c:out
														value="${order.totalAmount}" /></td>
												<td class="min-width"><c:if
														test="${(order.orderStatusName == 'Complete')||(order.orderStatusName == 'Order Cancel') }">

														<a class="btn btn-order btn-danger rounded-pill disabled"
															href="/editOrderStatus?orderId=${order.orderId}">${order.orderStatusName}</a>


													</c:if> <c:if
														test="${!((order.orderStatusName == 'Complete')||(order.orderStatusName == 'Order Cancel'))}">
														<a class="btn btn-order btn-success rounded-pill"
															href="/editOrderStatus?orderId=${order.orderId}">${order.orderStatusName}</a>
													</c:if></td>

												<td class="min-width"><c:if
														test="${!((order.orderStatusName == 'Complete')||(order.orderStatusName == 'Order Cancel'))}">

														<a class="btn btn-cancel btn-danger rounded-pill"
															href="/cancelOrderStatus?orderId=${order.orderId}">Cancel
															Order</a>
													</c:if></td>






												<%-- <td>
													<div class="action">
														<a href="editUser?userMasterId=${user.userMasterId}"
															class="text-important"> <svg
																xmlns="http://www.w3.org/2000/svg" width="16"
																height="16" fill="currentColor"
																class="bi bi-pencil-fill" viewBox="0 0 16 16">
												  <path
																	d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
												</svg>
														</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a
															href="deleteUser?userMasterId=${user.userMasterId}"
															class="text-danger"><i class="lni lni-trash-can"></i></a>
													</div>
												</td> --%>
											</tr>
										</tbody>
									</c:forEach>
								</c:if>
							</table>
							<!-- end table -->
						</div>
					</div>
					<!-- end card -->
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- ========== tables-wrapper end ========== -->
	</div>
	<!-- end container -->


	<script src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>
	<script>
		// 		$(document).ready(

		// 					$('.btn-order').prop("disabled", true).text('Complete')
		// 										.removeClass('btn-success').addClass(
		// 												'btn-danger');

		// 				);

		let classname = document.getElementsByClassName("btn-order");
		console.log(classname);
	</script>
</section>


<%@include file="footer.jsp"%>