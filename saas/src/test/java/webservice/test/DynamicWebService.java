package webservice.test;

import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

public class DynamicWebService {
	
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8080/coreService.ws?wsdl";
		try {
			
			HttpURLConnection httpConnection = (HttpURLConnection)new URL(url).openConnection();
	        httpConnection.setReadTimeout(3000);
	        httpConnection.setConnectTimeout(3000);
	        httpConnection.connect();
	        Client _client = new Client(httpConnection.getInputStream(), null);
	        _client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, String.valueOf(3000));//设置发送的超时限制,单位是毫秒;
	        _client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE, "true");
	        _client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE, "true");
	        Object[] obj = _client.invoke("invokeInterface", new Object[]{"123"});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
