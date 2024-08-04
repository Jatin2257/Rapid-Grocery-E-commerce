<%@include file="header.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="#">Profile</a> <a
					class="breadcrumb-item text-dark" href="#">My Orders</a>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

		<div class="tables-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="card-style mb-30">
						<h6 class="mb-10">My Orders</h6>
						<div class="table-wrapper table-responsive">
							<table class="table">
								<thead>
									<tr>
<!-- 										<th><h6>Order ID</h6></th> -->
<!-- 										<th><h6>User ID</h6></th> -->
										<th><h6>Name</h6></th>
										<th><h6>Billing Address</h6></th>
										<th><h6>Shipping Address</h6></th>
										<th><h6>Order Date</h6></th>
										<th><h6>Total Amount</h6></th>
										<th><h6>Order Status</h6></th>
<!-- 										<th><h6>Cancel Order</h6></th> -->

									</tr>
									<!-- end table row-->
								</thead>

								<c:if test="${!empty myorders}">
									<c:forEach items="${myorders}" var="order">
										<tbody>
											<tr>
<%-- 												<td class="min-width"><c:out value="${order.orderId}" /></td> --%>
<%-- 												<td class="min-width"><c:out --%>
<%-- 														value="${order.userMasterId}" /></td> --%>
												<td class="min-width"><c:out
														value="${order.userMasterFirstName }" /> <c:out
														value="${order.userMasterLastName}" /></td>												
												<td class="min-width"><c:out
														value="${order.billingAddress}" /></td>
												<td class="min-width"><c:out
														value="${order.shippingAddress}" /></td>
												<td class="min-width"><c:out
														value="${order.orderDate}" /></td>
												<td class="min-width"><c:out
														value="${order.totalAmount}" /></td>
														
														
												<td class="min-width">
												
												<c:if test="${order.orderStatusName == 'Complete'}">
												<span class="status-btn success-btn">${order.orderStatusName} </span>
												
												</c:if>
												<c:if test="${(order.orderStatusName == 'Order Placed') || (order.orderStatusName == 'Order Confirmed')}">
												<span class="status-btn info-btn">${order.orderStatusName} </span>
												
												</c:if>
												
																		<c:if test="${(order.orderStatusName == 'Ready for Dispatched') || (order.orderStatusName == 'Order Shipped')}">
												<span class="status-btn active-btn">${order.orderStatusName} </span>
												
												</c:if>
																		<c:if test="${(order.orderStatusName == 'Out for Delivery') || (order.orderStatusName == 'Order Cancel')}">
												<span class="status-btn close-btn">${order.orderStatusName} </span>
												
												</c:if>
												
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</c:if>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

<%@include file="footer.jsp"%>