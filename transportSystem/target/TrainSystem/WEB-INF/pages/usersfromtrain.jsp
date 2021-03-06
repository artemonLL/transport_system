<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section>
    <!-- Page Content -->


    <div class="container" style="min-height: 470px;">


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

                                    <th>first_name</th>
                                    <th>last_name</th>

                                </tr>
                                </thead>


                                <c:forEach items="${userList}" var="user">
                                    <tr>
                                        <td>${user.first_name}</td>
                                        <td>${user.last_name}</td>
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
