package com.push.model;

public class FcmDTO {
	private String user_key;
	private String token_id;
	private int use_push;
	private String push_time;
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getToken_id() {
		return token_id;
	}
	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}
	public int getUse_push() {
		return use_push;
	}
	public void setUse_push(int use_push) {
		this.use_push = use_push;
	}
	public String getPush_time() {
		return push_time;
	}
	public void setPush_time(String push_time) {
		this.push_time = push_time;
	}
	@Override
	public String toString() {
		return "FcmDTO [user_key=" + user_key + ", token_id=" + token_id + ", use_push=" + use_push + ", push_time="
				+ push_time + "]";
	}
}
