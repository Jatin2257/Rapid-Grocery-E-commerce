<%@include file="header.jsp"%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="/">Home</a> <span
					class="breadcrumb-item active">Register</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="container-fluid">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Sign Up</span>
	</h2>
	 <div class="form-group">
	 	<div style=" margin:0 left; " class="row px-xl-5">
		<div class="col-5 mb-8 offset-md-4">
			<div class="contact-form bg-light p-30">
			
				<div id="success"></div>
				
				<form:form action="adduser" method="POST" modelAttribute="User"
					name="sentMessage" id="contactForm" novalidate="novalidate">
					<form:hidden path="userMasterId" value="${user.userMasterId}" />
					<div class="control-group">
						<form:label path="userMasterFirstName">Enter Last Name</form:label>
						<form:input path="userMasterFirstName"
							value="${user.userMasterFirstName}" type="text"
							class="form-control" placeholder="Your First Name"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userMasterLastName">Enter Last Name</form:label>
						<form:input path="userMasterLastName"
							value="${user.userMasterLastName}" type="text"
							class="form-control" placeholder="Your Last Name"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userEmailId">Enter Email Id</form:label>
						<form:input path="userEmailId" value="${user.userEmailId}"
							type="email" class="form-control" placeholder="Your Email"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userDOB">Enter Date Of Birth</form:label>
						<form:input path="userDOB" value="${user.userDOB}" type="date"
							class="form-control" placeholder="Your DOB" required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userContact">Enter Contact</form:label>
						<form:input path="userContact" value="${user.userContact}"
							type="number" class="form-control" placeholder="Your Phone No"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userAddress">Enter Address</form:label>
						<form:textarea path="userAddress" class="form-control" rows="8"
							id="message" placeholder="Enter Your Address" />
						<p class="help-block text-danger"></p>
					</div>

					<div class="control-group">
						<form:label path="userPassword">Enter Password</form:label>
						<form:input path="userPassword" value="${user.userPassword}"
							type="password" class="form-control" id="pass"
							placeholder="Enter Password" required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<label>Confirm Password</label> <input type="password"
							class="form-control" id="cpass"
							placeholder="Enter Confirm Password" required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div>
						<input type="submit" class="btn btn-primary py-2 px-4"
							value="Register" /> <input type="reset"
							class="btn btn-primary py-2 px-4" value="Reset" />
					</div>
					<br>
					<div class="control-group">
						<a href="/login">Already Have Account?</a>
					</div>
				</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
</div></div></div>
<!--  End -->

<%@ include file="footer.jsp"%>