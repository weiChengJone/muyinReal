package com.test.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml") 		//web-info下
//@ContextConfiguration("/config/applicationContext.xml")    						//resource下
@WebAppConfiguration
public class VoucherControllerTest {

	private static final Logger logger = LogManager.getLogger(VoucherControllerTest.class);

	@Test
	@Transactional   //标明此方法需使用事务  
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚 
	public void testOne(){
		logger.info("this is testOne log4j2");
		System.out.println("this is testOne");
	}
}
