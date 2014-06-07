package com.liufuya.common;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 假设已有HttpServletRequest对象request（Jsp中默认）
  String ipaddress = request.getRemoteAddr();
  
  但是这一方法有致命缺陷，就是不能穿透代理服务器。当系统架构中使用了代理服务器时，上述方法抓到的就是代理服务器的IP地址。
  
  经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的 IP，
  服务器端应用也无法直接通过转发请求的地址返回给客户端。
  
  但是在转发请求的HTTP头信息中，增加了X－FORWARDED－FOR信息。
  用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
  
 * @author lililiu
 *
 */
public class IPAddressUtil {
	/**
	 * 获取真正的客户端 IP 地址
	 * 
	 * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，
	 * 究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。如：
	 * X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130, 192.168.1.100
	 * 用户真实IP为： 192.168.1.110 
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteAddress(HttpServletRequest request) {
		String ip;
		//获取请求头信息中的 x-forwarded-for
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		}else{
			ip = request.getHeader("x-forwarded-for");
			//System.out.println("getHeader :"+ip);
			if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
				ip = request.getHeader("Proxy-Client-IP");
				//System.out.println("Proxy-Client-IP ="+ip);
			}
			if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
				ip = request.getHeader("WL-Proxy-Client-IP");
				//System.out.println("WL-Proxy-Client-IP ="+ip);
			}
			if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")){
				ip = request.getRemoteAddr();
				//System.out.println("getRemoteAddr ="+ip);
			}
		} 
		return ip;
	}

	/**
	 * 获取用户电脑网卡的 MAC  地址
	 * @param ip
	 * @return
	 */
	public  String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}

	
	/*
	 * @return 本机IP
	 * 
	 * @throws SocketException
	 */
	public  String getRealIp() throws SocketException {

		String localip = null;// 本地IP，如果没有配置外网IP则返回它

		String netip = null;// 外网IP

		Enumeration<NetworkInterface> netInterfaces =NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP

		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress()&& !ip.isLoopbackAddress()&& ip.getHostAddress().indexOf(":") == -1) {// 外网IP
					netip = ip.getHostAddress();
					finded = true;
					break;
				} else if (ip.isSiteLocalAddress()&& !ip.isLoopbackAddress()&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
					localip = ip.getHostAddress();
				}
			}
		}

		if (netip != null && !"".equals(netip)) {
			return netip;
		} else {
			return localip;

		}

	}

}
