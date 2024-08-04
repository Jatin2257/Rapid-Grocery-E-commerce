<%@include file="sidebar.jsp" %>
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 

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
                  <h2>Sub Product</h2>
                </div>
              </div>
              <!-- end col -->
              <div class="col-md-6">
                <div class="breadcrumb-wrapper mb-30">
                  <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                      <li class="breadcrumb-item">
                        <a href="#0">Dashboard</a>
                      </li>
                      <li class="breadcrumb-item"><a href="#0">Manage Sub Product</a></li>
                      <li class="breadcrumb-item active" aria-current="page">
                        Sub Product
                      </li>
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
                

                <form:form action="addsubproduct" method="post" modelAttribute="SubProduct" id= "form" enctype="multipart/form-data">                
	                <div class="card-style">
	            
						<div class="input-style-1 col-lg-6 form-control">
		                  	<form:hidden path="subproductId" value="${subproduct.subproductId}"/> 	                  	
	            		    <form:label path="subproductImage">Product Image</form:label>
					<input class="form-control" name="imgupload" type="file" accept="image/png, image/jpeg" id="formFile" />
					 	</div>
					 		<div class="input-style-1 col-lg-6 form-control">	                  
		                  	<form:label path="subproductName">Enter Product Name</form:label>
						 	<form:input path="subproductName" id= "subproductname"  type="text" value="${subproduct.subproductName}" />
					 		<small style="color:red;">Username must be at least 3 characters</small>					 						
					 	</div>
							<div class="input-style-1 col-lg-6 form-control">
						 	<form:label path="subproductDescription" >Enter Product Description</form:label>
						 	<form:input path="subproductDescription" type="text" id= "subproductdescription" value="${subproduct.subproductDescription}" />
					 		<small style="color:red;">Username must be at least 3 characters</small>
					 	</div>
							<div class="input-style-1 col-lg-6 form-control">
						 	<form:label path="subproductPrice">Enter Product Price</form:label>
						 	<form:input path="subproductPrice" type= "number" id= "subproductprice" value="${subproduct.subproductPrice}" />
							<small style="color:red;">Username must be at least 3 characters</small>					
					 </div>
							<div class="input-style-1 col-lg-6 form-control">
							 <form:label path="subproductQuantity">Enter Product Quantity</form:label>
						 	<form:input path="subproductQuantity" type= "number" id= "subproductquantity" value="${subproduct.subproductQuantity}" />
							<small style="color:red;">Username must be at least 3 characters</small>					
					 </div>
							<div class="input-style-1 col-lg-6 form-control">
					 	<%-- <form:hidden path="productId" value="${product.subProductId}"/> --%>
	                  <form:label path="productId">Product Name</form:label>

								<form:select path="productId" class="form-control">
									<c:forEach items="${products}" var="product">
										<form:option class="text-dark" value="${product.productId}">${product.productName}</form:option>
									</c:forEach>
								</form:select>
	                  </div>
					 <input type="submit" class="main-btn primary-btn rounded-md btn-hover" value="Add Sub Products">
	            		
	                  </div>
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
<script>
const form = document.querySelector("#form");
const subproductDes = document.querySelector("#subproductdescription");
const subproductprice = document.querySelector("#subproductprice");
const subproductquantity = document.querySelector("#subproductquantity");
const subproductname = document.querySelector("#subproductname");

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
    if (input.value.length < min || input.value.length > max) {
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
    }else{
    	showSuccess(input);
    	error =false;
    }
};

const checknumLength = (input, min) => {
    if (input.value < min) {
        showError(
            input,
            "You Must Fill This Field"
        );
        error=true;
    }else{
    	showSuccess(input);
    	error =false;
    }
};



const validateForm = () => {
   
    
    checkLength(subproductname, 1, 255);
    checknumLength(subproductquantity, 1);
    checknumLength(subproductprice, 1);
    checkLength(subproductDes, 1, 255);
    
   
};

form.addEventListener("submit", function (e) {
    e.preventDefault();
    
    validateForm();
  
   if(!error) {
       form.submit()
   }
});



</script>
<%@include file="footer.jsp" %>