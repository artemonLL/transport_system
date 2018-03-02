


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/WEB-INF/pages/header.jsp" %>
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
                    <h3>            </h3>
                    <p>This is a description for the first slide.</p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>              </h3>
                    <p>This is a description for the second slide.</p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>             </h3>
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
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                    <tr>

                        <th>Train</th>
                        <th>Station</th>
                        <th>Date</th>

                    </tr>
                    </thead>


                    <c:forEach items="${list}" var="oneschedule">
                        <tr>
                            <td>${oneschedule.train.train_nomber}</td>
                            <td>${oneschedule.station.station_name}</td>
                            <td>${oneschedule.time_msk}</td>

                        </tr>
                    </c:forEach>
                </table>

            </div>

            <div class="container">

                <!-- Marketing Icons Section -->
                <div class="row">


                    <div class="col-lg-10 col-sm-10 portfolio-item">
                        <div class="card h-100">
                            <div class="card-body">
                                <fieldset>
                                    <form:form id="SelectRegisterForm" cssClass="form-horizontal" modelAttribute="selectform"
                                               method="post" action="selecttrain">
                                        <form> <div class="form-group">
                                            <div class="control-label col-xs-3">

                                                <form:label  path="stationOne">Departure Station</form:label></div>

                                            <div class="col-xs-6">
                                                <form:input cssClass="form-control" path="stationOne" value="${selectObject.stationOne}"/>

                                            </div>
                                        </div>
                                            <div class="form-group">
                                                <div  cssClass="control-label col-xs-3">Arrival Station</div>

                                                <div class="col-xs-6">

                                                    <form:select   path="stationTwo" class="selectpicker">
                                                        <option value="${stationList.get(1).station_id}" >Arrival Station</option>

                                                        <c:forEach var="onestation" items="${stationList}" >
                                                            <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                        </c:forEach>


                                                    </form:select>



                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <form:label path="dateOne"
                                                            cssClass="control-label col-xs-3">from DATE(YYYY:mm:dd)</form:label>
                                                <div class="col-xs-6">
                                                    <form:input cssClass="form-control" path="dateOne"
                                                                value="${selectObject.dateOne}"/>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <form:label path="dateTwo"
                                                            cssClass="control-label col-xs-3">to DATE(YYYY:mm:dd)</form:label>
                                                <div class="col-xs-6">
                                                    <form:input cssClass="form-control" path="dateTwo"
                                                                value="${selectObject.dateTwo}"/>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <input type="submit" id="selecttrain" class="btn btn-primary"
                                                               value="Save" onclick="return submitScheduleForm();"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </form:form>
                                </fieldset>


                            </div>
                        </div>
                    </div>
                </div>
            </div>











        </div>
    </div>


</div>
            <%@include file="/WEB-INF/pages/homenews.jsp" %>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script type="text/javascript">
                function submitEmployeeForm() {

                    // getting the employee form values
                    var name = $('#train_name').val().trim();
                    var places = $('#places').val();
                    if (name.length == 0) {
                        alert('Please enter name');
                        $('#train_name').focus();
                        return false;
                    }

                    if (places <= 0) {
                        alert('Please enter proper places');
                        $('#places').focus();
                        return false;
                    }
                    return true;
                };


                function submitStationForm() {

                    // getting the employee form values
                    var name = $('#station_name').val().trim();

                    if (name.length == 0) {
                        alert('Please enter name');
                        $('#station_name').focus();
                        return false;
                    }

                    return true;
                };

                function submitScheduleForm() {

                    // getting the employee form values
                    var name = $('#stationOne').val().trim();

                    if (name.length == 0) {
                        alert('Please enter name');
                        $('#stationOne').focus();
                        return false;
                    }

                    return true;
                };

            </script>






