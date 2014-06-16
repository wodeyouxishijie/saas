package com.doorcii.saas.domains;

import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("result")
public class WebServiceResult {
	
	public static final String SUCCESS = "0";
	
	public static final String FAILED = "-1";
	
	/**
	 * 状态位
	 */
	@XStreamAlias("success")
	private String success;
	
	/**
	 * 错误消息
	 */
	@XStreamAlias("errorMsg")
	private String errorMsg;
	
	/**
	 * 包裹对象
	 */
	@XStreamAlias("modelWrapper")
	private List<Map<String,String>> modelWrapperList;
	
	public WebServiceResult(String success) {
		this.success = success;
	}
	
	public static WebServiceResult getDefaultWebServiceResult() {
		WebServiceResult r = new WebServiceResult(FAILED);
		r.setErrorMsg("DEFAULT_ERROR");
		return r;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<Map<String, String>> getModelWrapperList() {
		return modelWrapperList;
	}

	public void setModelWrapperList(List<Map<String, String>> modelWrapperList) {
		this.modelWrapperList = modelWrapperList;
	}
	
}
