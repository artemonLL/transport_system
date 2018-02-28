<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 16.02.2018
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/pages/header.jsp"%>
<section>
    <header>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <!-- Slide One - Set the background image for this slide in the line below -->
                <div class="carousel-item active" style="background-image:  url('http://i50.tinypic.com/2d9cnyb.jpg') " >
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Any railways</h3>
                        <!--   <p>This is a description for the third slide.</p>-->
                    </div>
                </div>


              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
              </a>
          </div>
      </header>
      <section>
          <!-- Page Content -->
        <div class="container">

            <h1 class="my-4">Some Railways</h1>

            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-12 mb-12">
                    <div class="card h-100">
                        <h4 class="card-header">Schedule</h4>
                        <div class="card-body">
                            <table class="table table-striped table-hover table-bordered">

                                <thead>
                                <tr>

                                    <th>user_id</th>
                                    <th>first_name</th>
                                    <th>password</th>
                                    <th>email</th>
                                    <th>last_name</th>
                                    <th>date</th>
                                    <th>role</th>

                                </tr>
                                </thead>
                                <c:forEach items="${userList}" var="userr">
                                    <tr>
                                        <td>${userr.first_name}</td>
                                        <td>${userr.first_name}</td>
                                        <td>${userr.password}</td>
                                        <td>${userr.email}</td>
                                        <td>${userr.last_name}</td>
                                        <td>${userr.date_birth}</td>
                                        <td>${userr.role.role_name}</td>


                                    </tr>
                                </c:forEach>



                            </table>
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">Get trains</a>
                        </div>
                    </div>
                </div>


            </div>
            <!-- /.row -->

            <!-- Portfolio Section -->
            <h2>Our News</h2>

            <div class="row">
                <div class="col-lg-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Project One</a>
                            </h4>
                            <p class="card-text">Trains its cool</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Project Two</a>
                            </h4>
                            <p class="card-text">Trains its very cool.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Project Three</a>
                            </h4>
                            <p class="card-text">Trains its very  cool</p>
                        </div>
                    </div>
                </div>

                <!-- /.row -->

                <!-- Features Section -->
                <div class="row">
                    <div class="col-lg-6">
                        <h2></h2>
                        <p>our prices</p>
                        <ul>
                            <li>
                                <strong>Holidays dicount</strong>
                            </li>
                            <li>dicount</li>
                            <li>one more dicount</li>
                            <li>dicount dicount dicount</li>
                            <li>dicount</li>
                        </ul>
                        <p> woooow</p>
                    </div>
                    <div class="col-lg-6">
                        <img class="img-fluid rounded" src="https://i.fltcdn.net/contents/1656/original_1441678442085_2myhlpaatt9.jpeg" alt="">
                    </div>

                </div>
                <!-- /.row -->

                <hr>

                <!-- Call to Action Section -->
                <div class="row mb-4">
                    <div class="col-md-8"> another text</p>
                    </div>
                    <div class="col-md-4">
                        <a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
                    </div>
                </div>

            </div>
    </section>
    <!-- /.container -->

    <!-- Footer -->
    <%@include file="/WEB-INF/pages/footer.jsp"%>
