package com.muyin.interceptor.base;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.muyin.utils.JsonConvertUtil;


public class BaseInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String ENCODING_UTF8 = "UTF-8";

	
	protected void writeResponse(HttpServletResponse response, Object outJB){
		String jsonStr = null;
		response.setContentType("application/json; charset=utf-8");
		try {
			logger.info(">>>>>>>>sendOutJB:{}", outJB);
			
			jsonStr = JsonConvertUtil.toJSon(outJB);
			
			logger.info(">>>>>>>>send:{}", jsonStr);
			response.setCharacterEncoding(ENCODING_UTF8);
			response.getOutputStream().write(jsonStr.getBytes(ENCODING_UTF8));
			
		} catch (IOException e) {
			logger.error("拦截器返回异常:",e);
		} 
	}
}
