<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 06.03.2018
  Time: 4:35
  To change this template use File | Settings | File Templates.
--%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>





<%@include file="/WEB-INF/pages/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

<section >
    <header >

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
                        <p>railways</p>
                    </div>
                </div>
                <!-- Slide Two - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>              </h3>
                        <p>railways</p>
                    </div>
                </div>
                <!-- Slide Three - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('http://i50.tinypic.com/2d9cnyb.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>             </h3>
                        <p>railways</p>
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
</section>


<section>




    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-8 col-sm-8  col-md-8 portfolio-item">
                <div class="card h-100">

                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">Add Shedule</a>

                                <fieldset>
              <form:form id="BuyRegisterForm" cssClass="form-horizontal" modelAttribute="buyticketform"  method="post" action="buyticket">

                                        <form:select   path="train_id"  multiple="multiple" class="form-control" >
                                            <c:forEach var="schedule" items="${scheduleList}" >

   <option value="${schedule.train.train_id}">train num-<h3>${schedule.train.train_number}</h3>    departure station-${schedule.station.station_name}
            time-${schedule.time_msk}</option>

                                            </c:forEach>

                                        </form:select>


                                        <form:hidden path="departure_station_id"   value="${newselectform.stationOne}"/>

                                        <form:hidden path="arrival_station_id"   value="${newselectform.stationTwo}"/>


                  <c:if test="${pageContext.request.userPrincipal.name != null}">

                      <input type="submit" id="buyticket" class="btn btn-primary"
                             value="Buy Ticket!" onclick="return true;"/>


                  </c:if>

                  <c:if test="${pageContext.request.userPrincipal.name == null}">

                      <a href="<c:url value="/login" />" class="btn btn-primary">Sing IN and Buy ticket!</a>


                  </c:if>









                                    </form:form>



                            </fieldset>


                        </h4>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-sm-4 col-md-4 portfolio-item">
                <div class="card h-100">
                    <div class="card-body">



                        <div class="row">
                            <div class="col-lg-12 mb-12">

                                <fieldset>
                                    <form:form id="SelectRegisterForm" cssClass="form-horizontal" modelAttribute="selectform"
                                               method="post" action="selecttrain">

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




                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-4">
                                                </div>
                                                <div class="col-xs-4">
                                                    <input type="submit" id="selecttrain" class="btn btn-primary"
                                                           value="Find" onclick="return submitScheduleForm();"/>
                                                </div>
                                                <div class="col-xs-4">
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </fieldset>


                            </div>
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


        <script>
            $(document).ready(function () {
                $('.selectpicker').selectpicker();
            });
        </script>


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
                var places = $('#places').val();
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
                var name1 = $('#stationOne').val().trim();
                var name2 = $('#stationTwo').val().trim();
                var date = $('#dateForSelect').val();
                var time1 = $('#dateOne').val();
                var tim2e = $('#dateTwo').val();
                if (name1.length == 0) {
                    alert('Please enter station');
                    $('#stationOne').focus();
                    return false;
                }
                if (name2.length == 0) {
                    $('#stationOne').focus();
                    return false;}
                if (validate_date(date)) {
                    return false; }


                return true;
            };




            function validate_time(value)
            {
                var arrD = value.split(":");
                if(arrD[0]==0)return false;
                if(arrD[1]==0)return false;
            };

        </script>





        <%@include file="/WEB-INF/pages/homenews.jsp" %>



