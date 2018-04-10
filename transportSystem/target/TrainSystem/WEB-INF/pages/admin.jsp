
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<section>
    <style>
        .scrollit {
            overflow: scroll;
            height: 23em;
        }
        .scrollit2 {
            overflow: scroll;
            height: 15em;
        }
    </style>
    <div class="container">
    </div>
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-sm-6 col-md-6 portfolio-item">
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
                                                <div class="control-label col-xs-3">
                                                    <div class="col-xs-6">
                                                        <form:hidden path="way_position"
                                                                     value="1"/>

                                                        <form:hidden path="schedule_id"
                                                                     value="${scheduleObject.schedule_id}"/>


                                                    </div>


                                                    <!-- TRAIN input-->

                                                    <div class="form-group">
                                                        <div cssClass="control-label col-xs-3">Train</div>

                                                        <div class="col-xs-6">

                                                            <form:select id="oneid" path="train.train_id" class="form-control">
                                                                <option value="">select
                                                                </option>

                                                                <c:forEach var="onetrain" items="${trainList}">
                                                                    <option value="${onetrain.train_id}"> ${onetrain.train_number} </option>
                                                                </c:forEach>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <!-- TRAIN input-->
                                                    <div class="form-group">
                                                        <div cssClass="control-label col-xs-3">Station</div>

                                                        <div class="col-xs-6">

                                                            <form:select id="twoid" path="station.station_id" class="form-control">
                                                                <option value="">select
                                                                </option>

                                                                <c:forEach var="onestation" items="${stationList}">
                                                                    <option value="${onestation.station_id}"> ${onestation.station_name} </option>
                                                                </c:forEach>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <!-- DATE input-->

                                                    <div class="form-group">
                                                        <div cssClass="control-label col-xs-3">Date</div>
                                                        <div class="col-xs-6">
                                                            <form:input path="time_msk"
                                                                        class="form-control"
                                                                        id="datetimepicker"></form:input>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="row">
                                                            <div class="col-xs-4">
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <input type="submit" id="saveschedule"
                                                                       class="btn btn-primary"
                                                                       value="Save Schedule"
                                                                       onclick="return submitScheduleForm();"/>
                                                            </div>
                                                            <div class="col-xs-4">
                                                            </div>
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

                <div class="col-lg-6 col-sm-6 col-md-6 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">
                                <a href="<c:url value="schedulelist" />"> Schedule List </a>

                            </h4>
                            <div class="scrollit">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>

                                        <th>Train</th>
                                        <th>Station</th>
                                        <th>Date</th>

                                    </tr>
                                    </thead>
                                    <c:forEach items="${scheduleList}" var="oneschedule">
                                        <tr class="fixed">
                                            <td>${oneschedule.train.train_number}</td>
                                            <td>${oneschedule.station.station_name}</td>
                                            <td>${oneschedule.time_msk}</td>

                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
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

                                            <!-- train_number-->
                                            <div class="form-group">
                                                <div class="control-label col-xs-3"><form:label
                                                        path="train_number">Train Num</form:label></div>
                                                <div class="col-xs-6">
                                                    <form:hidden path="train_id" value="${trainObject.train_id}"/>
                                                    <form:input cssClass="form-control" path="train_number"
                                                                value="${trainObject.train_number}"/>
                                                </div>
                                            </div>

                                            <!-- places-->
                                            <div class="form-group">
                                                <form:label path="places"
                                                            cssClass="control-label col-xs-3">Places</form:label>
                                                <div class="col-xs-6">
                                                    <form:input type="number" cssClass="form-control" path="places"
                                                                value=""/>

                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-xs-4">
                                                    </div>
                                                    <div class="col-xs-4">
                                                        <input type="submit" id="savetrain" class="btn btn-primary"
                                                               value="Save Train" onclick="return submitTrainForm();"/>
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
                            <div class="scrollit2">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>

                                        <th>Train Number</th>
                                        <th>Free Places</th>

                                    </tr>
                                    </thead>


                                    <c:forEach items="${trainList}" var="onetrain">
                                        <tr>
                                            <td>${onetrain.train_number}</td>
                                            <td>${onetrain.places}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Station///////////////////////////////////////////////////////////////-->
        <c:if test="${errorTrain == true}">
            <div class="container">

                <!-- Marketing Icons Section -->
                <div class="row">
                    <div class="col-lg-6 col-sm-6 portfolio-item">
                        HEEEEY
                    </div>
                </div>
            </div>
        </c:if>


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
                                                               value="Save Station"
                                                               onclick="return submitStationForm();"/>
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
                            <div class="scrollit2">
                                <table class="table table-striped table-hover table-bordered">
                                    <thead>
                                    <tr>

                                        <th>Station Name</th>

                                    </tr>
                                    </thead>
                                    <c:forEach items="${stationList}" var="station">
                                        <tr>
                                            <td>${station.station_name}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    function submitTrainForm() {
        // getting the employee form values
        var name = $('#train_number').val().trim();
        var places = $('#places').val();
        if (name.length == 0) {
            alert('Please enter Train num');
            $('#train_number').focus();
            return false;
        }

        if (places <= 0) {
            alert('Please enter places');
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

        var train =document.getElementById("oneid").value;
        var station =document.getElementById("twoid").value;
        var one =document.getElementById("datetimepicker").value;

        if (train.length === 0) {
            alert('Please select Train');
            $('#stationOne').focus();
            return false;
        }
        if (station.length === 0) {
            alert('Please select Staion');
            $('#stationTwo').focus();
            return false;
        }


        if (one.length == 0) {
            alert('Please enter DATE');
            return false;
        }
        return true;
    };
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
</script>
<%@include file="/WEB-INF/pages/footer.jsp" %>



