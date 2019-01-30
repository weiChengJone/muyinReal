package com.muyin.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muyin.base.rsp.OutCome;
import com.muyin.validategroup.voucher.VoucherInsertGroup;
import com.muyin.vo.voucher.VoucherComplexValitedVo;
import com.muyin.vo.voucher.VoucherComplexValitedWithGroupVo;
import com.muyin.vo.voucher.VoucherValidatedVo;
import com.muyin.vo.voucher.VoucherVo;

/**
 * 添加登录拦截器 只拦截 this 做测试
 * @author ywc 
 * 
 */
@Controller
@RequestMapping("voucher")
public class VoucherController {

	/** 信息转换器 json封装数据进入对象
	 * 1.出现415
	 *     解决:请求type设置为application/json
	 *         : data:JSON.stringify(this.queryParam) 转对象为json字符串
	 *         : springmvc配置文件加一个StringHttpMessageConverter            ---》https://blog.csdn.net/qq_22585453/article/details/78478324
	 *         : 更多原因                                                                                                          --->https://blog.csdn.net/Jintao_Ma/article/details/52119297
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/listVoucher", method = RequestMethod.POST)  
    public @ResponseBody  
    Object listVoucher(@RequestBody VoucherVo vo) {
		String s = "voucherId:"+vo.getVoucherId();
		s += ",voucherType:"+vo.getVoucherType();
		s += ",voucherAmt:"+vo.getVoucherAmt();

		System.out.println(s);
		return vo;
	}
	
	/**
	 * 添加validated做参数校验(简单版本 -->size  and null 校验)
	 *  1.遇到中文返回乱码
	 *     解决：局部添加 produces="text/html;charset=UTF-8"
	 *           全局 修改配置 添加 value="text/html;charset=UTF-8" ---->没啥用，StringHttpMessageConverter 使用的是iso-8859-1字符集
	 * @param vo
	 * @param bindingResult
	 * @return
	 */
//	@RequestMapping(value = "/listVoucherValidated", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
	@RequestMapping(value = "/listVoucherValidated", method = RequestMethod.POST)  
    public @ResponseBody  
    Object listVoucherValidated(@Validated @RequestBody VoucherValidatedVo vo,BindingResult bindingResult) throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//返回String乱码
			String error = "";
			//返回Map 不乱码
//			Map<String,String> map = new HashMap<String,String>();
			for (ObjectError objectError : allErrors) {
				System.out.println("直接取出:"+objectError.getDefaultMessage());			
				//System.out.println("打乱再生成"+ new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),"UTF-8"));
				
				error += objectError.getDefaultMessage();
//				map.put(objectError.toString(), objectError.getDefaultMessage());
			}			
			return error;
		}
		
		String s = "voucherId:"+vo.getVoucherId();
		s += ",voucherType:"+vo.getVoucherType();
		s += ",voucherAmt:"+vo.getVoucherAmt();

		System.out.println(s);
		return vo;
	}
	
	/**
	 * 1.遇到返回406
	 *    解决： 加了value="text/html;charset=UTF-8，当返回vo是，不适配
	 * 2.不传字段值，不返回错误信息
	 *    解决：不传值字段为int型
	 * 3.取不到messageSource文件值
	 * 	   解决: 修改classpath 为 classpath*-->没有解决
	 * http://192.168.23.178:8080/muyin/voucher/listVoucherComplexValidated
	 * {"voucherId":"111111","voucherAmt":""}
	 * {"respCode":null,"respDesc":null,"date":"\"优惠券类型不存在\"\"优惠券日期不存在\""}
	 * @param vo
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/listVoucherComplexValidated", method = RequestMethod.POST)  
    public @ResponseBody  
    Object listVoucherComplexValidated(@Validated @RequestBody VoucherComplexValitedVo vo,BindingResult bindingResult) throws Exception{
		
		OutCome outCome = new OutCome();
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//返回String乱码
			String error = "";
			//返回Map 不乱码
			for (ObjectError objectError : allErrors) {
				System.out.println("直接取出:"+objectError.getDefaultMessage());			
//				System.out.println("打乱再生成"+ new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),"UTF-8"));
				
				error += objectError.getDefaultMessage();
			}	
			
			outCome.setDate(error);
			return outCome;
		}
		
		String s = "voucherId:"+vo.getVoucherId();
		s += ",voucherType:"+vo.getVoucherType();
		s += ",voucherAmt:"+vo.getVoucherAmt();

		System.out.println(s);
		outCome.setDate(vo);
		return outCome;
	}
	
	/**
	 * 添加分组
	 * @param vo
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/listVoucherComplexWithGroupValidated", method = RequestMethod.POST)  
    public @ResponseBody  
    Object listVoucherComplexWithGroupValidated(@Validated({VoucherInsertGroup.class}) @RequestBody VoucherComplexValitedWithGroupVo vo,BindingResult bindingResult) throws Exception{
		
		OutCome outCome = new OutCome();
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			//返回String乱码
			String error = "";
			//返回Map 不乱码
			for (ObjectError objectError : allErrors) {
				System.out.println("直接取出:"+objectError.getDefaultMessage());			
//				System.out.println("打乱再生成"+ new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),"UTF-8"));
				
				error += objectError.getDefaultMessage();
			}	
			
			outCome.setDate(error);
			return outCome;
		}
		
		String s = "voucherId:"+vo.getVoucherId();
		s += ",voucherType:"+vo.getVoucherType();
		s += ",voucherAmt:"+vo.getVoucherAmt();

		System.out.println(s);
		outCome.setDate(vo);
		return outCome;
	}
}
