package com.qycloud.oatos.bigfilein.model;



import com.qycloud.oatos.bigfilein.utils.Json;

import java.io.Serializable;

/**
 * 所有DTO的父类
 * @author yang
 *
 */
public class BaseDTO<T> implements IBaseDTO, Serializable {
	/**
	 * 状态码，<br>
	 * OK：成功；<br>
	 * 其他值：错误码
	 */
	private String statusCode = "OK";

	/**
	 * 错误消息，仅作为提示
	 */
	private String error;

	/**
	 * 响应内容
	 */
	private T data;

	public BaseDTO() {
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toJson() {
		try {
			return Json.toJson(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{}";
	}

}
