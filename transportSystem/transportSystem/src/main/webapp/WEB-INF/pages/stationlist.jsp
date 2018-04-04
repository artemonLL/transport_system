<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 28.02.2018
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <!-- Page Content -->


    <div class="container">


        <div class="container" onload="goaction();">

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

                                    <th>Station Name</th>
                                    <th>Trains Schedule</th>

                                </tr>
                                </thead>
                                <c:forEach items="${stationList}" var="station">
                                    <tr>
                                        <td>${station.station_name}</td>
                                        <td>
                                            <a href="<c:url value="/stationschedule/${station.station_id}" />" class="btn btn-primary">Trains</a>
                                        </td>
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
</section>


<%@include file="/WEB-INF/pages/footer.jsp" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
