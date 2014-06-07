package com.liufuya.core.map.jsonbean;

/**
 * 百度  IP 地址定位
 * {
  "address" : "CN|吉林|长春|None|CERNET|1|None",
  "content" : {
    "address" : "吉林省长春市",
    "point" : {
      "x" : "125.31364243",
      "y" : "43.89833761"
    },
    "address_detail" : {
      "district" : "",
      "street_number" : "",
      "province" : "吉林省",
      "city" : "长春市",
      "city_code" : 53,
      "street" : ""
    }
  },
  "status" : 0
}
 * 
 * @author lililiu
 *
 */
public class IPAddress {
	private String address;
	private IPAddContent content;
	private String status;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public IPAddContent getContent() {
		return content;
	}
	public void setContent(IPAddContent content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
