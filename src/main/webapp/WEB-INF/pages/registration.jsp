<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/pages/header.jsp"%>

<style>

    .well
    {
        padding: 35px;
        padding-left: 30px;
        box-shadow: 0 0 10px #666666;
        margin: 4% auto 0;
        width: 450px;
    }

    body
    {
        background-color:  #dedede;
    }

    .input-group-addon
    {
        background-color: #ffde6c;
        color: #d17d00;
    }
</style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">

        <div class="container-fluid">
            <div class="row">
                <div class="well center-block">
                    <div class="well-header">
                        <h3 class="text-center text-success"> Registration </h3>
                        <hr>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-user"></i>
                                    </div>
        <spring:bind path="username">
            <div class="col-md-12 col-sm-12 col-xs-12" class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="login"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                    <spring:bind path="password">
            <div class="col-md-12 col-sm-12 col-xs-12"  class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                    <spring:bind path="confirmPassword">
            <div class="col-md-12 col-sm-12 col-xs-12"  class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12" >
                    <form:input type="text" path="first_name" class="form-control" placeholder="First name"></form:input>
                       </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12" >
                                        <form:input type="text" path="last_name" class="form-control" placeholder="Last name"></form:input>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12" >
                <form:input type="date" path="date_birth" class="form-control" placeholder="Date birth"></form:input>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row widget">
                        <div class="col-md-12 col-xs-12 col-sm-12">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>


    </form:form>
</div>



<%@include file="/WEB-INF/pages/footer.jsp" %>


