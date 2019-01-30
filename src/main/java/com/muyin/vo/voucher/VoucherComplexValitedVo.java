package com.muyin.vo.voucher;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.muyin.regular.EasyRegular;
import com.muyin.vo.BaseVo;

public class VoucherComplexValitedVo extends BaseVo{

	/**
	 * 优惠券唯一标识
	 */
	@Min(100000)
	@Max(999999)
	private int voucherId;
	/**
	 * 优惠券类型
	 */
	@NotNull(message="{voucher.type.isNull}")
	private int voucherType;
	/**
	 * 优惠券金额(分)
	 */
	@NotNull(message="{voucher.amt.isNull}")
	private int voucherAmt;
	
	/**
	 * 优惠券创建时间
	 */
	@NotNull(message="{voucher.createTime.isNull}")
	private Date createTime;
	
	@NotNull(message="{voucher.type.isNull}")
	@Pattern(regexp=EasyRegular.TIMEEXP,message="{voucher.createTime.wrong}")
	private String strDate;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
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
