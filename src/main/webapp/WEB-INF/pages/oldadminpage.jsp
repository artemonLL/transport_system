<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 26.02.2018
  Time: 5:26
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

                                <form:form id="TrainRegisterForm" cssClass="form-horizontal" modelAttribute="train" method="post" action="savetrain">
                                    <form>



                                        <!-- Text input-->
                                        <div class="form-group">
                                            <div class="control-label col-xs-3"> <form:label path="train_nomber">Train Num</form:label> </div>
                                            <div class="col-xs-6">
                                                <form:hidden path="train_id" value="${trainObject.train_id}"/>
                                                <form:input cssClass="form-control" path="train_nomber" value="${trainObject.train_nomber}"/>
                                            </div>
                                        </div>

                                        <!-- Text input-->
                                        <div class="form-group">
                                            <form:label path="places" cssClass="control-label col-xs-3">places</form:label>
                                            <div class="col-xs-6">
                                                <form:input cssClass="form-control" path="places" value="${trainObject.places}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-xs-4">
                                                </div>
                                                <div class="col-xs-4">
                                                    <input type="submit" id="savetrain" class="btn btn-primary" value="Save" onclick="return submitTrainForm();"/>
                                                </div>
                                                <div class="col-xs-4">
                                                </div>
                                            </div>
                                        </div>
                                    </form>


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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
    function submitEmployeeForm() {

        // getting the employee form values
        var name = $('#train_name').val().trim();
        var places = $('#places').val();
        if(name.length ==0) {
            alert('Please enter name');
            $('#train_name').focus();
            return false;
        }

        if(places <= 0) {
            alert('Please enter proper places');
            $('#places').focus();
            return false;
        }
        return true;
    };
</script>



