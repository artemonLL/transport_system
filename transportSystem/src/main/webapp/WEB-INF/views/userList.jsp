<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 18.02.2018
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserLIST</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>user_id</th>
        <th>first_name</th>
        <th>password</th>
        <th>email</th>
        <th>date_birth</th>
        <th>last_name</th>
    </tr>
    </thead>
    <thead>
    <tr>
        <td>${user.user_id}</td>
        <td>${user.first_name}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
        <td>${user.date_birth}</td>
        <td>${user.last_name}</td>
    </tr>
    </thead>
</table>
</body>
</html>
