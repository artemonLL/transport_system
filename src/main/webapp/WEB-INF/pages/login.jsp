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
    <div class="col-lg-12 mb-12 ">
    <form method="POST" action="${pageContext.request.contextPath}/login" class="form-signin">


        <div class="container-fluid">
            <div class="row">
                <div class="well center-block">
                        <div class="well-header">
                            <h3 class="text-center text-success"> Sing In </h3>
                            <hr>
                        </div>


        <div class="form-group ${error != null ? 'has-error' : ''}">


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon">
                                <i class="glyphicon glyphicon-user"></i>
                            </div>
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
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

            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row widget">
                <div class="col-md-12 col-xs-12 col-sm-12">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
 <h4 class="text-center"><a href="${pageContext.request.contextPath}/registration">Registration</a></h4>
                </div>
            </div>
        </div>

                </div>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
<!-- /container -->
<%@include file="/WEB-INF/pages/homenews.jsp" %>



