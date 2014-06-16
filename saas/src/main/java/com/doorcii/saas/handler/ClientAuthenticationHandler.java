package com.doorcii.saas.handler;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;

public class ClientAuthenticationHandler extends AbstractHandler {
	
	private String username = "testname";
	private String password = "testpwd";
	private static final String USER_NAME = "_user_name_";
	private static final String PASS_WORD = "_password_";
	private static final String IP = "_ip_";
	private static final String PHONE = "_phone_";
	
	private String ip;
	private String phone;
	
	public ClientAuthenticationHandler(String ip,String phone) {
		this.ip = ip;
		this.phone = phone;
	}
	
	@Override
	public void invoke(MessageContext ctx) throws Exception {
        Element el = new Element("header"); 
        ctx.getOutMessage().setHeader(el); 
        Element auth = new Element("AuthenticationToken"); 
        Element username_el = new Element(USER_NAME); 
        username_el.addContent(username); 
        Element password_el = new Element(PASS_WORD); 
        password_el.addContent(password); 
        Element ip_ = new Element(IP);
        ip_.addContent(this.ip);
        Element phone_ = new Element(PHONE);
        phone_.addContent(this.phone);
        auth.addContent(username_el); 
        auth.addContent(password_el); 
        auth.addContent(ip_);
        auth.addContent(phone_);
        el.addContent(auth); 
	}
}
