package com.doorcii.saas.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PasswordHandler implements CallbackHandler {

	private Map<String,String> pwdMap = new HashMap<String,String>();
	
	
	@Override
	public void handle(Callback[] callback) throws IOException,
			UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callback[0];
        String id = pc.getIdentifer();
        pc.setPassword(pwdMap.get(id));
	}


	public void setPwdMap(Map<String, String> pwdMap) {
		this.pwdMap = pwdMap;
	}
	
}
