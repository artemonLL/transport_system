
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="/WEB-INF/pages/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>

<section >

        <div class="container">

            <div class="container">
                <!-- Marketing Icons Section -->
                <div class="row">
                    <div class="col-lg-10 col-sm-10 portfolio-item">
                        <div class="card h-100">
                            <div class="card-body">
                                <h4 class="card-title">
                                    <a href="#">EDIT SCHEDULE</a>
                                </h4>
                                <fieldset>

                                    <form:form id="scheduleFormm" cssClass="form-horizontal" modelAttribute="carcass"
                                               method="post" action="changeschedule">
                                    <form>
                                            <form:hidden path="new_id" value="${schedule.schedule_id}"/>
                                <table class="table table-striped table-hover table-bordered" >

                                        <tr>
                                            <td>Station</td>
                                            <td>${schedule.station.station_name}</td>

                                        </tr>
                                        <tr>
                                            <td>Train</td>
                                            <td>${schedule.train.train_number}</td>

                                        </tr>
                                    <tr>
                                        <td>Date/Time</td>
                                        <td> <form:input id="datetimepicker" cssClass="form-control" path="date_time"
                                                         value="${schedule.time_msk}"/></td>
                                    </tr>
                                </table>
                                        <input type="submit" id="changeschedule" class="btn btn-primary"
                                               value="Save" onclick="return submitt();"/>
                                    </form>
                                        </form:form>
                                </fieldset>
                            </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
</section>

<script>
    function submitt() {
        return true;
    };
    jQuery('#datetimepicker2').datetimepicker(
        {
            format: 'Y-m-d h:i:s',
            defaultTime: '00:00:00'
        });
</script>

<%@include file="/WEB-INF/pages/footer.jsp" %>



