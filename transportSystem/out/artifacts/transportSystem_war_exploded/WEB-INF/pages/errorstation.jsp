<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <!-- Page Content -->


    <div class="container">


        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 portfolio-item">
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 portfolio-item">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title">

                            STATION IS ALREADY EXISTS

                        </h4>
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                            <tr>


                                <th>Station</th>

                            </tr>
                            </thead>

                            <tr>
                                <td>${station.station_name}</td>
                            </tr>
                        </table>
                        <a href="<c:url value="/admin" />" class="btn btn-primary">RETURN to admin page</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 portfolio-item">
            </div>
        </div>
    </div>


    </div>
    </div>

    </div>
</section>


<%@include file="/WEB-INF/pages/footer.jsp" %>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>