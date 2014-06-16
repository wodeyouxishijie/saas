package com.doorcii.saas.interfaces;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.doorcii.saas.domains.Result;
import com.doorcii.saas.domains.WebServiceParam;
import com.doorcii.saas.domains.WebServiceResult;
import com.doorcii.saas.manager.CommonManager;
import com.doorcii.saas.utils.XStreamUtils;
import com.doorcii.saas.xstream.convertor.MapCustomConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.DefaultMapper;

public class ServiceInterfacesImpl implements ServiceInterfaces {
	
	public static final Logger logger = Logger.getLogger("WEBSERVICE-LOG");
	
	private CommonManager commonManager;
	
	/**
	 * <Service functionName="xxx">
	 * 	<value>xxx</value>
	 *  <value>xxx</value>
	 * </Service>
	 */
	@Override
	public String invokeInterface(String xmlRequest) {
		logger.info("********************************");
		logger.info(xmlRequest);
		if(StringUtils.isBlank(xmlRequest)) {
			return "PARAM ERROR ,PARAM IS NULL";
		}
		XStream xstream = XStreamUtils.getDefaultXStream();
		xstream.alias("Service", WebServiceParam.class);
		WebServiceParam param = (WebServiceParam)xstream.fromXML(xmlRequest);
		logger.info(param);
		if(!checkParam(param)) {
			WebServiceResult wsr = WebServiceResult.getDefaultWebServiceResult();
			wsr.setErrorMsg("PARAM ERROR");
			return xstream.toXML(wsr);
		}
		WebServiceResult wsr =  WebServiceResult.getDefaultWebServiceResult();
		List<String> paramList = param.getParamList();
		Result<List<Map<String, String>>> result = commonManager.invokeProcedureList(param.getFunctionName(),getStrings(paramList));
		if(result.isSuccess()) {
			xstream.alias("list", Map.class);
			xstream.registerConverter(new MapCustomConverter(new DefaultMapper(new ClassLoaderReference(this.getClass().getClassLoader()))));
			wsr.setSuccess(WebServiceResult.SUCCESS);
			wsr.setModelWrapperList(result.getValue());
		} else {
			wsr.setSuccess(WebServiceResult.FAILED);
			wsr.setErrorMsg(result.getErrorMsg());
		}
		logger.info("********************************");
		return xstream.toXML(wsr);
	}
	
	private String[]  getStrings(List<String> paramList) {
		if(CollectionUtils.isNotEmpty(paramList)) {
			String[] s = new String[paramList.size()];
			for(int i=0;i<s.length;i++) {
				s[i] = paramList.get(i);
			}
			return s;
		}
		return new String[]{};
	}
	
	private boolean checkParam(WebServiceParam param) {
		if(null != param && StringUtils.isNotBlank(param.getFunctionName())) {
			return true;
		}
		return false;
	}

	public void setCommonManager(CommonManager commonManager) {
		this.commonManager = commonManager;
	}
	
}
