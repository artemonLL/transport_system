<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 18.02.2018
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

    <style>

        #onhoverr a:hover {
            color: #a3deff;
        }
        #onhoverr {
            color: grey;
        }
        .navbar-brand:hover, .navbar-brand:focus {
            color: #a3deff;
        }


    </style>

    <style>
        .bootstrap-select.show>.dropdown-menu>.dropdown-menu {
            display: block;
        }

        .bootstrap-select > .dropdown-menu > .dropdown-menu li.hidden{
            display:none;
        }

        .bootstrap-select > .dropdown-menu > .dropdown-menu li a{
            display: block;
            width: 100%;
            padding: 3px 1.5rem;
            clear: both;
            font-weight: 400;
            color: #292b2c;
            text-align: inherit;
            white-space: nowrap;
            background: 0 0;
            border: 0;
        }
    </style>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Any Railways</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" /> " rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/modern-business.css"/> " rel="stylesheet">

</head>
<body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>


<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">

    <div class="container">


        <a class="navbar-brand"  href="<c:url value="/" />">Any railways</a>


        <a  class="navbar-brand"   href="<c:url value="/stationlist" />">Train schedule</a>




        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="container">



        </div>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">



                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                        <a class="nav-link" >${pageContext.request.userPrincipal.name} <a  onclick="document.forms['logoutForm'].submit()"></a>

                </li>

                        <li class="nav-item">
                            <form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/logout">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>

           <a  class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>

                        </li>


                        <li id="onhover" class="nav-item">
                            <a class="nav-link" href="<c:url value="/tickets" />"> Tickets </a>
                        </li>


                    </c:if>




                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li id="onhoverr" class="nav-item">
                        <a class="nav-link" href="<c:url value="/registration" />"> Registration </a>
                    </li>
                    <li id="onhoverr" class="nav-item" >
                        <a  class="nav-link" href="<c:url value="/login" />">SingIn</a>
                    </li>
                </c:if>



                <c:if test="${not empty pageContext.request.userPrincipal}">

                    <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">

                        <li id="onhoverr" class="nav-item">
                            <a   class="nav-link"  href="<c:url value="/admin" />"> Admin </a>
                        </li>

                    </c:if>

                </c:if>


            </ul>
        </div>

    </div>

</nav>
