<%@include file="sidebar.jsp"%>
<%@include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="tab-components">
	<div class="container-fluid">
		<!-- ========== title-wrapper start ========== -->
		<div class="title-wrapper pt-30">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="title mb-30"> 
						<h2>User</h2>
					</div>
				</div>
				<!-- end col -->
				<div class="col-md-6">
					<div class="breadcrumb-wrapper mb-30">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#0">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="#0">Manage User</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									User</li>
							</ol>
						</nav>
					</div>
				</div>
				<!-- end col -->
			</div>
			<!-- end row -->
		</div>
		<!-- ========== title-wrapper end ========== -->

		<!-- ========== form-elements-wrapper start ========== -->
		<div class="form-elements-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<!-- input style start  java.lang.IllegalStateException: Neither BindingResult nor plain target object for bean name 'SubProduc' available as request attribute -->


					<form:form action="adduser" method="POST" modelAttribute="User">
						<div class="card-style">
							<div class="input-style-1 select-style-1 col-lg-6">
								<form:hidden path="userMasterId" value="${user.userMasterId}" />
								<form:label path="userMasterFirstName">Enter First Name</form:label>
								<form:input path="userMasterFirstName"
									value="${user.userMasterFirstName}" />
								<form:label path="userMasterLastName">Enter Last Name</form:label>
								<form:input path="userMasterLastName"
									value="${user.userMasterLastName}" />
								<form:label path="userEmailId">Enter Email Id</form:label>
								<form:input path="userEmailId" value="${user.userEmailId}" />

								<form:label path="userAddress">Enter Address</form:label>
								<form:input path="userAddress" value="${user.userAddress}" />

								<form:label path="userContact">Enter Contact</form:label>
								<form:input path="userContact" value="${user.userContact}" />

								<form:label path="userDOB">Enter Date Of Birth</form:label>
								<form:input  path="userDOB" value="${user.userDOB}" />

								<form:label path="userPassword">Enter Password</form:label>
								<form:input path="userPassword" value="${user.userPassword}" />

								<form:label path="userSalary">Enter Salary</form:label>
								<form:input path="userSalary" value="${user.userSalary}" />

								<form:label path="isActive">Enter Active Status</form:label>
								
								<form:select class="form-select" path="isActive" value="${user.isActive}">
									<form:option class="bg-success text-light" value="Active" label="Active" />
									<form:option class="bg-danger text-light" value="InActive" label="In Active" />
									
								</form:select>

								<%-- <form:hidden path="productId" value="${product.subProductId}"/> --%>
							</div>
							<input type="submit"
								class="main-btn primary-btn rounded-md btn-hover"
								value="Add Sub Products">
						</div>
					</form:form>




					<!-- 
                <form action="addcategory" method="post">
	                <div class="card-style">
	                  <div class="input-style-1 col-lg-6">
	                    <label>Enter Category Name </label>
	                    <input type="text" name="category_name" placeholder="Enter Category Name" />
	                  </div>
	                <button class="main-btn primary-btn rounded-md btn-hover">Add Category</button>
	                </div>
                </form>
                 -->


					<!-- end card -->
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- ========== form-elements-wrapper end ========== -->
	</div>
	<!-- end container -->
</section>

<%@include file="footer.jsp"%>