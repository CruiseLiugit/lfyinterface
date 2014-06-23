package com.liufuya.core.mvc.module.store.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.liufuya.common.Constants;
import com.liufuya.common.Escape;
import com.liufuya.core.map.BaiduMapBiz;
import com.liufuya.core.map.jsonbean.Geocoding;
import com.liufuya.core.mvc.module.store.model.AddressBean;
import com.liufuya.core.mvc.module.store.model.ParaData;
import com.liufuya.core.mvc.module.store.model.StoreAddress;
import com.liufuya.core.mvc.module.store.service.impl.StoreAddressServiceImpl;

/**
 * 门店的接口
 * 
 * @author 刘立立
 * 
 */
@IocBean
public class StoreAction {

	private static final Log log = Logs.get();

	// ioc 注入
	// 填写注入类的 名称，类名首字母小写
	@Inject("refer:storeAddressServiceImpl")
	private StoreAddressServiceImpl storeService;

	// ************************************************************************************
	/**
	 * 接口一:查询门店接口，查询数据库
	 */
	@At("/searchStoreByStreet")
	// @Ok("json")
	public void searchStoreByStreet(@Param("cityName") String cityName,
			@Param("areaName") String areaName, HttpServletResponse response) {
		// 根据城市名称和 县区名称，到数据库查询
		String json = this.storeService.getStoreAddressList(cityName, areaName);
		//log.info("====> json =" + json);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

		// return json;
	}

	// ************************************************************************************
	/**
	 * 接口二: 根据会员地址表中的 address_code ，查询会员地址，并判断该地址周边是否有门店能够配送 返回查询结果
	 */
	@At("/searchStoreByAddressCode")
	// @Ok("json")
	public void searchStoreByAddressCode(
			@Param("addressCode") String addressCode,
			HttpServletResponse response) {
		// 根据城市名称和 县区名称，到数据库查询
		String json = this.storeService.getStoreByAddressCode(addressCode);
		//log.info("====> json =" + json);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	// ************************************************************************************
	/**
	 * 接口三: 根据门店编号，获取门店详细信息
	 */
	@At("/searchStoreByStoreCode")
	public void searchStoreByStoreCode(@Param("storeCode") String storeCode,
			HttpServletResponse response) {
		// 根据门店编号，到数据库查询门店对象
		String json = this.storeService.getStoreByStoreCode(storeCode);
		//log.info("====> json =" + json);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	// ************************************************************************************
	/**
	 * 接口四: 根据用户 IP，获取用户所在城市，及该城市所有门店详细信息
	 */
	@At("/searchStoreByCityIP")
	public void searchStoreByCityIP(@Param("ip") String ip,
			HttpServletResponse response) {
		// 根据门店编号，到数据库查询门店对象
		String json = this.storeService.searchStoreByCityIP(ip);
		//log.info("====> json =" + json);

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	// ************************************************************************************
	
}
