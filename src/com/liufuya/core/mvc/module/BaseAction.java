package com.liufuya.core.mvc.module;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao; //配置好的 基础 Dao
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Attr;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.annotation.Ok;


/**
 * 基础 action
 * @author lililiu
 * http://localhost:8080/lfyinterface/
 */
@IocBean
public class BaseAction {

	private static final Log log = Logs.get();
	
	/**
	 * 项目启动时的欢迎页面
	 * @return
	 */
	@At("/") 
	@Ok("jsp:jsp.index")
	public void index(){
		log.debug("=======>首页<=======");
	}
	
	//-------------------index.jsp 页面跳转---------------------------
	//门店地图
	@At("/map1")
	@Ok("jsp:store.map1")
	public void map1() {}
	
	
}
