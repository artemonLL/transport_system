<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 25.02.2018
  Time: 6:30
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/pages/header.jsp"%>

<section>
    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-6 col-sm-6 portfolio-item">
                <div class="card h-100">

                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">Add Train</a>


                            <fieldset>







                                <form:form id="regForm" modelAttribute="train" action="registerTrain" method="post">

                                    <table align="center">
                                        <tr>
                                            <td>
                                                <form:label path="train_nomber">Train Nomber</form:label>
                                            </td>
                                            <td>

                                                <form:input path="train_nomber" name="train_nomber" id="train_nomber" />

                                            </td>
                                        </tr>
                                        <tr>

                                            <td>

                                                <form:label path="places">places</form:label>

                                            </td>

                                            <td>

                                                <form:input path="places" name="places" id="places" />

                                            </td>

                                        </tr>
                                        <tr>
                                            <td></td>

                                            <td>

                                                <form:button id="admin" name="admin">Register</form:button>

                                            </td>

                                        </tr>



                                    </table>

                                </form:form>



                            </fieldset>
                    </div>
                </div>
            </div>

            <div class="col-lg-6 col-sm-6 portfolio-item">
                <div class="card h-100">
                    <div class="card-body">
                        <h4 class="card-title">
                            <a href="#">Train List</a>




                        </h4>
                        <table class="table table-striped table-hover table-bordered">

                            <thead>
                            <tr>

                                <th>Train Nomber</th>
                                <th>Free Plases</th>


                            </tr>
                            </thead>


                            <c:forEach items="${trainList}" var="onetrain">
                                <tr>
                                    <td>${onetrain.train_nomber}</td>
                                    <td>${onetrain.places}</td>
                                </tr>
                            </c:forEach>




                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

        <div class="container">
            <!-- Marketing Icons Section -->
            <div class="row">
                <div class="col-lg-12 mb-12">
                    <div class="card h-100">
                        <h4 class="card-header">AddTrain</h4>
                        <div class="card-body">






                            <div class="container">
                                <section class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Panel heading</h3>
                                    </div>
                                    <div class="panel-body">
                                    </div>
                                    <!-- panel-body // -->
                                </section>
                                <!-- panel// -->
                            </div>
                            <!-- container// -->







                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-primary">Learn More</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



                <div class="container">

                <!-- Marketing Icons Section -->
                <div class="row">
                    <div class="col-lg-12 mb-12">
                        <div class="card h-100">
                            <h4 class="card-header">AddStation</h4>
                            <div class="card-body">

                                adminnnn
                            </div>
                            <div class="card-footer">
                                <a href="#" class="btn btn-primary">Learn More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</section>


<%@include file="/WEB-INF/pages/footer.jsp"%>






