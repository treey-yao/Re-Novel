<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/16
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h1>register</h1>
    <c:if test="${hasError==true}">
        <p>注册信息有误，请重新填写</p>
        <c:out value="hhhhhhhhhhhhhhh"/>
    </c:if>
    <c:out value="${hasError}"/>
    <sf:form method="post" commandName="roleInfo" enctype="multipart/form-data">
        First Name:<sf:input  path="firstName"/><br/>
        <sf:errors path="firstName"/>
        Last Name: <sf:input  path="lastName"/><br/>
        UserName: <sf:input path="userName"/><br />
        PassWord: <sf:password  path="password"/><br/>
        <input type="file" name="profilePicture" accept="image/jpeg, image/png, image/gif" />
        <input type="submit" value="Register" />
    </sf:form>
</body>
</html>
