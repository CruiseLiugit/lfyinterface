package com.liufuya.core.mvc.module.common.bean;

import java.util.List;

/**
 * 定义返回 JSON 字符串
 * 
 * @author lililiu
 * 
 */
public class ReturnJsonBean {
	private String code;  //是否成功 0：成功，other：失败
	private String codeDesc;//对应的code描述,中文文字描述
	private List results; //Data 集合
	private String result; //执行结果

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
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
