 <%@include file="sidebar.jsp"%>
<%@include file="header.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
:root { -
	-off-white: #f2f4ef; 
	-white: #fff; 
	-primary-color: #e68c74; 
	-secondary-color: #7a5059; 
	-light-accent-color: #dcb5a0; 
	-dark-accent-color: #ed7b6d; 
	-success-color: #7aa55b; 
	-error-color: #f44336;
}

.form-control {
	border: none;
}

.form-control label {
	color: #7a5059;
	display: block;
	font-size: 1.5rem;
	margin-bottom: 0.5rem;
}

.form-control input {
	border: 1px solid #dcb5a0;
	border-radius: 0.4rem;
	display: block;
	font-size: 1.4rem;
	padding: 1rem;
	width: 100%;
	transition: border-color 0.5s;
}

.form-control input:focus {
	outline: none;
	border-color: #7a5059 !important;
}

.form-control.success input {
	border-color: #7aa55b !important;
}

.form-control.error input {
	border-color: #f44336 !important;
}

.form-control small {
	color: #f44336 !important;
	position: absolute;
	bottom: 2;
	left: 2;
	visibility: hidden;
}

.form-control.error small {
	visibility: visible;
}

.form button {
	cursor: pointer;
	background-color: #e68c74;
	border: 1px solid #e68c74;
	color: var(- -white);
	border-radius: 0.4rem;
	padding: 1rem 2rem;
	display: block;
	font-size: 1.6rem;
	margin-top: 2rem;
	width: 100%;
}

.form-control select {
	border: 1px solid #dcb5a0;
	border-radius: 0.4rem;
	display: block;
	font-size: 1.4rem;
	padding: 1rem;
	width: 100%;
	transition: border-color 0.5s;
}
</style>
<section class="tab-components">
	<div class="container-fluid">
		<!-- ========== title-wrapper start ========== -->
		<div class="title-wrapper pt-30">
			<div class="row align-items-center">
				<div class="col-md-6">
					<div class="title mb-30">
						<h2>Product</h2>
					</div>
				</div>
				<!-- end col -->
				<div class="col-md-6">
					<div class="breadcrumb-wrapper mb-30">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#0">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="#0">Manage Product</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									Product</li>
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
					<!-- input style start -->


					<form:form action="addproduct" method="POST"
						modelAttribute="Product" id="form">
						<div class="card-style">
							<div class="input-style-1 col-lg-6 form-control">
								<form:hidden path="productId" value="${product.productId}" />
								<form:label path="productName">Enter Product</form:label>
								<form:input path="productName" id="productname"
									value="${product.productName}" />
								<small style="color:red;">Username must be at least 3 characters</small>

							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="productDescription">Product Description</form:label>
								<form:input path="productDescription" id="productdes"
									value="${product.productDescription}" />
								<small>Username must be at least 3 characters</small>
							</div>
							<div class="input-style-1 col-lg-6 form-control">

								<form:label path="category">Category Name</form:label>

								<form:select path="category" class="form-control">
									<c:forEach items="${categorys}" var="category">
										<form:option class="text-dark" value="${category.categoryId}">${category.categoryName}</form:option>
									</c:forEach>
								</form:select>

							</div>

							<input type="submit"
								class="main-btn primary-btn rounded-md btn-hover"
								value="Add Product">
						</div>
					</form:form>



					<!-- end card -->
				</div>
			</div>
			<!-- end row -->
		</div>
		<!-- ========== form-elements-wrapper end ========== -->
	</div>
	<!-- end container -->
</section>
<script>
const form = document.querySelector("#form");
const productname = document.querySelector("#productname");
const productdes = document.querySelector("#productdes");
var error = false;
const showError = (input, msg) => {
    const formControl = input.parentElement;
    const small = formControl.querySelector("small");
    formControl.classList.add("error");
    small.textContent = msg;
};

const showSuccess = (input) => {
    const formControl = input.parentElement;
    formControl.classList.add("success");
};

const checkLength = (input, min, max) => {
	const numberRegex = /^\d+$/;
    if (input.value.length < min || input.value.length > max){
        showError(
            input,
            "You Must Fill This Field"
        );
        error=true;
    }else if(numberRegex.test(input.value)){
    	showError(
                input,
                "You Must Fill Only Characters."
            );
            error=true;
    } else{
    	showSuccess(input);
    	error =false;
    }
};



const validateForm = () => {
   
    
    checkLength(productname, 1, 255);
    checkLength(productdes, 1, 255);
    
   
};

form.addEventListener("submit", function (e) {
    e.preventDefault();
    
    validateForm();
  
   if(!error) {
       form.submit()
   }
});



</script>
<%@include file="footer.jsp"%>