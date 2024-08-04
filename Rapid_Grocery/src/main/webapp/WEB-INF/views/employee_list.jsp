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
						<h2>Manage Employee</h2>
					</div>
				</div>
				<!-- end col -->
				<div class="col-md-6">
					<div class="breadcrumb-wrapper mb-30">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#0">Dashboard</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									Employee Listing</li>
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
						<h6 class="mb-10">Employee Listing</h6>
						<div class="table-wrapper table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th><h6>User ID</h6></th>
										<th><h6>First Name</h6></th>
										<th><h6>Last Name</h6></th>
										<th><h6>Email</h6></th>
										<th><h6>Password</h6></th>
										<th><h6>Address</h6></th>
										<th><h6>Contact</h6></th>
										<th><h6>DOB</h6></th>

										<th><h6>User Type</h6></th>
										<th><h6>Active Users</h6></th>
										<th><h6>Action</h6></th>
									</tr>
									<!-- end table row-->
								</thead>
								<c:if test="${!empty employees}">
									<c:forEach items="${employees}" var="employee">
										<c:if test="${userTypeId1 eq 1}">
											<c:if
												test="${(employee.userTId eq 2) or (employee.userTId eq 4)}">
												<tbody>
													<tr>
														<td class="min-width"><c:out
																value="${employee.userMasterId}" /></td>
														<td class="min-width"><c:out
																value="${employee.userMasterFirstName}" /></td>
														<td class="min-width"><c:out
																value="${employee.userMasterLastName}" /></td>
														<td class="min-width"><c:out
																value="${employee.userEmailId}" /></td>
														<td class="min-width"><c:out
																value="${employee.userPassword}" /></td>
														<td class="min-width"><c:out
																value="${employee.userAddress}" /></td>
														<td class="min-width"><c:out
																value="${employee.userContact}" /></td>
														<td class="min-width"><c:out
																value="${employee.userDOB}" /></td>
														<td class="min-width"><c:out
																value="${employee.userTypeName}" /></td>
														<td class="min-width " id="togglec"><a
															href="updateActiveEmployee?userMasterId=${employee.userMasterId}"
															class="text-danger"> <c:out
																	value="${employee.isActive}" /></a></td>
														<td>
															<div class="action">
																<a
																	href="editEmployee?userMasterId=${employee.userMasterId}"
																	class="text-important"> <svg
																		xmlns="http://www.w3.org/2000/svg" width="16"
																		height="16" fill="currentColor"
																		class="bi bi-pencil-fill" viewBox="0 0 16 16">
												  <path
																			d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
												</svg>
																</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a
																	href="deleteEmployee?userMasterId=${employee.userMasterId}"
																	class="text-danger"><i class="lni lni-trash-can"></i></a>
															</div>
														</td>

													</tr>
												</tbody>
											</c:if>
										</c:if>

										<c:if test="${userTypeId1 eq 2}">
											<c:if test="${employee.userTId eq 4}">
												<tbody>
													<tr>
														<td class="min-width"><c:out
																value="${employee.userMasterId}" /></td>
														<td class="min-width"><c:out
																value="${employee.userMasterFirstName}" /></td>
														<td class="min-width"><c:out
																value="${employee.userMasterLastName}" /></td>
														<td class="min-width"><c:out
																value="${employee.userEmailId}" /></td>
														<td class="min-width"><c:out
																value="${employee.userPassword}" /></td>
														<td class="min-width"><c:out
																value="${employee.userAddress}" /></td>
														<td class="min-width"><c:out
																value="${employee.userContact}" /></td>
														<td class="min-width"><c:out
																value="${employee.userDOB}" /></td>
														<td class="min-width"><c:out
																value="${employee.userTypeName}" /></td>
														<td class="min-width " id="togglec"><a
															href="updateActiveEmployee?userMasterId=${employee.userMasterId}"
															class="text-danger"> <c:out
																	value="${employee.isActive}" /></a></td>
														<td>
															<div class="action">
																<a
																	href="editEmployee?userMasterId=${employee.userMasterId}"
																	class="text-important"> <svg
																		xmlns="http://www.w3.org/2000/svg" width="16"
																		height="16" fill="currentColor"
																		class="bi bi-pencil-fill" viewBox="0 0 16 16">
												  <path
																			d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
												</svg>
																</a> &nbsp;&nbsp;|&nbsp;&nbsp; <a
																	href="deleteEmployee?userMasterId=${employee.userMasterId}"
																	class="text-danger"><i class="lni lni-trash-can"></i></a>
															</div>
														</td>
													</tr>
												</tbody>
											</c:if>
										</c:if>
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
		/*function myFunction(x) {
		 x.disabled = true
		 let elmId = document.getElementById("paid")
		 elmId.innerHTML="Paid";
		 elmId.className =
		 document.getElementById("paid").className.replace( 'btn-success' , '' )
		 elmId.className += " btn-danger";
		 /*  if (x.style.display === "none") {
		 x.style.display = "block";
		 } else {
		 x.style.display = "none";
		 } */
		/*    }*/

		/*  document.querySelector(document).ready(function(){
		 document.querySelector('.btn-paid').click(function(){
		 document.querySelector(this).prop("disabled", true).text('paid').classList.remove('btn-success').classList.add('btn-danger');
		 })
		 }); 
		 */

		$(document).ready(
				function() {
					$('.btn-paid').click(
							function() {
								$(this).prop("disabled", true).text('paid')
										.removeClass('btn-success').addClass(
												'btn-danger');
							})
				});
	</script>
</section>
<%-- <td class="min-width"><c:if test="${(employee.userTId == 2) || (employee.userTId ==4)}">
												<c:out value="${employee.userSalary}" />


													<c:if test="${employee.isPaid == 'NotPaid'}">

														<a class="btn btn-paid btn-success active "
															href="updatePaidSalary?userSalaryId=${employee.userSalaryId}">


															Pay </a>

													</c:if> <c:if test="${employee.isPaid == 'Paid'}">
														<a class="btn btn-paid btn-danger active disabled"
															href="addSalaryUser?userMasterId=${employee.userMasterId}">


															Paid </a>

													</c:if>
														
													</c:if>
													</td>
												 --%>

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

<%@include file="footer.jsp"%>