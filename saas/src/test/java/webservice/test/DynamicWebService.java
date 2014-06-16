package webservice.test;

import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import com.doorcii.saas.domains.WebServiceParam;
import com.doorcii.saas.handler.ClientAuthenticationHandler;
import com.doorcii.saas.utils.XStreamUtils;
import com.thoughtworks.xstream.XStream;

public class DynamicWebService {
	
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8081/saas/coreService.ws?wsdl";
		try {
			HttpURLConnection httpConnection = (HttpURLConnection)new URL(url).openConnection();
	        httpConnection.setReadTimeout(3000);
	        httpConnection.setConnectTimeout(3000);
	        
	        httpConnection.connect();
	        Client _client = new Client(httpConnection.getInputStream(), null);
	        _client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, String.valueOf(3000));//设置发送的超时限制,单位是毫秒;
	        _client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
	        _client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");
	        _client.addOutHandler(new ClientAuthenticationHandler("127.0.0.1","15168381275"));
	        WebServiceParam param = new WebServiceParam("testFunction");
	        XStream xstream = XStreamUtils.getDefaultXStream();
	        Object[] obj = _client.invoke("invokeInterface", new Object[]{xstream.toXML(param)});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
