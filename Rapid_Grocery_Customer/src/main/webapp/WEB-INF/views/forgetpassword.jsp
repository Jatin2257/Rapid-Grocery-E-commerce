<%@include file="header.jsp"%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="/">Home</a>
				<a class="breadcrumb-item text-dark" href="/login">Login</a> 
				<span class="breadcrumb-item active">Forget Password</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Login Start -->
<div class="container-fluid">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Forgot Password</span>
	</h2>
	<div style="margin:0 auto;" class="row px-xl-5">
		<div class="col-auto mb-5 offset-md-4">
			<div class="contact-form bg-light p-30">
				<div id="success"></div>
				<%-- <form:form action="" method="" modelAttribute="">	
						<form:input path=""
									value=""/> --%>
				<form name="sentMessage" id="contactForm" novalidate="novalidate">
								
					<div class="control-group">
					<label>Your E-mail</label>
						<input type="email" class="form-control" id="email"
							placeholder="Your Email" required="required"
							data-validation-required-message="Please enter your email" />
						<p class="help-block text-danger"></p>
					</div>
					<div>
						<input type="submit" class="btn btn-primary py-2 px-4" id="sendLoginButton" value="Reset Password" />						
					</div>
					<br>
					<div class="control-group">										
						<a href="/login">Back to Login</a>			
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!--  End -->


<%@include file="footer.jsp"%>