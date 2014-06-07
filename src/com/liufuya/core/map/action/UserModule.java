package com.liufuya.core.map.action;

import java.util.Date;

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
 * 作为接受页面请求的控制器
 * 测试使用的 action
 * @author lililiu
 * http://localhost:8080/lfyinterface/user/ping
 */
@IocBean
@At("/user")
public class UserModule {

	private static final Log log = Logs.get();
	
	/**
	 * 项目启动时的验证，搭建项目框架使用，返回当前系统时间
	 * @return
	 */
	@At("/ping") 
	public Object ping(){
		log.debug("=======>后台<=======");
		return new Date();
	}
	
}
