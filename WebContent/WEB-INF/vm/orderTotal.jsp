<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>在线购物系统</title> <script type="text/javascript"
		src="js/jquery-2.0.3.js"></script>
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
	margin-top: 35px;
	height: 100px;
	width: 100%;
	background-color: rgb(52, 56, 68);
}

.footer_div {
	width: 360px;
	height: 50px;
	margin: 0 auto;
}
.content_c_pages{
	margin-left: 63.5%;
}
</style>
</head>
<script type="text/javascript">
		$(document).ready(function(e) {
	        //遍历table中的tr
			
			//table 
			$("table tr:gt(0)").each(function() {
			 	var $tr = $(this);
				var $price = $tr.children().eq(1);  //1
				var $quantity = $tr.children().eq(2);  //2
				
				var $money = $tr.children().eq(4);  //total 
				$money.html("￥" +　$price.html()*$quantity.html());
				//alert($price.html() + ":::" + $quantity.html());			
			});
	        //分页
	        var nowPages = $("#nowPages").html();
			if(nowPages == 1) {
				$("#up_page").attr("href", "#");
			}
			var totals = $("#totals").html();
			if(nowPages >= totals) {
				$("#down_page").attr("href", "#");
			}
	    });
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
	<div class="content">
		<div class="content_c">
			<table
				style="border: 1px solid #ccc; width: 800px; height: 52px; margin: 0 auto; margin-top: 20px">
				<tr style="background-color: #ccc; height: 20px; text-align: right;">
					<td>片 名</td>
					<td>单 价</td>
					<td>数 量</td>
					<td>订购时间</td>
					<td>金额</td>
					<td>操作</td>
				</tr>
				<s:iterator value="orderLines" id="orderline">
					<tr style="text-align: right;">
						<td><s:property value="#orderline.product.name" /></td>
						<td id="price<s:property value="#orderline.orderId"/>"><s:property
								value="#orderline.product.price" /></td>
						<td id="quantity<s:property value="#orderline.orderId"/>"><s:property
								value="#orderline.quantity" /></td>
						<td><s:property value="#orderline.order.submitDate" /></td>
						<td id="total<s:property value="#orderline.orderId"/>"></td>
						<td style="width: 300px;"><a
							href="orderAction_toFinishAccount?orderId=<s:property value="#orderline.orderId"/>">结账支付</a></td>
					</tr>
				</s:iterator>

			</table>
			<!-- 分页条-->
 			<div class="content_c_pages">
 				<p>
	            	<a id="up_page" href="orderAction_toShopcartView?pages=${pages-1 }">上一页</a>
	                <a id="down_page" href="orderAction_toShopcartView?pages=${pages+1 }">下一页</a>
	                                                        当前第<span id="nowPages">${pages }</span>页
	                                                        总共<span id="totals">${totals }</span>页
				</p>                                                        
			</div>
			<br /> <a href="productAction_toMainView" style="margin-left: 73.5%">继续购物</a>
		</div>

	</div>

	<div class="footer">
		<br /> <br />
		<div class="footer_div">联系作者 | 技术博客 | 新浪微博 @2014 feng</div>
	</div>
</body>
</html>

