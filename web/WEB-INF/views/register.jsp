<!DOCTYPE html>
<html lang="zh-CN">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <%@include file="header.jsp"%>
    <title>测试丫</title>
    <link href="/css/register.css" rel="stylesheet">
</head>
<body>
    <div class="topInfo">
        <label  class="title">账号注册</label>
        <img src="/images/icon.jpg" alt="">
        <label class="login">已有帐号？去<a href="">登录</a></label>
    </div>
    <%-- TODO 验证码错误时，给予提示--%>
    <div class="reg_bg">
        <form method="post">
            <div class="input_line">
                <label class="input_label">用户名：</label>
                <input class="form-control input_text " type="text" name="username" id="username" placeholder="6-18位字母数字组合">
                <label class="input_tip" type="text" id="username_tip"><i class="fa fa-plus-square-o" aria-hidden="true"></i>用户名格式错误</label>
                <label class="input_tip" type="text" id="username_repeat"><i class="fa fa-chain-broken" aria-hidden="true"></i>用户名已经被使用</label>
                <label class="input_tip" type="text" id="username_success"><i class="fa fa-check" aria-hidden="true"></i>用户名可以使用</label>
            </div>
            <div class="input_line">
                <label class="input_label">密码：</label>
                <input class="form-control  input_text" type="password" name="password" id="password" placeholder="6-16位密码，区分大小写" />
                <label class="input_tip" type="text" id="password_tip">密码长度不对</label>
            </div>
            <div class="input_line">
                <label class="input_label">确认密码：</label>
                <input class="form-control  input_text" type="password" name="rePassword" id="rePassword" placeholder="再次输入密码" />
                <label class="input_tip" type="text" id="re_password_tip">密码不一致</label>
            </div>
            <div class="input_line">
                <label class="input_label">验证码：</label>
                <input class="form-control  input_text" type="text" name="captcha" id="captcha"  placeholder="输入下面图片中的数字" />
                <label class="input_tip" type="text" id="captcha_tip">验证码长度不对</label>
            </div>
            <div class="captcha">
                <label class="input_label"></label>
                <span id="loading">
                    <i class="fa fa-spinner fa-spin fa-2x fa-fw"></i>
                    <span class="sr-only">Loading...</span>
                </span>
                <span id="captcha_img">
                    <img src="/account/captcha.jpeg" alt="">
                </span>
                    <a href="" id="refresh"><i class="fa fa-refresh fa-2x fa-fw"/></a></i>
            </div>
            <div class="">
                <label class="input_label"></label>
                <input class="btn btn-primary btn-lg input_submit" type="submit" value="注册">
            </div>
            <div class="input_line">
                <label class="input_label"></label>
                <div class="terms switch">
                    <input type="checkbox" id="terms" checked>
                    <span>用户勾选即代表同意<a href="./terms">《服务条款》</a></span>
                </div>
            </div>
        </form>
    </div>
    <%@include file="footer.jsp"%>
    <script src="/js/account/register.js"></script>
</body>

</html>