package com.qycloud.oatos.bigfilein.model.oatos;


import com.qycloud.oatos.bigfilein.utils.Json;

/**
 * 基本参数
 * 
 * @author yang
 * 
 */
public class BaseParam implements IBaseDTO {

	/**
	 * 企业id<br>
	 * 不需传递
	 */
	private Long entId;

	/**
	 * 用户id<br>
	 * 不需传递
	 */
	private Long userId;

	/**
	 * 语言<br>
	 *
	 */


	public BaseParam() {
	}

	public BaseParam(Long entId, Long userId) {
		this.entId = entId;
		this.userId = userId;
	}

	public String toJson() {
		try {
			return Json.toJson(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}

	public Long getEntId() {
		return entId;
	}

	public void setEntId(Long entId) {
		this.entId = entId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}



}
