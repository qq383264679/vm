<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>在线购物系统</title>

	<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

.header {
	margin: 0 auto;
	height: 120px;
	width: 100%;
	background-color: red;
	background-image: url(sys_images/main_title.jpg);
}

.header_right {
	height: 30px;
	width: 250px;
	float: right;
	line-height: 30px;
	margin-top: 45px;
}

.header_right a {
	font-weight: 600;
	color: white;
	text-decoration: none;
}

.content {
	margin: 0 auto;
	height: 500px;
	widows: 100%; <!--
	background-color: yellow;
	-->
}

.content_c {
	margin: 0 auto;
	height: 150px;
	width: 100%; <!--
	background-color: blue;
	-->
}

.footer {
	margin: 0 auto;
	margin-top: 55px;
	height: 100px;
	width: 100%;
	background-color: rgb(52, 56, 68);
}

.footer_div {
	width: 360px;
	height: 50px;
	margin: 0 auto;
}

.login {
	width: 460px;
	height: 160px;
	border: 1px solid #ccf;
	margin: 0 auto;
	margin-top: -60px;
	text-align: center;
}

.title {
	width: 460px;
	height: 40px;
	background: #ccc;
}
</style>
</head>
<body>
	<div class="header">
		<div class="header_right">
			<a href="productAction_toMainView">主页</a> <span>|</span> <a
				href="lognAction_toLognView"> <s:if test="#session.user == null">登录 </s:if>
				<s:else>注销</s:else> <s:property value="#session.user.userName" />
			</a> <span>|</span> <a href="orderAction_toShopcartView">购物车</a>
		</div>
	</div>
	<!-- 分割线············································· -->
	<div class="content">
		<div class="content_c"></div>
		<!-- 登陆对话框-->
		<div class="login">
			<div class="title"></div>
			<p>
				订单已经成功提交[<a href="orderAction_toShopcartView">返回</a>]
			</p>
		</div>
	</div>

	<div class="footer">
		<br /> <br />
		<div class="footer_div">联系作者 | 技术博客 | 新浪微博 @2014 feng</div>
	</div>
</body>
</html>