package com.muyin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {

	private static final Logger logger = LogManager.getLogger(OrderInfoController.class);
	
	@Autowired
    HttpServletRequest request;
	
	@RequestMapping("/query")
	@ResponseBody
	public String queryOrderInfo(){
		
		return "it's queryOrderInfo";
	}
	
	/**request:http://192.168.23.178:8080/muyin/orderInfo/insert
	 *  返回的String 根据 springmvc 配置视图解析器 返回映射页面
	 * @return
	 */
	@RequestMapping("/insert")
    public String doLogin() {
		logger.info("this is a insert for 订单");
        return "jsp/login";
    }
}
