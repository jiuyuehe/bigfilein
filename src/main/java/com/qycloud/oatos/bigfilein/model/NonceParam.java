package com.qycloud.oatos.bigfilein.model;


/**
 * 加密参数
 * @author yang
 *
 */
public class NonceParam extends BaseParam {

	/**
	 * 随机串
	 */
	private String nonce;

	/**
	 * 用户验证码
	 */
	private String hashKey;


	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}


}
