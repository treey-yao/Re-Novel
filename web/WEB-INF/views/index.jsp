<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by ccy.
  User: ccy
  Date: 2017/8/6
  Time: 20:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="header.jsp" %>
    <title>首页</title>
</head>
<body>
    <div class="container">
        <h1>这里是首页</h1>
        <p>
            <a href="/profile">这里是户个人信息，登录后可以访问</a>
        </p>
        <p>
            <a href="/subpage">这里是不需要登录的子界面</a>
        </p>
        <p>
            <a href="/account/login">这里是登录注册位置，目前完成的唯一功能</a>
        </p>
        <c:if test="${login == true}">
            <p><a href="/account/logout">退出登录</a></p>
        </c:if>
    </div>
<%@include file="footer.jsp" %>
</body>
</html>
