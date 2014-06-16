package com.doorcii.saas.handler;

import org.apache.log4j.Logger;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;

import com.doorcii.saas.domains.CategoryErrors;

public class AuthenticationHandler extends AbstractHandler {
	
	public static final Logger logger = Logger.getLogger("WebService -access -");
	
	private final String wsname;
	private final String wspwd;
	
	private static final String AUTH_TOKEN = "AuthenticationToken";
	
	private static final String USER_NAME = "_user_name_";
	
	private static final String PASS_WORD = "_password_";
	
	private static final String IP = "_ip_";
	private static final String PHONE = "_phone_";
	

	
	
	public AuthenticationHandler (String wsname,String wspwd) {
		this.wsname = wsname;
		this.wspwd = wspwd;
	}
	
	@Override
	public void invoke(MessageContext cfx) throws Exception {
		 if (cfx.getInMessage().getHeader() == null) {
		    throw new org.codehaus.xfire.fault.XFireFault("Error.code="+CategoryErrors.EXCEPTIONS.getCode(),
		      org.codehaus.xfire.fault.XFireFault.SENDER);
		 }
		 Element token = cfx.getInMessage().getHeader().getChild(AUTH_TOKEN);
		   if (token == null) {
		    throw new org.codehaus.xfire.fault.XFireFault("Error.code="+CategoryErrors.WS_TOKEN_ERROR.getCode(),
		      org.codehaus.xfire.fault.XFireFault.SENDER);
		 }

		 String username = token.getChild(USER_NAME).getValue();
		 String password = token.getChild(PASS_WORD).getValue();
		 String ip = token.getChild(IP).getValue();
		 String phone = token.getChild(PHONE).getValue();
		 if (!(username.equals(wsname) && password.equals(wspwd))) {
		    	throw new org.codehaus.xfire.fault.XFireFault("Error.code"+CategoryErrors.CERTI_ERROR.getMsg(),
				           org.codehaus.xfire.fault.XFireFault.SENDER);
		 }
		 logger.info("******ip="+ip+",phone="+phone+" ********");
	}

}
