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
<style>
    em {
        font-style: normal;
        font-size: 130%;
        text-transform: uppercase;
    }
</style>
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
                            <a href="#">Choose You Train</a>

                                <fieldset>
                                    <form:form id="BuyRegisterForm" cssClass="form-horizontal"
                                               modelAttribute="buyticketform" method="post" action="buyticket">

                                        <form:select cssStyle="  border-radius: 15px;
      padding: 10px 10px;
      width: 100%;
      border: 1px solid grey;
      box-shadow: none;
      background: transparent;
      background-image: none;"  path="train_id" multiple="multiple" class="form-control">
                                            <c:forEach var="schedule" items="${scheduleList}">

                                                <option style="border-radius: 15px;
      padding: 15px;
      width: 97%;
      border: 1px solid grey;" value="${schedule.train.train_id}">Train &nbsp -> ${schedule.train.train_number}&nbsp &nbsp Station of departure->${schedule.station.station_name} &nbsp &nbsp  Time-> ${schedule.time_msk}</option>

                                            </c:forEach>

                                        </form:select>

                                        <form:hidden path="departDateTime" value="${newselectform.dateOne}"/>

                                        <form:hidden path="departure_station_id" value="${newselectform.stationOne}"/>

                                        <form:hidden path="arrival_station_id" value="${newselectform.stationTwo}"/>


                                        <c:if test="${pageContext.request.userPrincipal.name != null}">

                      <input type="submit" id="buyticket" class="btn btn-primary"
                             value="Buy Ticket!" onclick="return submitBuy();"/>


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
                                            <div  cssClass="control-label col-xs-3">Station of departure</div>

                                            <div class="col-xs-6">

                                                <form:select   path="stationOne" class="form-control" >
                                                    <option value="" >Select</option>

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
                                                    <option value="" >Select</option>

                                                    <c:forEach var="onestation" items="${stationList}" >
                                                        <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                    </c:forEach>


                                                </form:select>



                                            </div>
                                        </div>
                                        <div class="form-group">
     <form:label path="dateOne"
            cssClass="control-label col-xs-3">from Time</form:label>
                                            <div class="col-xs-6">
                <form:input  cssClass="form-control" path="dateOne" type="text" id="datetimepicker2" />

                                            </div>
                                        </div>
                                        <div class="form-group">
      <form:label path="dateTwo" cssClass="control-label col-xs-3">to Time</form:label>
                                            <div class="col-xs-6">
       <form:input  cssClass="form-control" path="dateTwo" type="text" id="datetimepicker" />
                                            </div>
                                        </div>





                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-4">
                                                </div>
                                                <div class="col-xs-4">
                                                    <input type="submit" id="selecttrain" class="btn btn-primary"
                                                           value="Find" onclick="return submitSearch();"/>
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


<script type="text/javascript">
        jQuery('#datetimepicker').datetimepicker(
            {
                format: 'Y-m-d H:i:s',

                defaultTime: '00:00:00'
            });
    jQuery('#datetimepicker2').datetimepicker(
        {
            format: 'Y-m-d H:i:s',
            defaultTime: '00:00:00'
        });

    function submitBuy() {
        var train= $('#train_id').val();
        if (train <= 0) {
            alert('Please select TRAIN');
            $('#train_id').focus();
            return false;
        }
        return true;
    };
    function submitSearch() {
        var stationo = $('#stationTwo').val().trim();
        var stationt = $('#stationOne').val().trim();

        var one =document.getElementById("datetimepicker").value;
        var two =document.getElementById("datetimepicker2").value;
        var date = $('#dateForSelect').val();

        if (stationt.length == 0) {
            alert('Please select Departure Station');
            $('#stationOne').focus();
            return false;
        }
        if (stationo.length == 0) {
            alert('Please select Arrival Station');
            $('#stationTwo').focus();
            return false;
        }

        if (one.length == 0) {
            alert('Please enter  Time');
            return false;
        }
        if (two.length == 0) {
            alert('Please enter Time');
            return false;
        }
        if (date <= 0) {
            alert('Please enter DATE');
            $('#dateForSelect').focus();
            return false;
        }
        return true;
    };
</script>
        <%@include file="/WEB-INF/pages/homenews.jsp" %>



