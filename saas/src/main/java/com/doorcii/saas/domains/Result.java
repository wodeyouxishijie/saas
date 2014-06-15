package com.doorcii.saas.domains;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果集
 * @author Jacky
 * 2014-5-9
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 8177482925169573702L;

	/**
	 * 状态
	 * true:成功
	 * false:失败
	 */
	private boolean success = false;
	
	/**
	 * 返回错误码
	 */
	private int errorCode;
	
	private String errorMsg;
	
	/**
	 * 返回key-value值
	 */
	private Map<String,Object> modelMap = new HashMap<String,Object>();
	
	/**
	 * 返回默认结果
	 */
	private T  value;
	
	public Result() {}
	
	public Result(boolean success) {this.success = success;}
	
	public Result(int errorCode) {
		this.success = false;
		this.errorCode = errorCode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 构建默认对象
	 * @return
	 */
	public static <E> Result<E> getDefaultResult() {
		return new Result<E>();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Map<String, Object> getModelMap() {
		return modelMap;
	}

	public void setModelMap(Map<String, Object> modelMap) {
		this.modelMap = modelMap;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Result [success=" + success + ", errorCode=" + errorCode
				+ ", modelMap=" + modelMap + ", value=" + value + "]";
	}
}
