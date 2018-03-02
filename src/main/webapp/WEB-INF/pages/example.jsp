<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 01.03.2018
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<sf:form
        method="POST"
        modelAttribute="user"
        class="form-horizontal"
        id="registerForm"
>
    <div class="form-group">
        <label class="form-title1122">Имя</label>
        <div class="col-md-8">
            <sf:input type="text" path="firstName" class="form-control"
                      placeholder="Иван"/>
            <sf:errors path="firstName" cssClass="help-block" element="em"/>
        </div>
    </div>

    <div class="form-group">
        <label class="form-title1122">Фамилия</label>
        <div class="col-md-8">
            <sf:input type="text" path="lastName" class="form-control"
                      placeholder="Пупкин"/>
            <sf:errors path="lastName" cssClass="help-block" element="em"/>
        </div>
    </div>

    <div class="form-group">
        <label class="form-title1122">Email</label>
        <div class="col-md-8">
            <sf:input type="text" path="email" class="form-control"
                      placeholder="abc@zyx.com"/>
            <sf:errors path="email" cssClass="help-block" element="em"/>
        </div>
    </div>

    <div class="form-group">
        <label class="form-title1122">Телефон</label>
        <div class="col-md-8">
            <sf:input type="text" path="contactNumber" class="form-control"
                      placeholder="XXXXXXXXXX" maxlength="12"/>
            <sf:errors path="contactNumber" cssClass="help-block" element="em"/>
        </div>
    </div>

    <div class="form-group">
        <label class="form-title1122">Пароль</label>
        <div class="col-md-8">
            <sf:input type="password" path="password" class="form-control"
                      placeholder="Пароль"/>
            <sf:errors path="password" cssClass="help-block" element="em"/>
        </div>
    </div>

    <div class="form-group">
        <label class="form-title1122">Ведите пароль еще раз</label>
        <div class="col-md-8">
            <sf:input type="password" path="confirmPassword" class="form-control"
                      placeholder="Повторите пароль"/>
            <sf:errors path="confirmPassword" cssClass="help-block" element="em"/>
        </div>
    </div>


    <div class="form-group">
        <label class="form-title1122">Выберете цель регистрации</label>
        <div class="col-md-8">
            <label class="radio-inline">
                <sf:radiobutton path="role" value="USER" checked="checked"/>Покупатель
            </label>
                <%--<label class="radio-inline">--%>
                <%--<sf:radiobutton path="role" value="SUPPLIER"/>Поставщик--%>
                <%--</label>--%>
        </div>
    </div>

    <div class="form-group">
        <div class="col-md-offset-4 col-md-8">
            <button type="submit" name="_eventId_billing" class="submit-button1122">
                Далее - Адрес <span class="oi oi-chevron-right"></span>
            </button>
        </div>


</sf:form>