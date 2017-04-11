package net.luis.platform.webservice.impl;

import javax.jws.WebService;

import net.luis.platform.webservice.CommonWebService;

/**
 * @CreateTime：2017年3月29日 下午5:04:16
 * @Author sai.liu
 * @ProjectPackage：net.luis.webservice.ws.impl.CommonWebServiceImpl.java @Description：
 */
@WebService
public class CommonWebServiceImpl implements CommonWebService {

	@Override
	public String sayHello(String name) {
		System.out.println("WebService sayHello " + name);
		return "sayHello " + name;
	}

	@Override
	public String save(String name, String pwd) {
		System.out.println("WebService save " + name + "， " + pwd);
		return "save Success";
	}

}
