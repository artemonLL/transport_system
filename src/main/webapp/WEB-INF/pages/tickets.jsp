<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 04.03.2018
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <!-- Page Content -->


    <div class="container">


        <div class="container">

            <!-- Marketing Icons Section -->
            <div class="row">


                <div class="col-lg-10 col-sm-10 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">


                            </h4>
                            <table class="table table-striped table-hover table-bordered">
                                <thead>
                                <tr>

                                    <th>Departure_station</th>
                                    <th>Arrival station</th>
                                    <th>Train Number</th>

                                </tr>
                                </thead>


                                <c:forEach items="${ticketList}" var="ticket">
                                    <tr>
                                        <td>${ticket.departure_station_id.station_name}</td>
                                        <td>${ticket.arrival_station_id.station_name}</td>
                                        <td> ${ticket.train_id.train_number} </td>


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
