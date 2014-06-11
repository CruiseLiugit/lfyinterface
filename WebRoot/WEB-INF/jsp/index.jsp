<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <!-- 该页面所有 请求，由 com.liufuya.core.mvc.module.store.action.StoreAction.java 处理 -->
	<h1>门店地图</h1>
	<ul>
		<li><h1 id="login_status">查询门店接口</h1>
			<p>http://localhost:8080/lfyinterface/searchStoreByStreet?cityName=上海&areaName=徐汇</p>
		</li>
		<li><h1 id="login_status">查询用户是否可以配送接口</h1>
			<p>http://localhost:8080/lfyinterface/searchStoreByAddressCode?addressCode=43ee065f-85d7-4ef1-bb04-20ee796fa73b</p>
		</li>
	</ul>

  </body>
</html>
