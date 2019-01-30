package com.muyin.controller.easy.encryption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muyin.utils.JsonConvertUtil;
import com.muyin.vo.league.LeagueVo;

/**
 * easy包下 由简单加密拦截器 处理数据
 * 积分
 * @author ywc
 *
 */
@Controller
@RequestMapping("/league")
public class LeagueController {

	@RequestMapping(value = "/listLeague", method = RequestMethod.POST)  
    public @ResponseBody  
    Object listLeague(@RequestBody LeagueVo vo) {
		String s = "voucherId:"+vo.getUserId();
		s += ",voucherType:"+vo.getScore();
		s += ",voucherAmt:"+vo.getRecentUse();
		s += ",voucherAmt:"+vo.getRecentUseTime();
		System.out.println("String:"+s);
		System.out.println("json:"+JsonConvertUtil.toJSon(vo));
		return vo;
	}
}
