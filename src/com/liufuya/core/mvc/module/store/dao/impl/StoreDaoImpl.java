package com.liufuya.core.mvc.module.store.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.liufuya.core.mvc.module.BasicDao;
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
	
	/**
	 * 获取当前用户拥有的菜单
	 */
	public List<StoreAddress> findStoreAddress(Map<String, Object> map) {
		Sql sql = Sqls
				.create("select * from lfy_store_address where city like '%"+(String)map.get("city")+"%' and city_part like '%"+(String)map.get("city_part")+"%'");		
		// dao.execute(sql) 执行前，编写回调函数，解析 查询结果
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<StoreAddress> list = new LinkedList<StoreAddress>();
				while (rs.next()) {
					StoreAddress menu = new StoreAddress();
					menu.setStore_code(rs.getString("store_code"));//门店编码
					menu.setCity(rs.getString("city"));//城市名
					menu.setCity_part(rs.getString("city_part"));//县区
					menu.setStore_name(rs.getString("store_name"));//门店名称
					menu.setStore_address(rs.getString("store_address"));//门店地址
					menu.setStore_assistantphone(rs.getString("store_assistantphone"));//门店电话
					list.add(menu);
				}
				return list;
			}
		});

		dao.execute(sql);
		return sql.getList(StoreAddress.class);
		// Nutz内置了大量回调, 请查看Sqls.callback的属性
	}

	

}
