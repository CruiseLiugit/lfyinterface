<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${base}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
//var login = <%=session.getAttribute("me") != null %>;
$(function () {
	/*
	if (login) {
		$("#login_status").html("已登陆");
		$("#login_form").hide();
	} else {
		$("#login_status").html("未登陆");
		$("#logout_link").hide();
	}
	*/
	$("#login_form").submit(function () {
		//alert($("#login_form").serialize());
		var shop = $("#saddr").val();
		var custom = $("#caddr").val();
		//alert("shop ="+shop+"  , custom ="+custom);
		$.ajax({
			//防止提交乱码
			type:"POST",
			url:"${base}/map/search",
			//手动提交数据
			//data:{"shopaddr":shop,"customeraddr":custom},
			//自动序列化表单中的数据
			data:$("#login_form").serialize(),
			dataType:"json",
			success:function(res){
				//alert(res);
				//清空
				$("#lng").html();
				$("#lat").html();
				
				if (res != "") {
					var obj = jQuery.parseJSON(res);
					$("#result").show();
					$("#lng").html(obj.lng );
					$("#lat").html(obj.lat);
				
				} else {
					$("#login_status").append("查询失败!");
					$("#result").hide();
				}
				return false;
			},
			fail : function(res) {
				//清空
				$("#lng").html();
				$("#lat").html();
				$("#result").hide();
				
				alert("系统错误?!");
			}
		});
	
		return false;
	});
});
</script>
<title>首页</title>
</head>
<body>
	<h1 id="login_status">请输入地址</h1><p/>
	<p>Place API</p>
	<p>根据输入地址获取该地址的 经纬度坐标。</p>
	<p>输入内容，如：地址“上海科技京城”，城市“上海”</p>
	
	<form id="login_form" action="#">
		地址:<input name="shopaddr" id="saddr" type="text"></input><br/>
		城市:<input name="customeraddr" id="caddr" type="text"></input><br/>
		<input type="submit" value="提交"></input>
	</form>
	
	<div id="result" style="display:none;">
		经度:<div id="lng"></div> 
		纬度:<div id="lat"></div>
	</div>
	
	<a href="${base }/">首页</a>
	
</body>
</html>