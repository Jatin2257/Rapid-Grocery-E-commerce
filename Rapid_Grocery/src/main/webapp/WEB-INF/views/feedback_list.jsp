 <%@include file="sidebar.jsp" %>
<%@include file="header.jsp" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <section class="table-components">
        <div class="container-fluid">
          <!-- ========== title-wrapper start ========== -->
          <div class="title-wrapper pt-30">
            <div class="row align-items-center">
              <div class="col-md-6">
                <div class="title mb-30">
                  <h2>All Feedbacks</h2>
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
                      <li class="breadcrumb-item active" aria-current="page">
                        Feedback List
                      </li>
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
                  <h6 class="mb-10">Feedback Listing</h6>
                  <div class="table-wrapper table-responsive">
                  <table class="table">
                      <thead>
                        <tr>
                          <th><h6>Feedback ID</h6></th>
                          <th><h6>Feedback Message</h6></th>
                          <th><h6>Date</h6></th>
                          <th><h6>User Name</h6></th>
                        </tr>
                        <!-- end table row-->
                      </thead>
                    
		                <c:if test="${!empty feedbacks}">
								<c:forEach items="${feedbacks}" var="feedback">
									<tbody>
				                        <tr>
				                          <td class="min-width">
				                            <c:out value="${feedback.feedbackId}"/>
				                          </td>
				                          <td class="min-width">
				                            <c:out value="${feedback.feedbackMessage}"/>
				                          </td>
				                          <td class="min-width">
				                            <c:out value="${feedback.feedbackDate}"/>
				                          </td>
				                          <td class="min-width">
				                           <c:out value="${feedback.userMasterFirstName}"/> <c:out value="${feedback.userMasterLastName}"/>
				                          </td>
				                        </tr>
				                      </tbody>
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
      </section>
<%@include file="footer.jsp" %>
      