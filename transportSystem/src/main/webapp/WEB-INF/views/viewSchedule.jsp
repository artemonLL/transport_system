<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 18.02.2018
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<section>
<!-- Page Content -->
<div class="container">

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-12 mb-12">
            <div class="card h-100">
                <h4 class="card-header">Schedule</h4>
                <div class="card-body">

                    <p>name:${user.first_name}</p
                    <p>lastName:${user.last_name}</p>
                    <p>date:${user.date_birth}</p>
                    <p>email:${user.email}</p>
                    <p>pass:${user.password}</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">Learn More</a>
                </div>
            </div>
        </div>
</section>


<%@include file="/WEB-INF/views/template/footer.jsp"%>