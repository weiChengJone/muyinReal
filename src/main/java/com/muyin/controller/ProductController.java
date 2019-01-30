package com.muyin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {

	/**
	 * request:http://192.168.23.178:8080/muyin/product/query/1/1/10
	 * @param i
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/query/{id}/{page}/{pageSize}")
	@ResponseBody
	public String simple(@PathVariable("id") int i,@PathVariable("page") int page,@PathVariable("pageSize") int pageSize){
		
		System.out.println(i);
		System.out.println(page);
		System.out.println(pageSize);
		
		return "i:"+i + "-page:" + page + "-pageSize:"+pageSize;
	}
	
	/**
	 * http://192.168.23.178:8080/muyin/product/say/{"productOrderId":"1016873","productDeliveryId":"18125","status":"00"}
	 * @param msg
	 * @return
	 */
	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")  
    public @ResponseBody  
    String say(@PathVariable(value = "msg") String msg) {
		System.out.println("msg:"+msg);
        return "{\"msg\":\"you say:'" + msg + "'\"}";  
    } 

	/**
	 * http://192.168.23.178:8080/muyin/product/person?name=ywc
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST)  
    public @ResponseBody  
    String listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		String s = "name:"+name;
		System.out.println(s);
		return s;
	}

	
}
