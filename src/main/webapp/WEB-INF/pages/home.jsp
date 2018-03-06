<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<%@include file="/WEB-INF/pages/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
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
                        <h3>                 </h3>
                        <p>This is a description for the first slide.</p>
                    </div>
                </div>
                <!-- Slide Two - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>                </h3>
                        <p>This is a description for the second slide.</p>
                    </div>
                </div>
                <!-- Slide Three - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>                 </h3>
                        <p>This is a description for the third slide.</p>
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

            <h1 class="my-4">Any Railways</h1>

            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-12 mb-12">
                    <div class="card h-100">
                        <h4 class="card-header">Schedule</h4>
                        <div class="card-body">

                            <section>


                                <div class="container">
                                    <fieldset>
                                        <form:form id="SelectRegisterForm" cssClass="form-horizontal" modelAttribute="selectform"
                                                   method="post" action="selecttrain">
                                    <!-- Marketing Icons Section -->
                                    <div class="row">
                                        <div class="col-lg-6 col-sm-6  col-md-6 portfolio-item">
                                            <div class="card h-100">

                                                <div class="card-body">


                                                    <div class="form-group">
                                                        <div  cssClass="control-label col-xs-3">Departure Station</div>

                                                        <div class="col-xs-6">

                                                            <form:select   path="stationOne" class="form-control" >
                                                                <option value="${stationList.get(1).station_id}" >Select</option>

                                                                <c:forEach var="onestation" items="${stationList}" >
                                                                    <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                                </c:forEach>


                                                            </form:select>



                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div  cssClass="control-label col-xs-3">Arrival Station</div>

                                                        <div class="col-xs-6">

                                                            <form:select   path="stationTwo" class="form-control" >
                                                                <option value="${stationList.get(1).station_id}" >Select</option>

                                                                <c:forEach var="onestation" items="${stationList}" >
                                                                    <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                                </c:forEach>


                                                            </form:select>



                                                        </div>
                                                    </div>
                                                    <div class="form-group">


                                                        <div class="col-xs-6">


              <input type="submit" id="selecttrain" class="btn btn-primary"   value="Find Train" onclick="return submitScheduleForm();"/>


                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-lg-6 col-sm-6 col-md-6 portfolio-item">
                                            <div class="card h-100">
                                                <div class="card-body">



                                                    <div class="row">
                                                        <div class="col-lg-12 mb-12">
                                                                    <div class="form-group">
                                                                        <form:label path="dateOne"
                                                                                    cssClass="control-label col-xs-3">from Time(hh:mm:ss)</form:label>
                                                                        <div class="col-xs-6">
                                                                            <form:input  cssClass="form-control" path="dateOne"
                                                                            />

                                                                        </div>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <form:label path="dateTwo" cssClass="control-label col-xs-3">to Time(hh:mm:ss)</form:label>
                                                                        <div class="col-xs-6">
                                                                            <form:input  cssClass="form-control" path="dateTwo"   value="${selectObject.dateTwo}"/>
                                                                        </div>
                                                                    </div>



                                                                    <div class="form-group">
                                                                        <form:label path="dateForSelect" cssClass="control-label col-xs-3">DATE(YYYY-mm-dd)</form:label>
                                                                        <div class="col-xs-6">
                                                                            <form:input  cssClass="form-control" path="dateForSelect"/>
                                                                        </div>
                                                                    </div>

                                                            </fieldset>


                                                        </div>




                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>




                                <!--//////////////////////////////////////////////////////////////-->


                            </section>
                        </div>
                    </div>
                </div>

                        </div>

    </form:form>
                    </div>
                </div>


            </div>
</section>
            <!-- /.row -->

            <!-- Portfolio Section -->

            <!-- /.container -->

            <!-- Footer -->
            <%@include file="/WEB-INF/pages/homenews.jsp" %>
