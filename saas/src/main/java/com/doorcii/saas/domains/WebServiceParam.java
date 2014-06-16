package com.doorcii.saas.domains;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * webservice ²ÎÊý
 * @author chenjie
 */
@XStreamAlias("Service")
public class WebServiceParam {
	
	public WebServiceParam(String functionName) {
		this.functionName = functionName;
	}
	
	@XStreamAsAttribute
	private final String functionName;
	
	@XStreamImplicit(itemFieldName="value")
	private List<String> paramList;

	public String getFunctionName() {
		return functionName;
	}

	public List<String> getParamList() {
		return paramList;
	}

	public void setParamList(List<String> paramList) {
		this.paramList = paramList;
	}

	@Override
	public String toString() {
		return "WebServiceParam [functionName=" + functionName + ", paramList="
				+ paramList + "]";
	}
	
}
