package com.muyin.base.rsp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OutCome {

	private String respCode;
	
	private String respDesc;
	
	private Object Date;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public Object getDate() {
		return Date;
	}

	public void setDate(Object date) {
		Date = date;
	}
	
}
