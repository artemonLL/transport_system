<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 25.02.2018
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

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


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/pages/header.jsp"%>
<section>
    <!-- Page Content -->
    <div class="container" >

        <div class="col-lg-12 mb-12 ">

            <!------ Include the above in your HEAD tag ---------->

            <form action="#" name="myForm" method="post" onsubmit="return(validate());">
                <div class="container-fluid">
                    <div class="row">
                        <div class="well center-block">
                            <div class="well-header">
                                <h3 class="text-center text-success"> Sing In </h3>
                                <hr>
                            </div>

                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </div>
                                            <input type="text" placeholder="First Name" name="txtfname" class="form-control">

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
                                            <input type="password" minlength="8" maxlength="20" placeholder="Password" name="txtpass" class="form-control">
                                        </div>
                                    </div>
                                </div>
                            </div>









                            <div class="row widget">
                                <div class="col-md-12 col-xs-12 col-sm-12">
                                    <button class="btn btn-warning btn-block"> Submit </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </form>


        </div>
    </div>
</section>






<%@include file="/WEB-INF/pages/footer.jsp"%>