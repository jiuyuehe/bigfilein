package com.qycloud.oatos.bigfilein.model;



/**
 * <b>function:</b> 密码加密模型
 * @author huhao <a href="mailto:mousycoder@foxmail.com">发送邮件</a>
 * @createDate 2013-11-25 下午3:53:27
 * @file EncryptModel.java
 * @package com.qycloud.oatos.server.test
 * @project server
 * @blog http://weibo.com/mousycoder
 * @version 2.3	
 */
@SuppressWarnings("serial")
public class EncryptModel extends NonceParam {

	/**
	 * 加密后的密码
	 */
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
