package com.muyin.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import com.muyin.base.rsp.OutCome;
import com.muyin.bean.user.UserBean;
import com.muyin.interceptor.base.BaseInterceptor;

public class LoginInterceptor extends BaseInterceptor{
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		logger.info(">>>>>>>>>>>进入stool登录拦截器<<<<<<<<<<<<");

		logger.info(">>>>>>>>>>>{}<<<<<<<<<<<<", getReqIpAddr(request));

		if (checkSession(request, response))
			return false;
		
		return super.preHandle(request, response, handler);
	}

	
	private boolean checkSession(HttpServletRequest request,
			HttpServletResponse response) {
		
		String ruri = request.getRequestURI();

		String mothed = request.getMethod();

		HttpSession session = request.getSession();

		String requestType = request.getHeader("X-Requested-With");

		UserBean ubean = (UserBean) session
				.getAttribute("user");

		// 已登录
		if (null != ubean)
			return false;

		// 根据不同请求类型获取请求参数
//		Map<String, Object> paramMap = getParam(mothed, request);

		logger.info(">>>>param<<<<:{},uri:{},mothed:{},requestType:{}",
				"", ruri, mothed, requestType);

		OutCome ocome = new OutCome();
		ocome.setRespCode("2002");
		ocome.setRespDesc("请登录");
		
		writeResponse(response, ocome);

		return true;
	}
	
	
	/**
	 * 获取IP
	 * @param request
	 * @return
	 */
	protected String getReqIpAddr(HttpServletRequest request) {
        String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (!StringUtils.hasText(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (!StringUtils.hasText(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (!StringUtils.hasText(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
            logger.error("",e);
        }
        return ip;
    }
}
