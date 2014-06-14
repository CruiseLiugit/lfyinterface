package com.liufuya.core.mvc.module.store.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.liufuya.core.map.BaiduMapBiz;
import com.liufuya.core.map.jsonbean.AddressBean;
import com.liufuya.core.map.jsonbean.MemberAddressBean;
import com.liufuya.core.mvc.module.BasicDao;
import com.liufuya.core.mvc.module.store.model.MemberAddress;
import com.liufuya.core.mvc.module.store.model.StoreAddress;


/**
 * 菜单dao类
 * 
 * @author caryCheng
 * 
 */
@IocBean
public class StoreDaoImpl extends BasicDao {
	private static final Log log = Logs.get();

	// ioc 注入
	// 填写注入类的 名称，类名首字母小写
	@Inject("refer:baiduMapBiz")
	private BaiduMapBiz baidu;

	/**
	 * 接口一 、获取当前用户拥有的菜单
	 */
	public List<StoreAddress> findStoreAddress(Map<String, Object> map) {
		Sql sql = Sqls
				.create("select * from lfy_store_address where city like '%"
						+ (String) map.get("city") + "%' and city_part like '%"
						+ (String) map.get("city_part") + "%'");
		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<StoreAddress> list = new LinkedList<StoreAddress>();
				while (rs.next()) {
					StoreAddress menu = new StoreAddress();
					menu.setStore_code(rs.getString("store_code"));// 门店编码
					menu.setCity(rs.getString("city"));// 城市名
					menu.setCity_id(rs.getInt("city_id")); // 城市表 id
					menu.setCity_part(rs.getString("city_part"));// 县区
					menu.setStore_name(rs.getString("store_name"));// 门店名称
					menu.setStore_address(rs.getString("store_address"));// 门店地址
					menu.setStore_assistantphone(rs
							.getString("store_assistantphone"));// 门店电话
					menu.setGps_lng(rs.getString("gps_lng"));  //经度
					menu.setGps_lat(rs.getString("gps_lat"));  //纬度
					list.add(menu);
				}
				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(StoreAddress.class);
		// Nutz内置了大量回调, 请查看Sqls.callback的属性
	}

	// -------------------------------------------------------------
	/**
	 * 接口二、通过lfy_member_address 表中的 address_code 获取会员地址对象
	 */
	public MemberAddress getMemberAddressByCode(String addressCode) {
		Cnd condition = Cnd.where("address_code", "=", addressCode).and(
				"status", "=", "1");
		return findByCondition(MemberAddress.class, condition);
	}

	/**
	 * 接口二、通过用户所在县区所有门店，及用户自己的地址，判断用户周围 3 公里范围 内是否有配送的门店
	 * 
	 * @param storeList
	 *            一个城市客户地址所在区域的所有门店
	 * @param addressBean
	 *            客户的完整地址
	 * 
	 * @return
	 */
	public List<StoreAddress> checkMemberAddressAround(
			List<StoreAddress> storeList, MemberAddress addressBean) {
		//返回数据
		List<StoreAddress> okStore = new ArrayList<StoreAddress>();
		
		if (storeList == null || addressBean == null) {
			return null;
		}

		for (StoreAddress storeAddress : storeList) {
			//log.info("==========门店 :"+storeAddress.getStore_name());
			// 门店 坐标为中心
			String lng = storeAddress.getGps_lng();
			String lat = storeAddress.getGps_lat();
			String member_address = addressBean.getAddress_keywords();
			
			String gejson = "";   //要返回的 json 字符串
			
			try {
				//1 查询出中心点坐标 上海东方明珠
				//log.info("中心点，门店坐标  经度:"+lng+"  ,纬度:"+lat);
				
				//2 根据地址关键字，查询是否在中心点 3 公里范围内
				gejson = baidu.getMapJsonRadiusByPost(member_address,lat.trim().intern(),lng.trim().intern());
				//log.info("json 结果 ="+gejson);
				//3 把百度查询返回的 json 字符串，转换为对象 
				AddressBean bean = Json.fromJson(AddressBean.class, gejson);
				if (bean.getResults().size() >0) {
					//log.info("OK");
					okStore.add(storeAddress);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 客户地址查询

		return okStore;
	}

	
	
	/**
	 * 接口二、更新数据库中的记录
	 * @param addressBean
	 */
	public boolean updateMemeberAddress(MemberAddress addressBean){
		return this.update(addressBean);
	}
	
	
	// -------------------------------------------------------------
		/**
		 * 接口三、通过 lfy_store_address 表中的 store_code 获取门店对象
		 */
		public StoreAddress getStoreByStoreCode(String storeCode) {
			Cnd condition = Cnd.where("store_code", "=", storeCode).and(
					"status", "=", "1");
			return findByCondition(StoreAddress.class, condition);
		}
	
}
