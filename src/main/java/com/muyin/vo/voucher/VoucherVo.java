package com.muyin.vo.voucher;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class VoucherVo {
	/**
	 * 优惠券唯一标识
	 */
	private String voucherId;
	/**
	 * 优惠券类型
	 */
	private String voucherType;
	/**
	 * 优惠券金额(分)
	 */
	private String voucherAmt;

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherAmt() {
		return voucherAmt;
	}

	public void setVoucherAmt(String voucherAmt) {
		this.voucherAmt = voucherAmt;
	}
	
	
}
