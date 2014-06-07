package com.liufuya.core.mvc.module.store.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.liufuya.common.Constants;

/**
 * 门店的接口
 * 
 * @author 刘立立
 * 
 */
@IocBean
public class StoreAction {

	private static final Log log = Logs.get();

	// @Inject("refer:menusServiceImpl")
	// public MenusServiceImpl menusService;

	// ************************************************************************************
	/**
	 * 
	 */
	@At("/seeMenuById")
	@Ok("json")
	public String seeMenuById(@Param("menuid") String menucode,
			HttpServletRequest req, HttpServletResponse res) {
		log.info("查看菜单项目....... menucode =" + menucode);
		return "";
	}

	// ************************************************************************************
	@At("/toCreateSysMenu")
	@Ok("jsp:jsp.sysmenus.sysMenusAdd")
	public void toCreateSysMenu(HttpServletRequest request) {
		// 简单跳转,获取菜单需要的 操作按钮，传递过去

	}

}
