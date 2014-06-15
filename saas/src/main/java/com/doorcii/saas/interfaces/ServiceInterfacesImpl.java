package com.doorcii.saas.interfaces;

import org.apache.log4j.Logger;

public class ServiceInterfacesImpl implements ServiceInterfaces {
	
	public static final Logger logger = Logger.getLogger("WebService-");
	
	@Override
	public String invokeInterface(String xmlRequest) {
		logger.info(xmlRequest);
		return null;
	}
}
