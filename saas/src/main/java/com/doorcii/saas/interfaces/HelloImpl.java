package com.doorcii.saas.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.xfire.transport.http.XFireServletController;

public class HelloImpl implements IHello {
	
	 public String hello()  
	    {  
	    return "hello";  
	    }  
	  
	    public String helloTo(String name)  
	    {  
	    return " hello " + name + "!";  
	    }  
	  
	    private void example()  
	    {  
	     HttpServletRequest request = XFireServletController.getRequest();  
	     HttpSession session = request.getSession();  
	    }  
	  
	    public String getJsonData(String pageIndex,String pageSize)   
	    {  
	    String rtnValue = "";  
	      
	    rtnValue = "";  
	    for(int i=0;i<Integer.parseInt(pageSize);i++)  
	    {  
	        rtnValue = rtnValue + "{'lastname': 'last" + pageIndex + "-" + i + "', 'firstname': 'first" + pageIndex + "-" + i + "' },";  
	    }  
	    rtnValue = rtnValue + "{'lastname': 'last', 'firstname': 'last' }";  
	      
	    rtnValue = "{'context':["  + rtnValue + "],'pager':[{'totalRecord':'100','totalpage':'10','pageIndex':'" + pageIndex + "','pageSize':'10'}]}";  
	      
	    return rtnValue;  
	    }  
}
