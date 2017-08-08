<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by ccy.
  User: ccy
  Date: 2017/8/6
  Time: 15:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- TODO 登录出现错误后， 保留用户名--%>
<html>
<head>
    <%@include file="header.jsp"%>
    <link href="/css/login.css" rel="stylesheet">
    <title>登录</title>
</head>
<body>
    <div class="container">
        <img src="/images/icon.jpg"/>
    </div>
    <div class="login-content">
        <div class="login-bg">

        </div>
        <div class="center-content">
            <div class="loginWrap">
                <h1>帐号登录</h1>
                <c:if test="${error == true}">
                    <p class="error_tip">帐号或者密码错误，请重新输入</p>
                </c:if>
                <form method="post" action="/account/login">
                    <div class="input_line">
                        <label class="input_label">用户名：</label>
                        <input class="form-control input_text " type="text" name="username" id="username" placeholder="6-18位字母数字组合">
                    </div>
                    <div class="input_line">
                        <label class="input_label">密码：</label>
                        <input class="form-control  input_text" type="password" name="password" id="password" placeholder="6-16位密码，区分大小写" />
                    </div>
                    <div class="input-line">
                        <div class="register_wrap">
                            <a class="register" href="/account/register">注册帐号</a>
                        </div>
                    </div>
                    <div>
                        <input class="btn btn-primary btn-lg input_submit" type="submit" value="登录">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
