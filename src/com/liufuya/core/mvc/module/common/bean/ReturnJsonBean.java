package com.liufuya.core.mvc.module.common.bean;

import java.util.List;

/**
 * 定义返回 JSON 字符串
 * 
 * @author lililiu
 * 
 */
public class ReturnJsonBean {
	private String status; // 是否成功 0：成功，other：失败
	private String info;// 对应的code描述,中文文字描述
	private List results; // Data 集合 ,接口一 返回数据

	// 接口二
	private String code;// 表示配送范围结果，1 表示可以配送，0 表示不能配送
	private String result; // 执行结果 ,接口二 返回数据

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
