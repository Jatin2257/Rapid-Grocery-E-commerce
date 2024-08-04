<%@include file="header.jsp" %>

<!-- style -->

<style>

.forms-control {
	border: none;
}

.forms-control label {
	color: #7a5059;
	display: block;
	font-size: 1.5rem;
	margin-bottom: 0.5rem;
}

.forms-control input {
	/* border: 1px solid #dcb5a0;
	border-radius: 0.4rem;
	display: block;
	font-size: 1.4rem;
	padding: 1rem;
	width: 100%;
	transition: border-color 0.5s; */
}

.forms-control input:focus {
	outline: none;
	border-color: #7a5059 !important;
}

.forms-control.success input {
	border-color: #7aa55b !important;
}

.forms-control.error input {
	border-color: #f44336 !important;
}

.forms-control small {
	color: #f44336 !important;
	position: absolute;
	bottom: 2;
	left: 2;
	visibility: hidden;
}

.forms-control.error small {
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

.forms-control select {
	/* border: 1px solid #dcb5a0;
	border-radius: 0.4rem;
	display: block;
	font-size: 2rem;
	padding: 1rem;
	width: 100%;
	transition: border-color 0.5s; */
}

.forms-control textarea {
	border: 1px solid #dcb5a0;
	border-radius: 0.4rem;
	display: block;
	font-size: 2rem;
	padding: 1rem;
	width: 100%;
	transition: border-color 0.5s;
}
</style>









    <!-- Breadcrumb Start -->
    <div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="/">Home</a>
                    <a class="breadcrumb-item text-dark" href="shop">Shop</a>
                    <span class="breadcrumb-item active">Checkout</span>
                </nav>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

<form action="payment" id="contactform">
    <!-- Checkout Start -->
    <div class="container-fluid">
        <div class="row px-xl-5" id="form"> 
            <div class="col-lg-8">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                <div class="bg-light p-30 mb-5">
                  
                    <div class="row">
                        <div class="col-md-6 form-group forms-control ">
                            <label>First Name</label>
                            <input class="form-control" type="text" placeholder="John">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Last Name</label>
                            <input class="form-control" type="text" placeholder="Doe">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>E-mail</label>
                            <input class="form-control" type="text" mailto:placeholder="example@email.com">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Mobile No</label>
                            <input class="form-control" type="text" placeholder="+123 456 789">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 1</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address Line 2</label>
                            <input class="form-control" type="text" placeholder="123 Street">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Country</label>
                            <select class="custom-select">
                            	<option selected>India</option>
                                <option >United States</option>
                                <option>Afghanistan</option>
                                <option>Albania</option>
                                <option>Algeria</option>
                            </select>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>City</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>State</label>
                            <input class="form-control" type="text" placeholder="New York">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>ZIP Code</label>
                            <input class="form-control" type="text" placeholder="123">
                        </div>
                        <div class="col-md-12">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="shipto">
                                <label class="custom-control-label" for="shipto"  data-toggle="collapse" data-target="#shipping-address">Ship to different address</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="collapse mb-5" id="shipping-address">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Shipping Address</span></h5>
                    <div class="bg-light p-30">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>First Name</label>
                                <input class="form-control" type="text" placeholder="John">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Last Name</label>
                                <input class="form-control" type="text" placeholder="Doe">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>E-mail</label>
                                <input class="form-control" type="text" mailto:placeholder="example@email.com">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Mobile No</label>
                                <input class="form-control" type="text" placeholder="+123 456 789">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Address Line 1</label>
                                <input class="form-control" type="text" placeholder="123 Street">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Address Line 2</label>
                                <input class="form-control" type="text" placeholder="123 Street">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Country</label>
                                <select class="custom-select">
                                	<option selected>India</option>
                                    <option >United States</option>
                                    <option>Afghanistan</option>
                                    <option>Albania</option>
                                    <option>Algeria</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>City</label>
                                <input class="form-control" type="text" placeholder="New York">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>State</label>
                                <input class="form-control" type="text" placeholder="New York">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>ZIP Code</label>
                                <input class="form-control" type="text" placeholder="123">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom">
                        <div class="d-flex justify-content-between">
                            <p><b>Product Name</b></p>
                            <p><b>Quantity</b></p>
                            <p><b>Price</b></p>
                        </div>
                        <!-- here loop will start -->
					<c:if test="${!empty cartsubproducts}">
						<c:forEach items="${cartsubproducts}" var="cartsubproduct">
                        <div class="d-flex justify-content-between">
                            <p>${cartsubproduct.subproductName}</p>
                            <p>${cartsubproduct.quantity}</p>
                            <p><svg	xmlns="http://www.w3.org/2000/svg" width="20" height="20"
									fill="currentColor" class="bi bi-currency-rupee"
									viewBox="0 0 16 16">
								  <path d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${cartsubproduct.totalAmount}</p>
								
								<!-- calculating the total of all itms -->
									<c:set var="total" value="${total + cartsubproduct.totalAmount}" />
                        </div>
                      	</c:forEach>
                    </c:if>
                    </div>
                    <div class="border-bottom pt-3 pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Subtotal</h6>
                            <h6><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
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
							0</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
								fill="currentColor" class="bi bi-currency-rupee"
								viewBox="0 0 16 16">
								  <path
									d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4v1.06Z" />
								</svg>${total}</h5>
								
                        </div>
                    </div>
                </div>
                <div class="mb-5">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                  
                    <div class="bg-light p-30">                        
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="directcheck" value = "online">
                                <label class="custom-control-label" for="directcheck">Online</label>
                            </div>
                        </div>
                        <div class="form-group mb-4">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="banktransfer" value = "offline"><!--checked--->
                                <input type="hidden" name="total" value="${total}"> 
                                <label class="custom-control-label" for="banktransfer">Cash On Delivery</label>
                            </div>
                        </div>
<!--                         <button class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button> -->
                        <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button>
                    </div>
                  
                </div>
            </div>
        </div>
    </div>
</form>
    <!-- Checkout End -->

<!-- JavaScrip Code -->

<script>
var form = document.querySelector("#contactform");
var firstname1 = document.querySelector("#firstname1");
var firstname2 = document.querySelector("#firstname2");
var lastname1 = document.querySelector("#lastname1");
var lastname2 = document.querySelector("#lastname2");
var email1 = document.querySelector("#email1");
var email2 = document.querySelector("#email2");
var phoneno1 = document.querySelector("#phoneno1");
var phoneno2 = document.querySelector("#phoneno2");
var address1 = document.querySelector("#address1");
var address1c = document.querySelector("#address1c");
var address2 = document.querySelector("#address2");
var address2c = document.querySelector("#address2c");
var city1 = document.querySelector("#city1");
var city2 = document.querySelector("#city2");
var state1 = document.querySelector("#state1");
var state2 = document.querySelector("#state2");
var zip1 = document.querySelector("#zip1");
var zip2 = document.querySelector("#zip2");
var checkBox = document.getElementById("shipto");

console.log(phoneno1.value);
console.log(zip1.value);

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

const checknumber = (input) => {
    if (!(input.value.length == 10)) {
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
const checknumberzip = (input) => {
    if (!(input.value.length === 6)) {
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

const checkEmail = (input) => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (re.test(input.value)) {
        showSuccess(input);
        error=false;
    } else {
        showError(input, "Email address is invalid. ");
        error = true;
    }
};

const checkedlist= (input)=> {
	  
	  if (input.checked == true){
		  validateForm1();
	  } 
	}

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

const firstnamecheck = ()=>{
	var firstname1 = document.querySelector("#firstname1");
	checkLength(firstname1, 1, 255);
}



const validateForm = () => {
    checkLength(firstname1, 1, 255);
    checkLength(lastname1, 1, 255);
    checkEmail(email1);
    checknumber(phoneno1);
    checkLength(address1, 1,255);
    checkLength(address1c, 1, 255);
    checknumberzip(zip1);
    checkLength(city1, 1,255);
    checkLength(state1, 1, 255);
    checkedlist(checkBox);
    console.log(phoneno1.value.length);
    console.log(zip1.value);
   console.log("done");
};


const validateForm1 = () => {
   
    
    checkLength(firstname2, 1, 255);
    checkLength(lastname2, 1, 255);
    checkEmail(email2);
    checknumber(phoneno2);
    checkLength(address2, 1,255);
    checkLength(address2c, 1, 255);
    checknumberzip(zip2);
    checkLength(city2, 1,255);
    checkLength(state2, 1, 255);
    
   
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