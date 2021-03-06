<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section style="min-height: 470px;">
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
                            <table class="table table-striped table-hover table-bordered" id="data">
                                <thead>
                                <tr>

                                    <th>Train Nomber</th>
                                    <th>Free Places</th>
                                    <th>Users</th>

                                </tr>
                                </thead>


                                <c:forEach items="${trainList}" var="onetrain">
                                    <tr>
                                        <td>${onetrain.train_number}</td>
                                        <td>${onetrain.places}</td>
                                        <td>

     <a href="<c:url value="/usersfromtrain/${onetrain.train_id}" />" class="btn btn-primary">Passengers</a>
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
