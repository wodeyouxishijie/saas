package com.doorcii.saas.domains;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ���ؽ����
 * @author Jacky
 * 2014-5-9
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 8177482925169573702L;

	/**
	 * ״̬
	 * true:�ɹ�
	 * false:ʧ��
	 */
	private boolean success = false;
	
	/**
	 * ���ش�����
	 */
	private int errorCode;
	
	private String errorMsg;
	
	/**
	 * ����key-valueֵ
	 */
	private Map<String,Object> modelMap = new HashMap<String,Object>();
	
	/**
	 * ����Ĭ�Ͻ��
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
	 * ����Ĭ�϶���
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
