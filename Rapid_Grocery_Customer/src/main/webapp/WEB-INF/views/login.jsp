<%@include file="header.jsp"%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="/">Home</a> <span
					class="breadcrumb-item active">Login</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

<!-- Login Start -->
<div class="container">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Sign In</span>
	</h2>
	<div style="margin:0 auto;" class="row px-xl-5">
		<div class="col-auto mb-5 offset-md-4">
			<div class="contact-form bg-light p-30">
				<div id="success"></div>
				<%-- <form:form action="" method="" modelAttribute="">	
						<form:input path=""
									value=""/> --%>
				<form:form action="checklogin" method="POST" modelAttribute="User"
					name="sentMessage" id="contactForm" novalidate="novalidate">
								
					<div class="control-group">
						<form:label path="userEmailId">Enter Email Id</form:label>
						<form:input path="userEmailId" type="email"
							class="form-control" placeholder="Enter Your Email"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group">
						<form:label path="userPassword">Enter Password</form:label>
						<form:input path="userPassword"
							type="password" class="form-control" id="pass"
							placeholder="Enter Password" required="required" />
						<p style="color: red">${error}</p>
					</div>
					<div>
						<input type="submit" class="btn btn-primary py-2 px-4" id="sendLoginButton" value="Login" />
						<input type="reset" class="btn btn-primary py-2 px-4" value="Reset" />
					</div>
					<br>
					<div class="control-group">				
						<a href="/forgetpassword">Forgot Password ?</a>&nbsp;&nbsp;|&nbsp;&nbsp;
						<a href="/register">New User Click Here</a>			
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<!--  End -->


<%@include file="footer.jsp"%>