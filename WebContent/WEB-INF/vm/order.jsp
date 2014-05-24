<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单页面</title>
<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
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
	color: white;
	font-weight: 600;
	text-decoration: none;
}

.content {
	margin: 0 auto;
	height: 600px;
	widows: 100%; <!--
	background-color: yellow;
	-->
}

.content_c {
	margin: 0 auto;
	height: 180px;
	width: 60%; <!--
	background-color: blue;
	-->
}

.footer {
	margin: 0 auto;
	height: 100px;
	width: 100%;
	background-color: rgb(52, 56, 68);
}

.footer_div {
	width: 360px;
	height: 50px;
	margin: 0 auto;
}

.image {
	margin-left: 5px;
	margin-top: 5px;
	margin-right: 5px;
	float: left;
}
</style>
</head>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$("#productId").hide();
	    });
		function buy_confirm() {
			var quality = $("#quality").val();
			var productId = $("#productId").html();
			var b = $.isNumeric(quality)
			if(!$.isNumeric(quality)) {
				alert("输入的数量不对！");
			} else if(quality < 1) {
				alert("输入的数量必须大于1！");
			}
			else {
				//ajax 后台订购
				$.getJSON("orderAction_finishOrder",{"quality": quality, "productId": productId}, function(data){
					if(data.result == 'succeed') {
						alert("订购成功");
					}
				});
				
				$("#buy").attr("disabled", "disabled");
			}
			
		}
	</script>
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

	<p></p>

	<div class="content" style="vertical-align: middle;">

		<div class="content_c">

			<div style="float: left" class="image">
				<img src="images/${product.poster }" style="width: 175px; height: 240px;" />
			</div>

			<div style="margin-left: 8px;">
				<p style="height: 1px; margin-top: 3px;">
					<span id="productId">${product.productId }</span>
				</p>
				
				<p style="height: 3px; margin-top: 3px;">
					<font size="+2">电影名称：${product.name }</font>
				</p>
				<p style="height: 3px; margin-top: 40px;">
					类型/流派：${product.genre }
				</p>
				<p style="height: 3px; margin-top: 25px;">
					领衔主演：${product.starring }
				</p>
				<p style="height: 3px; margin-top: 25px;">
					导演：${product.director }
				</p>
				<p style="height: 3px; margin-top: 25px;">
					对白：${product.language }
					<%-- <s:property value="#product.language" /> --%>
				</p>
				<p style="height: 3px; margin-top: 25px;">
					价格：${product.price }
				</p>
				<p
					style="height: 3px; margin-top: 25px; word-break: break-all; word-wrap: break-word;">
					剧情介绍：${product.story }
				</p>
			</div>

			<div
				style="float: right; margin-right: -48px; margin-top: 185px; position: relative;">
				数量<input type="text" name="quailty" id="quality">	
				<input id="buy" type="button" value="购买" style="width: 80px; height: 30px;" onclick="buy_confirm();" />
			</div>
			
		</div>
	</div>

	<div class="footer">
		<br /> <br />
		<div class="footer_div">联系作者 | 技术博客 | 新浪微博 @2014 feng</div>
	</div>
</body>
</html>
