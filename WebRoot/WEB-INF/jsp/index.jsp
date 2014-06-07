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
    <!-- 该页面所有 请求，由 com.liulili.core.MenuAction.java 处理 -->
	<h1>门店地图</h1>
	<ul>
		<li><a href="${base }/map1">查询门店--根据城市、县区、路名查询</a></li>
		<li><a href="${base }/map2">中心点圆形半径判断</a></li>
		<li><a href="${base }/map3">根据IP地址判断所在城市</a></li>
		<li><a href="${base }/map4">判断一个起点距离多个终点地址的距离和时间 </a></li>
	</ul>
	
	<h1>UI框架案例</h1>
	<ul>
		<li><a href="${base }/bootstrap_ui1">HTML 5 BootStarp 管理模版框架</a></li>
		<li><a href="${base }/jui_ui1">DWZ jUI 模版</a></li>
		<li><a href="${base }/bootstrap_jui1">BootStarp 和 jUI 混合使用</a></li>
		<li><a href="${base }/jui_ui2">jUI 使用案例</a></li>
	</ul>
	
	<h1>多级菜单联动案例</h1>
	<ul>
		<li><a href="${base }/selectdemo1">纯 jQuery 三级联动一</a></li>
		<li><a href="${base }/selectdemo2">jQuery Ajax 三级联动二</a></li>
		<li><a href="${base }/selectdemo3">jQuery Ajax 三级联动三</a></li>
		<li><a href="${base }/selectdemo4">三级联动 教学案例</a></li>
	</ul>
	
	
	
  </body>
</html>
