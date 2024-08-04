 <%@include file="sidebar.jsp" %>
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>


:root {
    --off-white: #f2f4ef;
    --white: #fff;
    --primary-color: #e68c74;
    --secondary-color: #7a5059;
    --light-accent-color: #dcb5a0;
    --dark-accent-color: #ed7b6d;
    --success-color: #7aa55b;
    --error-color: #f44336;
}


.form-control {
    border:none;
}

.form-control label {
    color: var(--secondary-color);
    display: block;
    font-size: 1.5rem;
    margin-bottom: 0.5rem;
}

.form-control input {
    border: 1px solid var(--light-accent-color);
    border-radius: 0.4rem;
    display: block;
    font-size: 1.4rem;
    padding: 1rem;
    width: 100%;
    transition: border-color 0.5s;
}

.form-control input:focus {
    outline: none;
    border-color: var(--secondary-color);
}

.form-control.success input {
    border-color: var(--success-color);
}

.form-control.error input {
    border-color: var(--error-color);
}

.form-control small {
    color: var(--error-color);
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
    background-color: var(--primary-color);
    border: 1px solid var(--primary-color);
    color: var(--white);
    border-radius: 0.4rem;
    padding: 1rem 2rem;
    display: block;
    font-size: 1.6rem;
    margin-top: 2rem;
    width: 100%;
}



</style>
<section class="tab-components">
        <div class="container-fluid">
          <!-- ========== title-wrapper start ========== -->
          <div class="title-wrapper pt-30">
            <div class="row align-items-center">
              <div class="col-md-6">
                <div class="title mb-30">
                  <h2>Category</h2>
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
                      <li class="breadcrumb-item"><a href="#0">Manage Category</a></li>
                      <li class="breadcrumb-item active" aria-current="page">
                        Category
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
                <!-- input style start -->
                

                <form:form action="addcategory" method="POST" modelAttribute="Category" id="form">                
	                <div class="card-style">
	                  <div class="input-style-1 col-lg-6 form-control">  
	                  	<form:hidden path="categoryId" value="${category.categoryId}"/>
	                  	<form:label path="categoryName">Enter Category</form:label>
					 	<form:input path="categoryName" id="category" value="${category.categoryName}" />
	                   <small>Username must be at least 3 characters</small>
	                  
	                  </div>
	                  <input type="submit" class="main-btn primary-btn rounded-md btn-hover" value="Add Category">
	              
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
const category = document.querySelector("#category");
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



const validateForm = () => {
   
    
    checkLength(category, 1, 255);
    
   
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