package com.muyin.vo.league;

import java.util.Date;

public class LeagueVo {

	private int userId;
	private int score;
	private String recentUse;
	private Date recentUseTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRecentUse() {
		return recentUse;
	}
	public void setRecentUse(String recentUse) {
		this.recentUse = recentUse;
	}
	public Date getRecentUseTime() {
		return recentUseTime;
	}
	public void setRecentUseTime(Date recentUsetime) {
		this.recentUseTime = recentUsetime;
	}
	
	
}
