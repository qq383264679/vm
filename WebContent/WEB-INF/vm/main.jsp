<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>     
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
				background-image:url(sys_images/main_title.jpg);
			}
			
			.header_right {
				height: 30px;
				width: 250px;
				float: right;
				
				line-height:30px;
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
				widows: 100%;
				<!--background-color: yellow; -->
			}
			
			.content_c {
				margin: 0 auto;
				height: 180px;
				width: 60%;
				<!--background-color: blue; -->
			
			}
			
			
			.footer {
				margin: 0 auto;
				height: 100px;
				width: 100%;
				background-color:rgb(52, 56, 68);
			}
			.footer_div {
				width:360px;
				height:50px;
				margin:0 auto;
			}
		</style>
		<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
	</head>
	<script type="text/javascript">
		$(document).ready(function(e) {
			var nowPages = $("#nowPages").html();
			if(nowPages == 1) {
				$("#up_page").attr("href", "#");
			}
			var totals = $("#totals").html();
			if(nowPages == totals) {
				$("#down_page").attr("href", "#");
			}
	    });
	</script>
	<body>
		<div class="header">
			<div class="header_right">
				<a href="productAction_toMainView">主页</a>
				<span>|</span>
				<a href="lognAction_toLognView">
					<s:if test="#session.user == null">登录 </s:if>
					<s:else>注销</s:else>
					<s:property value="#session.user.userName" />
				</a>
				<span>|</span>
				<a href="#">购物车</a>
			</div>
		</div>
		<!-- 分割线············································· -->
		<div class="content">
			<s:iterator value="products" id="product">
	          	<div class="content_c">
	            	  <div style="float:left"><img src="images/<s:property value="#product.poster" />" width="126" height="160"  /></div>
	              	  <div style="float:left;">
	                    <p style="height:3px; margin-top:3px;"><font size="+2">电影名称：<s:property value="#product.name" /></font></p>
	                    <p style="height:3px; margin-top:25px;">类型/流派：<s:property value="#product.genre" /></p>
	                    <p style="height:3px; margin-top:25px;">领衔主演：<s:property value="#product.starring" /></p>
	                    <p style="height:3px; margin-top:25px;">导演：<s:property value="#product.director" /></p>
	                    <p style="height:3px; margin-top:25px;">对白：<s:property value="#product.language" /></p>
	                    <p style="height:3px; margin-top:25px;">剧情介绍：<s:property value="#product.storyAbstract" /></p>
	          		  </div>
	                  <p style="float: right;">价格：<s:property value="#product.price" /></p>
	                  <input type="button" value="购买" style="float: right;" />
				</div>
            	<hr />
            </s:iterator> 
            <!-- 分页条-->
 			<div class="content_c">
            	<a id="up_page" href="productAction_toMainView?pages=${pages-1 }">上一页</a>
                <a id="down_page" href="productAction_toMainView?pages=${pages+1 }">下一页</a>
                                                        当前第<span id="nowPages">${pages }</span>页
                                                        总共<span id="totals">${totals }</span>页
			</div>
		</div>
        
		<div class="footer">
        	<br /> <br />
			<div class="footer_div">
            	联系作者 |  技术博客  |  新浪微博         @2014 feng
            </div>
		</div>
	</body>
</html>


	
