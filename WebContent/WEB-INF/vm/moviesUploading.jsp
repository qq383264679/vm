<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags"%>
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

.header_right div {
	font-weight: 600;
	color: white;
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

.uploading {
	width: 460px;
	height: 660px;
	margin: 0 auto;
}
</style>
	<script type="text/javascript" src="js/jquery-2.0.3.js"></script>
</head>
<script type="text/javascript">
		function checkForm() {
			var price = $("#price_p").val();
			var name = $("#name_n").val();
			if(name == "") {
				alert("影片名不能为空");
				return false;
			}
			if(!isFloat(price)) {
				alert("单价必须得填，且必须合理");
			}
			return isFloat(price);
		}
		function isFloat(data) {
             var result=false;
            
             if(typeof data!='undefined') {
                // 正则表达式 匹配 非负浮点数，小数点后最多两位小数   
                if(data.match(/^\+{0,1}\d+(\.\d{1,2})?$/)!=null){
                    result=true;
                }
            }
            return result;
         }
	</script>
<body>
	<div class="header">
		<div class="header_right">
			<div>后台管理系统</div>
		</div>
	</div>
	<!-- 分割线············································· -->
	<div class="content">
		<div class="content_c">
			<s:fielderror cssStyle="color:red"></s:fielderror>
			<form action="productAction_fileUploading"
				enctype="multipart/form-data" method="post"
				onsubmit="return checkForm();">
				<div class="uploading">
					<div>
						电影片名：<input type="text" name="name" id="name_n" />
					</div>
					<br />
					<div>
						影片类型：<input type="text" name="genre" />
					</div>
					<br />
					<div>
						领衔主演：<input type="text" name="starring" />
					</div>
					<br />
					<div>
						影片导演：<input type="text" name="director" />
					</div>
					<br />
					<div>
						对白语言：<input type="text" name="language" />
					</div>
					<br />
					<div>
						&nbsp;&nbsp;&nbsp;&nbsp;单价：<input type="text" name="price"
							id="price_p" />
					</div>
					<div>
						剧情简介：<br />&nbsp;&nbsp;&nbsp;
						<textarea name="storyAbstract" rows="5" cols="35"></textarea>
					</div>
					<br />
					<div>
						剧情详情：<br />&nbsp;&nbsp;&nbsp;
						<textarea name="story" rows="7" cols="35"></textarea>
					</div>
					<br />
					<div style="float: left;">
						影片海报:
						<s:file name="posterImage" />
					</div>
					<div style="float: left;">
						<input type="submit" value="提交" />
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="footer">
		<br /> <br />
		<div class="footer_div"></div>
	</div>
</body>
</html>