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

.form-control textarea {
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

.form-control textarea {
	outline: none;
	border-color: #7a5059 !important;
}
.form-control.success input {
	border-color: #7aa55b !important;
}

.form-control.error input {
	border-color: #f44336 !important;
}

.form-control.success textarea {
	border-color: #7aa55b !important;
}

.form-control.error textarea {
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
						<h2>Add Employee</h2>
					</div>
				</div>
				<!-- end col -->
				<div class="col-md-6">
					<div class="breadcrumb-wrapper mb-30">
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#0">Dashboard</a></li>
								<li class="breadcrumb-item"><a href="#0">Manage
										Employees</a></li>
								<li class="breadcrumb-item active" aria-current="page">
									Employee Form</li>
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


					<form:form action="addEmployee" method="POST" id="form"
						modelAttribute="Employee">
						<div class="card-style">

							<div class="input-style-1 col-lg-6 form-control">
								<form:hidden path="userMasterId"
									value="${employee.userMasterId}" />
								<form:label path="userMasterFirstName">Enter FirstName</form:label>
								<form:input path="userMasterFirstName" id="usermasterfirstname"
									value="${employee.userMasterFirstName}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userMasterLastName">Enter LastName</form:label>
								<form:input path="userMasterLastName" id="usermasterlastname"
									value="${employee.userMasterLastName}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userEmailId">Enter EmailId</form:label>
								<form:input path="userEmailId" id="useremailid"
									value="${employee.userEmailId}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userAddress">Enter Address</form:label>
								<form:textarea path="userAddress" id="useraddress"
									value="${employee.userAddress}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userContact">Enter Phone Number</form:label>
								<form:input path="userContact" id="usercontact"
									value="${employee.userContact}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userDOB">Enter BirthDate</form:label>
								<form:input path="userDOB" id="userdob" value="${employee.userDOB}" />
								<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userPassword">Enter Password</form:label>
								<form:password path="userPassword" id="userpassword"
									value="${employee.userPassword}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							
							<div class="input-style-1 col-lg-6 form-control">
								<form:label path="userSalary">Enter Salary</form:label>
								<form:input path="userSalary" id="usersalary"
									value="${employee.userSalary}" />
									<small style="color:red;">Username must be at least 3 characters</small>
					
							</div>
							<div class="input-style-1 col-lg-6 form-control">
								<form:errors path="userPassword" cssClass="error" />
								<br>
								<form:label path="userTId">Select User Type</form:label>
								<form:select path="userTId" value="${employee.userTId}">
									<form:option value="2" label="Stock Manager" />
									<form:option value="4" label="DeliveryBoy" />
									<%-- 					        <form:option value="5" label="Customer"/>    --%>
								</form:select>
							</div>

							<input type="submit"
								class="main-btn primary-btn rounded-md btn-hover"
								value="Add Employee">

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
const usermasterfirstname = document.querySelector("#usermasterfirstname");
const usermasterlastname = document.querySelector("#usermasterlastname");
const useremailid = document.querySelector("#useremailid");
const useraddress = document.querySelector("#useraddress");
const usercontact = document.querySelector("#usercontact");
const userpassword = document.querySelector("#userpassword");
const usersalary = document.querySelector("#usersalary");
const userdob = document.querySelector("#userdob");
console.log(userdob.value);
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
    if (input.value.length < min || input.value.length > max) {
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

const validate = (password) => {
    var minMaxLength = /^[\s\S]{8,32}$/,
        upper = /[A-Z]/,
        lower = /[a-z]/,
        number = /[0-9]/,
        special = /[ !"#$%&'()*+,\-./:;<=>?@[\\\]^_`{|}~]/;

    if (!(minMaxLength.test(password.value) &&
        upper.test(password.value) &&
        lower.test(password.value) &&
        number.test(password.value) &&
        special.test(password.value)) || password.value== null
    ) {
    	showError(
    			password,
                "You Must Fill This Field"
            );
            error=true;
    }else{showSuccess(password);
    error= false;}

   
}


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

const checknumber = (input) => {
    if (!(input.value == 10)) {
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

const date = (input) => {
    if (!(input.value)) {
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


const validateForm = () => {
   
    
    checkLength(usermasterfirstname, 1, 255);
    checkLength(usermasterlastname, 1, 255);
    checkEmail(useremailid);
    checkLength(useraddress, 1, 255);
    checknumber(usercontact);
    checknumLength(usersalary, 5);
    validate(userpassword);
   	date(userdob);
};

form.addEventListener("submit", function (e) {
    e.preventDefault();
    validateForm();
  
   if(error == false) {
       form.submit()
   } 
});



</script>



<%@include file="footer.jsp"%>
