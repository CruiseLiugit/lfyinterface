package com.liufuya.core.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

/**
 * Nutz 自定义过滤器,在 主模块 MainMoudle  上设置 
 * @author lililiu
 *
 */
public class ChrsetFilter implements ActionFilter {

	private static final Log log = Logs.get();
	
	public View match(ActionContext actionContext) {
		//获取请求响应对象
		HttpServletRequest req = actionContext.getRequest();
		HttpServletResponse res = actionContext.getResponse();
		
		log.debug("--------->字符过滤<---------");
		//设置请求响应对象的字符集
		try {
			req.setCharacterEncoding("UTF-8");
			res.setCharacterEncoding("UTF-8");
			
			res.setContentType("text/html; charset=UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
