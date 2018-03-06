<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
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
                                    <form:form id="TicketRegisterForm" cssClass="form-horizontal"
                                   modelAttribute="ticket"
                                               method="post" action="buyticketadd">

                                        <div class="form-group">
                                            <div cssClass="control-label col-xs-3">Departure Station</div>

                                            <div class="col-xs-6">

                     <form:select path="departure_station_id.station_id" class="form-control">
                             <option value="${scheduleList.get(1).station.station_id}">Select</option>

                          <c:forEach var="schedule" items="${scheduleList}">
           <option value="${schedule.station.station_id}"> ${schedule.station.station_name} </option>
                                                    </c:forEach>


                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div cssClass="control-label col-xs-3">Arrival Station</div>

                                            <div class="col-xs-6">

                            <form:select path="arrival_station_id.station_id" class="form-control">
                                  <option value="${scheduleList.get(0).station.station_id}">Select</option>

                                <c:forEach var="schedule" items="${scheduleList}">
                  <option value="${schedule.station.station_id}"> ${schedule.station.station_name} </option>
                                </c:forEach>
                            </form:select>



                                            </div>
                                        </div>



                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-4">
                                                </div>
                                                <div class="col-xs-4">
                                                    <input type="submit" id="buyticketadd" class="btn btn-primary"
                                                           value="Find" onclick="return true"/>
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
                <div class="col-lg-1 col-sm-1 col-md-1 portfolio-item" style="background-color: #ced4da">
                </div>
            </div>
        </div>

    </div>
    </div>


    </div>

    </fieldset>


    </h4>
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



        return true;
    };
</script>


<%@include file="/WEB-INF/pages/footer.jsp" %>
