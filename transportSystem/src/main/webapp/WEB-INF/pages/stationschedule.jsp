<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp" %>

<section style="min-height: 470px;">
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-sm-10 portfolio-item">
                    <div class="card h-100">
                        <div class="card-body">
                            <h4 class="card-title">
                            </h4>
                            <table class="table table-striped table-hover table-bordered">
                                <thead>
                                <tr>
                                    <th>Time</th>
                                    <th>Train</th>
                                </tr>
                                </thead>

                                <c:forEach items="${scheduleList}" var="schedule">
                                    <tr>
                                        <td>${schedule.time_msk}</td>
                                        <td>${schedule.train.train_number}</td>

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


