package net.luis.platform.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @CreateTime：2017年3月29日 下午5:02:35
 * @Author sai.liu
 * @ProjectPackage：net.luis.webservice.ws.CommonWebService.java
 * @Description：使用@WebService注解标注WebServiceI接口
 */
@WebService
public interface CommonWebService {
	// 使用@WebMethod注解标注WebServiceI接口中的方法
	@WebMethod
	public String sayHello(String name);

	@WebMethod
	public String save(String name, String pwd);
}
