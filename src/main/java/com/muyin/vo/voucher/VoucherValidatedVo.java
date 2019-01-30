package com.muyin.vo.voucher;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VoucherValidatedVo {

	/**
	 * 优惠券唯一标识
	 */
	@Min(100000)
	@Max(999999)
	private int voucherId;
	/**
	 * 优惠券类型
	 */
	@NotNull(message="优惠券类型错误")
	private int voucherType;
	/**
	 * 优惠券金额(分)
	 */
	@NotNull(message="{优惠券金额(分)不存在}")
	private int voucherAmt;
	
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public int getVoucherType() {
		return voucherType;
	}
	public void setVoucherType(int voucherType) {
		this.voucherType = voucherType;
	}
	public int getVoucherAmt() {
		return voucherAmt;
	}
	public void setVoucherAmt(int voucherAmt) {
		this.voucherAmt = voucherAmt;
	}
	
	
}
