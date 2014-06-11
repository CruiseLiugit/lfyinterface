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
import com.liufuya.core.mvc.module.common.bean.ReturnJsonBean;
import com.liufuya.core.mvc.module.store.dao.impl.StoreDaoImpl;
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

	/**
	 * 查询所有门店列表
	 */
	public String getStoreAddressList(String paraData) {
		String data = "";
		try {
			data = new String(paraData.getBytes("ISO8859-1"), "UTF-8");
			log.info("接口参数....... paraData =" + paraData);
			log.info("接口参数....... data =" + data);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ParaData dataobj = Json.fromJson(ParaData.class, Lang.inr(data));
		log.info("转换对象....... dataobj =" + dataobj);
		log.info("转换对象....... dataobj =" + dataobj.getCityName());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("city", dataobj.getCityName());
		map.put("city_part", dataobj.getAreaName());
		
		List<StoreAddress> list = this.storeDao.findStoreAddress(map);
		log.info("----->list ="+list);
		
		ReturnJsonBean bean= new ReturnJsonBean();
		if (list != null && list.size()>0) {
			//把获取的数据转换为 JSON 字符串
			bean.setCode("0");
			bean.setCodeDesc("查询成功");
		}else{
			bean.setCode("500");
			bean.setCodeDesc("目前没有数据");
		}
		bean.setResults(list);
		
		return Json.toJson(bean,JsonFormat.nice());
	}

}
