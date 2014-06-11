接口项目
记录每天修改的细节：

//----------------------------------------------
//2014-06-11
1、昨晚按照 json 格式传递参数，HttpClient 认为参数错误。修改为原始的参数传递方式
   http://115.29.12.128:8080/lfyinterface/searchStoreByStreet?cityName=上海&areaName=徐汇
2、测试接口一，是否能通过 HttpClient 类读取。读取成功
  http://localhost:8080/demolib/interface1   
3、接着编写第二个接口  
4、修改会员管理模块，增加两个新的会员信息。在  门店地址的配送范围内部



//----------------------------------------------
//2014-06-10
8-9两天没有编码。今天必须完成门店查询。地址查询两个接口
1、完成接口数据库查询功能
   com.liufuya.core.mvc.module.store.dao.impl.StoreDaoImpl
2、建立一个数据库表的 Module 类


//----------------------------------------------
//2014-06-07
1、新建工程
2、搭建 Nutz 框架
3、准备好数据
4、测试接收接口定义格式的数据
http://localhost:8080/lfyinterface/searchStoreByStreet?paraData={"cityName":"上海","areaName":"浦东"}
5、解决接收参数中文乱码问题
	com.liufuya.core.mvc.module.store.action.StoreAction
	
	String data = "";
		try {
			data = new String(paraData.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AddressBean dataobj = Json.fromJson(AddressBean.class, Lang.inr(data));
		log.info("转换对象....... dataobj =" + dataobj);
		log.info("转换对象....... dataobj =" + dataobj.getAddressCode());
		
  
  