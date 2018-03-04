<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 26.02.2018
  Time: 5:26
  To change this template use File | Settings | File Templates.
--%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <!-- Page Content -->

    <div class="container">


    </div>

    <div class="container">


        <div class="container">

            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">

                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Add Shedule</a>


                                <fieldset>
                                    <form:form id="ScheduleRegisterForm" cssClass="form-horizontal"
                                               modelAttribute="schedule"
                                               method="post" action="saveschedule">
                                        <form>
                                            <!-- WAY nput-->
                                            <div class="form-group">
                                                <div class="control-label col-xs-3"><form:label
                                                        path="way_position">Way Position</form:label></div>
                                                <div class="col-xs-6">
                                                    <form:hidden path="schedule_id"
                                                                 value="${scheduleObject.schedule_id}"/>
                                                    <form:input cssClass="form-control" path="way_position"
                                                                value="${scheduleObject.way_position}"/>
                                                </div>


                                            <!-- TRAIN input-->

                                                <div class="form-group">
                                                    <div  cssClass="control-label col-xs-3">Station</div>

                                                    <div class="col-xs-6">

                                                        <form:select   path="train.train_id" class="form-control" >
                                                            <option value="${stationList.get(1).station_id}" >select</option>

                                                            <c:forEach var="onestation" items="${trainList}" >
                                                                <option value="${onestation.train_id}"> ${onestation.train_nomber} </option>
                                                            </c:forEach>


                                                        </form:select>



                                                    </div>
                                                </div>



                                                <!-- TRAIN input-->

                                                <div class="form-group">
                                                    <div  cssClass="control-label col-xs-3">Train</div>

                                                    <div class="col-xs-6">

                                                        <form:select   path="station.station_id" class="form-control" >
                                                            <option value="${stationList.get(1).station_id}" >select</option>

                                                            <c:forEach var="onestation" items="${stationList}" >
                                                                <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                            </c:forEach>
                                                        </form:select>
                                                    </div>
                                                </div>


                                                <!-- DATE input-->

                                            <div class="form-group">
                                                <form:label path="time_msk"
                                                            cssClass="control-label col-xs-3">DATE(YYYY:mm:dd)</form:label>
                                                <div class="col-xs-6">
                                                    <form:input cssClass="form-control" path="time_msk"
                                                                value=" "/>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <input type="submit" id="saveschedule" class="btn btn-primary"
                                                               value="Save" onclick="return submitScheduleForm();"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </form:form>
                                </fieldset>


                            </h4>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<c:url value="schedulelist" />"> Schedule List </a>

                            </h4>
                            <table class="table table-striped table-hover table-bordered">
                                <thead>
                                <tr>

                                    <th>Train</th>
                                    <th>Station</th>
                                    <th>Way position</th>
                                    <th>Date</th>

                                </tr>
                                </thead>


                                <c:forEach items="${scheduleList}" var="oneschedule" begin="0" step="1" end="5">
                                    <tr>
                                        <td>${oneschedule.train.train_nomber}</td>
                                        <td>${oneschedule.station.station_name}</td>
                                        <td>${oneschedule.way_position}</td>
                                        <td>${oneschedule.time_msk}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- TRAIN///////////////////////////////////////////////////////////////-->


        <div class="container">

            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">

                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Add Train</a>


                                <fieldset>

         <form:form id="TrainRegisterForm" cssClass="form-horizontal" modelAttribute="train"
                                               method="post" action="savetrain">
                                        <form>

                                            <!-- Text input-->
                                            <div class="form-group">
              <div class="control-label col-xs-3"><form:label  path="train_nomber">Train Num</form:label></div>
                                                <div class="col-xs-6">
                               <form:hidden path="train_id" value="${trainObject.train_id}"/>
                                                    <form:input cssClass="form-control" path="train_nomber"
                                                                value="${trainObject.train_nomber}"/>
                                                </div>
                                            </div>










                                            <!-- Text input-->
                                            <div class="form-group">
                                                <form:label path="places"
                                                            cssClass="control-label col-xs-3">Places</form:label>
                                                <div class="col-xs-6">
                                                    <form:input cssClass="form-control" path="places"
                                                                value="${trainObject.places}"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <input type="submit" id="savetrain" class="btn btn-primary"
                                                               value="Save" onclick="return submitTrainForm();"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>


                                    </form:form>
                                </fieldset>
                            </h4>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<c:url value="trainlist" />"> Tains </a>

                            </h4>
                            <table class="table table-striped table-hover table-bordered">
                                <thead>
                                <tr>

                                    <th>Train Nomber</th>
                                    <th>Free Places</th>
                                    <th>train ID</th>

                                </tr>
                                </thead>


                                <c:forEach items="${trainList}" var="onetrain" begin="0" step="1" end="3">
                                    <tr>
                                        <td>${onetrain.train_nomber}</td>
                                        <td>${onetrain.places}</td>
                                        <td>${onetrain.train_id}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Station///////////////////////////////////////////////////////////////-->

        <div class="container">

            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">

                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="#">Add Station</a>


                                <fieldset>

                                    <form:form id="StationRegisterForm" cssClass="form-horizontal"
                                               modelAttribute="station" method="post" action="savestation">
                                        <form>


                                            <!-- Text input-->
                                            <div class="form-group">
                                                <div class="control-label col-xs-3"><form:label
                                                        path="station_name">Station Name</form:label></div>
                                                <div class="col-xs-6">
                                                    <form:hidden path="station_id" value="${stationObject.station_id}"/>
                                                    <form:input cssClass="form-control" path="station_name"
                                                                value="${stationObject.station_name}"/>
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <input type="submit" id="saveStation" class="btn btn-primary"
                                                               value="Save" onclick="return submitStationForm();"/>
                                                    </div>
                                                    <div class="col-xs-4">
                                                    </div>
                                                </div>
                                            </div>
                                        </form>


                                    </form:form>
                                </fieldset>
                            </h4>
                        </div>
                    </div>
                </div>

                <div class="col-lg-6 col-sm-6 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<c:url value="stationlist" />"> Stations </a>

                            </h4>
                            <table class="table table-striped table-hover table-bordered">
                                <thead>
                                <tr>

                                    <th>Station Name</th>
                                    <th>Station ID</th>

                                </tr>
                                </thead>
                                <c:forEach items="${stationList}" var="station" begin="0" step="1" end="3">
                                    <tr>
                                        <td>${station.station_name}</td>
                                        <td>${station.station_id}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
</section>







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
        var name = $('#way_position').val().trim();

        if (name.length == 0) {
            alert('Please enter name');
            $('#way_position').focus();
            return false;
        }

        return true;
    };
</script>





<%@include file="/WEB-INF/pages/footer.jsp" %>



