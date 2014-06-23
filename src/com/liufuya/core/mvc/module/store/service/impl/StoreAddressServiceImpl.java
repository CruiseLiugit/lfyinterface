package com.liufuya.core.mvc.module.store.service.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.liufuya.common.Constants;
import com.liufuya.core.map.BaiduMapBiz;
import com.liufuya.core.map.jsonbean.Geocoding;
import com.liufuya.core.map.jsonbean.IPAddress;
import com.liufuya.core.mvc.module.common.bean.AvailableShopsBean;
import com.liufuya.core.mvc.module.common.bean.ReturnJsonBean;
import com.liufuya.core.mvc.module.store.dao.impl.StoreDaoImpl;
import com.liufuya.core.mvc.module.store.model.MemberAddress;
import com.liufuya.core.mvc.module.store.model.ParaData;
import com.liufuya.core.mvc.module.store.model.StoreAddress;

/**
 * 门店地址接口service实现层
 * 
 * @author 刘立立
 * 
 */
@IocBean
public class StoreAddressServiceImpl {
	private static final Log log = Logs.get();

	@Inject("refer:storeDaoImpl")
	private StoreDaoImpl storeDao;

	@Inject("refer:baiduMapBiz")
	private BaiduMapBiz baidu;

	/**
	 * 接口一、查询所有门店列表
	 */
	public String getStoreAddressList(String cityName, String areaName) {
		// log.info("接口参数....... cityName =" + cityName);
		// log.info("接口参数....... areaName =" + areaName);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String citydata = new String(cityName.getBytes("ISO8859-1"),
					"UTF-8");
			String areadata = new String(areaName.getBytes("ISO8859-1"),
					"UTF-8");
			// log.info("转码参数....... citydata =" + citydata);
			// log.info("转码参数....... areadata =" + areadata);
			map.put("city", citydata);
			map.put("city_part", areadata);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<StoreAddress> list = this.storeDao.findStoreAddress(map);
		log.info("----->list =" + list);

		ReturnJsonBean bean = new ReturnJsonBean();
		if (list != null && list.size() > 0) {
			// 把获取的数据转换为 JSON 字符串
			bean.setStatus("200");
			bean.setInfo("查询成功");

		} else {
			bean.setStatus("404");
			bean.setInfo("目前没有门店数据");
		}
		bean.setResults(list);

		return Json.toJson(bean, JsonFormat.nice());
	}

	/**
	 * 接口二: 根据会员地址表中的 address_code ，查询会员地址，并判断该地址周边是否有门店能够配送 返回查询结果
	 */
	public String getStoreByAddressCode(String addressCode) {
		// log.info("接口参数....... addressCode =" + addressCode);
		// 根据 会员地址编码，查询出会员地址对象
		MemberAddress addressBean = this.storeDao
				.getMemberAddressByCode(addressCode);
		// log.info("----->根据会员地址编号，查询得到地址对象 addressBean ="+addressBean);

		ReturnJsonBean bean = new ReturnJsonBean();
		if (addressBean != null) {
			// 根据会员地址，进行百度查询，获取经纬度坐标，插入用户 memberaddress 会员表中
			// 先得到会员所在城市，区域，缩小数据库中门店的范围
			// 参数一，一个城市客户地址所在区域的所有门店
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("city", addressBean.getCity());
			map.put("city_part", addressBean.getArea());
			List<StoreAddress> list = this.storeDao.findStoreAddress(map);
			// log.info("----->客户所在区域门店 list ="+list.size());

			// 参数二，客户的完整地址
			// 调用方法，判断
			// 到门店表里面，过滤地理位置数据(两个坐标对比，看是否在 3 公里范围)
			List<StoreAddress> storeList = this.storeDao
					.checkMemberAddressAround(list, addressBean);
			if (storeList.size() > 0) {
				// 把获取的数据转换为 JSON 字符串
				bean.setCode("1");
				bean.setResult("您的送餐地址在门店配送范围内!");

				// 判断，如果数据库中没有 门店配送信息，更新
				if (addressBean.getAvailable_shops() == null
						|| addressBean.getAvailable_shops().equals("")) {
					// 有门店，把门店数据组合成 json 插入 lfy_member_address 表中
					// `available_shops` varchar(500) DEFAULT NULL COMMENT
					// '周边配送符合配送条件的门店编号(Null表示无门店可以配送,有多家门店可以外送存入JSON对象{"n1":"门店编号","n2":"门店编号"})',
					List<AvailableShopsBean> availables = new ArrayList<AvailableShopsBean>();
					for (StoreAddress storeAddress : storeList) {
						AvailableShopsBean avbean = new AvailableShopsBean();
						avbean.setStorecode(storeAddress.getStore_code());
						avbean.setStorename(storeAddress.getStore_name());
						availables.add(avbean);
					}
					// 转换为 json 字符串
					String available = Json.toJson(availables);
					log.info("插入lfy_member_address 表中的配送门店字段 available ="
							+ available);
					addressBean.setAvailable_shops(available); // 插入数据库

					// `is_available` varchar(10) DEFAULT '0' COMMENT '是否可以配送
					// 1可以 0不可以',
					addressBean.setIs_available("1"); // 插入数据库
					// 调用百度地图查询 GPS 周围店铺 code 编号
					Geocoding ge = null;
					try {
						// log.info("百度地图查询1");
						ge = baidu.getMapByGet(
								addressBean.getAddress_keywords(),
								addressBean.getCity());
						// log.info("百度地图查询2");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.info("百度地图查询异常");
					}
					if (ge != null) {
						if (ge.getResult() != null) {
							// log.info("百度地图查询成功,纬度 lat = "+ge.getResult().getLocation().getLat());
							addressBean.setGps_lat(""
									+ ge.getResult().getLocation().getLat()); // 插入数据库
							addressBean.setGps_long(""
									+ ge.getResult().getLocation().getLng()); // 插入数据库
						} else {
							log.info("地址不正确");
						}
					} else {
						log.info("百度地图查询失败");
					}

					this.storeDao.updateMemeberAddress(addressBean);
				}

			} else if (storeList.size() == 0) {
				bean.setCode("0");
				bean.setResult("您的送餐地址不在门店配送范围内!请修改地址或选择到店自取!");
			}
			bean.setStatus("200");
			bean.setInfo("查询成功");

		} else {
			bean.setStatus("400");
			bean.setInfo("根据用户地址编码无法查询到用户地址");
			bean.setCode("0");
			bean.setResult("您的送餐地址有误，请重新填写送餐地址!");
		}

		return Json.toJson(bean, JsonFormat.nice());
	}

	// ----------------------------------------------------------------------------
	/**
	 * 接口三、根据门店编号，到数据库查询门店对象
	 * 
	 * @param storeCode
	 *            门店编号
	 * @return
	 */
	public String getStoreByStoreCode(String storeCode) {
		StoreAddress store = this.storeDao.getStoreByStoreCode(storeCode);

		ReturnJsonBean bean = new ReturnJsonBean();
		List<StoreAddress> list = new ArrayList<StoreAddress>();
		if (store != null) {
			bean.setStatus("200");
			bean.setInfo("查询成功");
			list.add(store);
			bean.setResults(list);
		} else {
			bean.setStatus("404");
			bean.setInfo("目前没有门店数据");
			bean.setResults(list);
		}

		return Json.toJson(bean, JsonFormat.nice());
	}

	// ----------------------------------------------------------------------------
	/**
	 * 接口四、根据用户 IP，获取用户所在城市，及该城市所有门店详细信息
	 * 
	 * @param ip
	 *            用户IP 地址
	 * @return
	 */
	public String searchStoreByCityIP(String ip) {
		ReturnJsonBean bean = new ReturnJsonBean();
		// 根据城市查询数据库中所有门店
		List<StoreAddress> list = null;
		// 根据 IP 查询出来的城市或者省份
		String province = "";
		String city = "";

		// 根据 IP 判断用户所在城市
		String jsonResult = ""; // 要返回的 json 字符串
		try {
			jsonResult = baidu.getMapJsonByIPAddress(ip); // get 方法请求
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!"".equals(jsonResult)) {

			IPAddress ipbean = Json.fromJson(IPAddress.class, jsonResult);

			if (ipbean != null) {
				String status = ipbean.getStatus();
				// ip 正确
				if ("0".equals(status)) {
					province = ipbean.getContent().getAddress_detail()
							.getProvince();
					city = ipbean.getContent().getAddress_detail().getCity();
				}
				// ip 错误
				if ("2".equals(status)) {
					bean.setStatus("404");
					bean.setInfo("IP 错误，用户所在城市无法查出，默认用上海");
					list = this.storeDao.getStoreByCity("上海市", "上海市");
					bean.setProvince("上海市");
					bean.setCity("上海市");
					bean.setResults(list);
					return Json.toJson(bean, JsonFormat.nice());
				}
			}
		}

		// 根据城市查询数据库中所有门店
		list = this.storeDao.getStoreByCity(province, city);
		if (list != null) {
			bean.setStatus("200");
			if (list.size() == 0) {
				bean.setInfo("查询成功," + province + city + "目前没有门店数据，默认显示上海的数据");
				list = this.storeDao.getStoreByCity("上海市", "上海市");
				bean.setProvince("上海市");
				bean.setCity("上海市");
			} else {
				bean.setInfo("查询成功," + province + city + "目前有门店数据");
				bean.setProvince(province);
				bean.setCity(city);
			}

			bean.setResults(list);
		} else {
			bean.setStatus("500");
			bean.setInfo("数据库查询错误，无法查询出数据");
			bean.setProvince("");
			bean.setCity("");
			bean.setResults(list);
		}

		return Json.toJson(bean, JsonFormat.nice());
	}

}
