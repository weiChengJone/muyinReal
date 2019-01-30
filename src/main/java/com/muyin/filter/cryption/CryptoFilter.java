//package com.muyin.filter.cryption;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.bypay.foreign.util.ErrorCode;
//import com.bypay.foreign.util.OutResponse;
//import com.bypay.foreign.warpper.RequestWrapper;
//import com.bypay.foreign.warpper.ResponseWrapper;
//import com.google.gson.Gson;
//
//public class CryptoFilter extends BaseFilter {
//
//	private static final Logger LOG = LogManager.getLogger(CryptoFilter.class);
//
//	@Override
//	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) {
//
//		LOG.info("start-------------加密解密过滤器------------start");
//
//		if (!(srequest instanceof HttpServletRequest))
//			return;
//
//		HttpServletRequest request = (HttpServletRequest) srequest;
//
//		HttpServletResponse response = (HttpServletResponse) sresponse;
//
//		doExecute(request, response, chain);
//
//		LOG.info("end-------------加密解密过滤器------------end");
//
//	}
//
//	private void doExecute(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
//
//		try {
//			
//			String reqid = request.getHeader("X_REQUEST_ID");
//			
//			String crytoType = request.getHeader("CRYTO_TYPE");
//			
//			response.setHeader("X_REQUEST_ID", reqid);
//			
//			EntryBean bean;
//			
//			if("fixed".equals(crytoType)){//固定模式
//				bean = entry(request);
//			}else{
//				bean = entry(request, response);
//			}
//			
//			if(null==bean)return;
//			
//			bean.setReqid(reqid);
//			
//			RequestWrapper reqw = new RequestWrapper(request, bean.getContent().getBytes());
//
//			ResponseWrapper resw = new ResponseWrapper(response);
//
//			chain.doFilter(reqw, resw);
//
//			export(response, resw, bean);
//
//		} catch (Exception e) {
//
//			LOG.error("加密解密过滤器异常", e);
//
//			write(response);
//			
//		} finally {
//
//			write(response);				
//
//		}
//	}
//
//	private void write(HttpServletResponse response){
//		
//		try {
//			
//			response.setContentType("application/json;charset=utf-8");
//			
//			Gson gson = new Gson();
//			
//			OutResponse ores = new OutResponse(ErrorCode.DECRYPT_ERROR);
//					
//			PrintWriter out = response.getWriter();
//
//			out.write(gson.toJson(ores));
//			
//			out.flush();
//
//			out.close();
//			
//		} catch (IOException e) {
//			
//			LOG.error("加密解密过滤器流关闭异常-2", e);
//			
//		}
//		
//		
//		
//	}
//	
//}
