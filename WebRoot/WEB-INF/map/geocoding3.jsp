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
		//页面加载，直接请求
		alert("页面加载完成，请求中......");
		$.ajax({
			//防止提交乱码
			type:"GET",
			url:"${base}/map/searchByIP",
			data:{"ip":"202.198.16.3"},
			dataType:"json",
			success:function(res){
				//清空
				$("#province").html();
				$("#city").html();
	
				if (res != "") {
					var obj = jQuery.parseJSON(res);
					$("#result").show();
					$("#province").html(obj.content.address_detail.province);
					$("#city").html(obj.content.address_detail.city);
				} else {
					$("#province").hide("查询失败!");
				}
				
				return false;
			},
			fail : function(res) {
				//清空
				$("#province").html();
				alert("请求错误?!");
			}
		});
	
});
</script>
<title>首页</title>
</head>
<body>
	<h1 id="login_status">请输入地址</h1><p/>
	<p>页面加载，自动根据当前的IP地址，判断用户所在城市。</p>
	
	<div id="result" style="display:none;">
		<div id="province"></div> 
		<div id="city"></div>
	</div>
	
	<br />
	
	<a href="${base }/">首页</a>
	
	
</body>
</html>