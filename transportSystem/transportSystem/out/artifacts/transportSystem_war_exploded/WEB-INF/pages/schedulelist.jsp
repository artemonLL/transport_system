<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <script>
        function goaction() {
            var isaction=document.getElementById('actionn').value;

            if(isaction==='remove') {
                alert("Schedule was Deleted");
            }
            if(isaction==='update') {
                alert("Schedule was updated");
            }
        };
    </script>

    <!-- Page Content -->


    <div class="container">



        <input type="hidden" id="actionn" name="actionn" value="${action}">

        <body onload="goaction()">

        <div class="container">
            <!-- Marketing Icons Section -->
            <div class="row">


                <div class="col-lg-10 col-sm-10 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">


                            </h4>
                            <table class="table table-striped table-hover table-bordered" id="data">
                                <thead>
                                <tr>

                                    <th>Train</th>
                                    <th>Station</th>
                                    <th>Date</th>

                                </tr>
                                </thead>


                                <c:forEach items="${scheduleList}" var="oneschedule">
                                    <tr>
                                        <td>${oneschedule.train.train_number}</td>
                                        <td>${oneschedule.station.station_name}</td>
                                        <td>${oneschedule.time_msk}</td>
                                        <c:if test="${not empty pageContext.request.userPrincipal}">

                                            <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                                <td>
     <a href="<c:url value="/removeschedule/${oneschedule.schedule_id}" />" class="btn btn-primary">Delete Schedule</a>
                                                </td>
                                                <td>
   <a href="<c:url value="/editschedule/${oneschedule.schedule_id}" />" class="btn btn-primary">Edit Schedule date/time</a>
                                                </td>
                                            </c:if>

                                        </c:if>


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
    </div>

    </div>
    </body>

</section>



<%@include file="/WEB-INF/pages/footer.jsp" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
