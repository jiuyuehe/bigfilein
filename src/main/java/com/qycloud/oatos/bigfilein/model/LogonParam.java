package com.qycloud.oatos.bigfilein.model;



/**
 * 用户登录参数
 * @author yang
 *
 */
public class LogonParam extends NonceParam {

	/**
	 * 企业帐号
	 */
	private String entName;

	/**
	 * 用户帐号
	 */
	private String userName;
	
	/**
	 * 登陆密码（加密）
	 */
	private String password;

	/**
	 * 客户端标识
	 */
	private String clientId;

	/**
	 * 用户登录终端ip地址
	 */
	private String ip;

	/**
	 * IOS设备使用的设备标识
	 */
	private String deviceToken;

	/**
	 * 登录方式<br>
	 *
	 */
	private LogonMode mode;

	/**
	 * 设备型号
	 */
	private String deviceModel;
	
	public LogonParam() {
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public LogonMode getMode() {
		return mode;
	}

	public void setMode(LogonMode mode) {
		this.mode = mode;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

}
