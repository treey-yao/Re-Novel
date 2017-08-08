<%--
  Created by ccy.
  User: ccy
  Date: 2017/8/6
  Time: 20:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--TODO 完善用户信息界面--%>
<html>
<head>
    <%@include file="header.jsp" %>
    <title>用户信息</title>
</head>
<body>
<div class="container">
    <h1 style="height: 200px">用户信息</h1>
    <p>
        <div>用户名：${username}</div>
        <div>uid:${uid}</div>
        <div>用户密码: ****** </div>
        <div>salt: ${salt} </div>
    </p>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
