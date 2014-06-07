package com.liufuya.common;


/**
 * 公用静态类
 */
public class Constants {
	
	
	
	//分页每页最大条数默认
	/**
	 * sysUserList.jsp 页面最大数据显示条数
	 */
	public static final int SYSUSER_PAGE_SIZE = 10;
	/**
	 * sysMenusList.jsp 页面最大数据显示条数。这里设置大一些
	 */
	public static final int MENUS_PAGE_SIZE = 50;
	/**
	 * sysRoleList.jsp 页面最大数据显示条数。这里设置大一些
	 */
	public static final int ROLES_PAGE_SIZE = 50;
	
	
	
	
	/**
	 * 当前登录用户Session常量
	 */
	public static final String CURRENT_LOGIN_NAME="CURRENT_LOGIN_NAME";
	public static final String CURRENT_LOGIN_USER="CURRENT_LOGIN_USER";
	/**
	 * 登录验证码Session常量
	 */
	public static final String KAPTCHA_SESSION_KEY="KAPTCHA_SESSION_KEY";
	
	//存入验证码的 Session Name
	public static final String VALIDATION_CODE = "validation_code";
		
	
	/**
	 * 一级菜单标记
	 */
	public static final String FIRST_MENU_FLAG="0";
	
	/**
	 * 角色树根标识
	 */
	public static final String ROLE_TREE_ROOT_FLAG="0";

	/**
	 * 角色树根名称
	 */
	public static final String ROLE_TREE_ROOT_NAME="角色";
	/**
	 * 按钮树根名称
	 */
	public static final String BUTTON_TREE_ROOT_NAME="按钮";
	/**
	 * 运行按钮的code
	 */
	public static final String RUN_BUTTON_CODE="f14f35f8-2246-41h2-34f2-4cg56ad75ead"; 
	
	/**
	 * 权限树根名称
	 */
	public static final String AUTH_TREE_ROOT_NAME="权限";
	
	/**
	 * 权限树根标识
	 */
	public static final String AUTH_TREE_ROOT_FLAG="";
	
	
	/***
	 * 列表数据每页默认条数
	 */
	//public static final int DEFAULT_PAGE_SIZE=cacheConfig.getInt("DEFAULT_PAGE_SIZE");


	/**
	 * 系统用户状态：1 有效 0 无效
	 */
	public static final String SYSUSER_STATUS_VALID = "1";
	/**
	 * 系统admin 角色id
	 */
	public static final String ADMIN_ROLE_CODE ="d22f30b8-2716-41d2-84f2-4cd56bb75ecc";
	
	/**
	 * 合作商和把握公司合作状态： 1 正常合作 2 暂停 合作 3 取消合作
	 */
	public static final String PARTNER_COOPERATE_STATUS_NORMAL="1";
	public static final String PARTNER_COOPERATE_STATUS_PAUSE="2";
	public static final String PARTNER_COOPERATE_STATUS_DELETE="3";
	
	/**
	 * 合作商和铺设点合作状态： 1 正常合作 2 暂停 合作 3 取消合作
	 */
	public static final String PARTNER_PAVE_COOPERATE_STATUS_NORMAL = "1";
	
	/**
	 * 电子券的状态 :0未认证 3 冻结
	 * 
	 */
	public static final String ELECTICKET_STATUS_FREEZE="3";
	public static final String ELECTICKET_STATUS_UNAPPROVE="0";
	/**
	 * 电子券的操作类型 1 冻结  2 恢复
	 */
	public static final String ELECTICKET_OPTYPE_FREEZE="1";
	public static final String ELECTICKET_OPTYPE_RECOVER="2";
	/**
	 * pov机心跳间隔多久判断为运行故障 默认40分钟
	 */
	public static final int  POV_RUNNING_STATUS_TIME=40;
	
	/**
	 * pov机在铺设点的使用状态 1 正常 2 暂停
	 */
	public static final String POV_USE_STATUS_NORMAL = "1";
	public static final String POV_USE_STATUS_NORMAL_STR = "正常";
	public static final String POV_USE_STATUS_PAUSE_STR = "暂停";
	
	/**
	 * 铺设点状态 1 正常 2 暂停
	 */
	public static final String PAVE_STATUS_NORMAL = "1";
	public static final String PAVE_STATUS_PAUSE = "2";
	public static final String PAVE_STATUS_NORMAL_STR = "正常";
	public static final String PAVE_STATUS_PAUSE_STR = "暂停";
	/**
	 * pov机的使用状态1 正常,2 暂停
	 */
	public static final String  POV_USE_STATUS_PAUSE="2";
	public static final String  POV_USE_STATUS_RECOVER="1";
	public static final String  POV_USE_STATUS_RELEVANCE="已关联"; 
	public static final String  POV_USE_STATUS_RELIVE="暂停";
	
	/**
	 * 铺设点操作类型 3 删除, 2 暂停 
	 */
	public static final String PAVE_OPERATE_DELETE = "3";
	/**
	 * POV添加方式 1 单个添加 2 批量添加
	 */
	public static final String WAREHOUSE_POV_ADD_SATUS="1";
	public static final String WAREHOUSE_POV_ADD_LIST_SATUS="2";
	/**
	 * POV仓库管理状态 1 已入库  2 已出库 3维修中
	 */
	public static final String WAREHOUSE_POV_SATUS_IN="1";
	public static final String WAREHOUSE_POV_SATUS_OUT="2";
	public static final String WAREHOUSE_POV_SATUS_MAINTAIN="3";
	
	/**
	 * 解析Excel保存在session中的KEY
	 */
	public static final String PARSE_EXCEL_SESSION_KEY = "PaveListFromParseExcel";
	
	//-----------------------------------------------------------
		//http://developer.baidu.com/map/webservice-placeapi.htm
		
		//百度地图Place API服务地址
		//5.Place区域检索POI服务  Place POI
		//http://api.map.baidu.com/place/v2/search?ak=您的密钥&output=json&query=银行&page_size=10&page_num=0&scope=1&region=北京
		
		
		//3）圆形区域检索参数
		//圆形区域检索示例(返回xml数据)：
		//http://api.map.baidu.com/place/v2/search?&query=银行&location=39.915,116.404&radius=2000&output=xml&ak=66K99NkKszXrvpuhQWctW0o1
		//http://api.map.baidu.com/place/v2/search?&query=银行&location=39.915,116.404&radius=2000&output=json&ak=66K99NkKszXrvpuhQWctW0o1
		public static final String RADIUSSEARCH_URL="http://api.map.baidu.com/place/v2/search";
		public static final String RADIUS="3000";  //默认搜索半径 3公里
		
		//-----------------------------------------------------------
		// 百度地图Geocoding API
		// 通用接口参数
		//百度地图Geocoding API服务地址
		public static final String GEBASEURL = "http://api.map.baidu.com/geocoder/v2/";
		//output  非必须，默认 xml, 	json或xml 	输出格式为json或者xml
		public static final String OUTPUT = "json";
		//ak      必须，用户申请注册的key，自v2开始参数修改为“ak”，之前版本参数为“key”
		public static final String AK = "66K99NkKszXrvpuhQWctW0o1";
		
		//地理编码服务，需要用户从页面输入，不能定位常量
		//参数	   是否必须	默认值	 格式举例	                          含义
		//address 	是 	     无   	北京市海淀区上地十街10号 	根据指定地址进行坐标的反定向解析
		//city 	    否 	   “北京市” 	“广州市”              	地址所在的城市名
		
		//设置 IP 白名单，可以不需要 sn   callback 参数
		//0.0.0.0/0
		//http://api.map.baidu.com/geocoder/v2/?ak=您的密钥&callback=renderOption&output=json&address=百度大厦&city=北京市
		//无回调函数
		public static final String GEURL = GEBASEURL+"?ak="+AK+"&output="+OUTPUT+"&";
		
		
		//-----------------------------------------------------------
		//Route Matrix API是一套以HTTP形式提供的批量线路查询接口，用于返回多个起点和多个终点间的线路距离和行驶时间
		//该接口适用于仅获取线路距离和时间，无需获取详细线路信息或者需要同时获取多起点、多终点线路距离等的情况。
		//如根据用户输入地址为唯一起点，获取周边 留夫鸭门店 为多个终点的，线路信息
		//使用限制
	    //	起终点个数最多为5个，即每个请求串最多能查询25条线路信息；
	    //	每个ak每天最多查询10万次。
		//http://api.map.baidu.com/direction/v1/routematrix
		//http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=起点1|起点2&destinations=终点1|终点2&ak=E4805d16520de693a3fe707cdc962045  
		//origins=origin1|orgin2为请求的起点，destinations=destination1|destination2为请求的终点：
		//起点、终点使用名称
		//http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=上海东方明珠&destinations=上海南京东路|上海中山公园&ak=66K99NkKszXrvpuhQWctW0o1
		//起点、终点使用经纬度坐标
		//http://api.map.baidu.com/direction/v1/routematrix?output=json&origins=40.056878,116.30815&destinations=39.915285,116.403857&ak=66K99NkKszXrvpuhQWctW0o1
		
		/*
		 {
	  "status" : 0,
	  "message" : "ok",
	  "info" : {
	    "copyright" : {
	      "text" : "@2014 Baidu - Data",
	      "imageUrl" : "http:\/\/api.map.baidu.com\/images\/copyright_logo.png"
	    }
	  },
	  "result" : {
	    "elements" : [
	      {
	        "distance" : {
	          "value" : 6247,
	          "text" : "6.2公里"
	        },
	        "duration" : {
	          "value" : 1106,
	          "text" : "18分钟"
	        }
	      },
	      {
	        "distance" : {
	          "value" : 12170,
	          "text" : "12.2公里"
	        },
	        "duration" : {
	          "value" : 1562,
	          "text" : "26分钟"
	        }
	      }
	    ]
	  }
	}
		*/
		public static final String  RouteMatrixUrl = "http://api.map.baidu.com/direction/v1/routematrix?output=json"; 
		
		
		//-----------------------------------------------------------
			//IP定位 API是一个根据IP返回对应位置信息的http形式位置服务接口,支持多种语言调用，如C# 、C++、Java等，即通过发送http请求，返回json格式的位置数据（包括坐标值、省份、城市、百度城市代码等）。
			//1.获取指定IP的位置信息：指定IP值，返回该IP对应的位置信息；
			//以城市为分类的应用或网站：根据用户当前IP来提供对应城市的服务
			//限制
			//每个key每天支持100万次调用，超过限制不返回数据。
			//IP定位的结果精度较差，主要应用获取省份或者城市的位置信息
			//URL：http://api.map.baidu.com/location/ip
			//实例
			//http://api.map.baidu.com/location/ip?ak=E4805d16520de693a3fe707cdc962045&
			//ip=202.198.16.3&
			//coor=bd09ll
			//返回值
			/*
			 {
		  "address" : "CN|吉林|长春|None|CERNET|1|None",
		  "content" : {
		    "address" : "吉林省长春市",
		    "point" : {
		      "x" : "125.31364243",
		      "y" : "43.89833761"
		    },
		    "address_detail" : {
		      "district" : "",
		      "street_number" : "",
		      "province" : "吉林省",
		      "city" : "长春市",
		      "city_code" : 53,
		      "street" : ""
		    }
		  },
		  "status" : 0
		}
			 */
			//ip 	ip地址 	string 	可选，ip不出现，或者出现且为空字符串的情况下，会使用当前访问者的IP地址作为定位参数
			//ak 	用户密钥 	string 	必选，在lbs云官网注册的access key，作为访问的依据	
			//sn 	用户的权限签名 	string 	可选，若用户所用ak的校验方式为sn校验时该参数必须。（sn生成算法）
			//coor 	输出的坐标格式 	string 	可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标
			public static final String IPURL = "http://api.map.baidu.com/location/ip";
			//output  非必须，默认 xml, 	json或xml 	输出格式为json或者xml
			//输出坐标格式，才有 百度经纬度坐标
			public static final String COOR = "bd09ll";
				
			//接口
			//http://localhost:8080/demolib/map/searchByIP?ip=202.198.16.3
		
		
		//-----------------------------------------------------------
		//百度地图 Place suggestion API ，后台增加门店时使用
		//Place suggestion API 是一套以HTTP形式提供的匹配用户输入关键字辅助信息、提示接口，可返回json或xml格式的一组建议词条的数据。
		//配合Place API使用：使用本接口请求，可调出匹配用户输入的关键字的建议列表，用户选择列表中确定的一条，结合Place API返回查询的结果。
		
		
		
		
		
	
}
