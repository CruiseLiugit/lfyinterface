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
		var startaddr = $("#start").val();
		var endaddr1 = $("#endaddr1").val();
		var endaddr2 = $("#endaddr2").val();
		var endaddr3 = $("#endaddr3").val();
		var endaddr4 = $("#endaddr4").val();
		var endaddr5 = $("#endaddr5").val();
		//alert("shop ="+shop+"  , custom ="+custom);
		$.ajax({
			//防止提交乱码
			type:"POST",
			url:"${base}/map/searchDistance",
			//手动提交数据
			data:{"startaddr":startaddr,"endaddr1":endaddr1,"endaddr2":endaddr2,"endaddr3":endaddr3,"endaddr4":endaddr4,"endaddr5":endaddr5},
			//自动序列化表单中的数据
			//data:$("#login_form").serialize(),
			dataType:"json",
			success:function(res){
				alert("查询结果  :"+res);
				
				//清空
				$("#lng").html();
				$("#lat").html();
				
				if (res != "") {
					var obj = jQuery.parseJSON(res);
					alert("statu :"+obj.status);
					alert("message :"+obj.message);
					
					$("#result").show();
					
				
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
	<h1 id="login_status">请输入起点，终点地址</h1><p/>
	<p>根据起点终点地址名称，判断地址之间的间距和步行或者驾车时间。</p>
	<p>可以根据地址判断，可以可以根据经纬度进行判断</p>
	
	<h4>方式一：根据地址名称判断</h4>
	<form id="login_form" action="#">
		起点地址名称:<input name="startaddr" id="start" type="text" value=""><br/>
		终点地址一:<input name="endaddr1" id="endaddr1" type="text"></input><br/>
		终点地址二:<input name="endaddr2" id="endaddr2" type="text"></input><br/>
		终点地址三:<input name="endaddr3" id="endaddr3" type="text"></input><br/>
		终点地址四:<input name="endaddr4" id="endaddr4" type="text"></input><br/>
		终点地址五:<input name="endaddr5" id="endaddr5" type="text"></input><br/>
		<input type="submit" value="提交"></input>
	</form>

	<div id="result" style="display:none;">
		<div id="duration"></div> 
		<div id="distance"></div>
	</div>
	
	<br /><br/>
	
	<a href="${base }/">首页</a>
	
	
</body>
</html>