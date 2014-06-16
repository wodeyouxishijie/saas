package webservice.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doorcii.saas.domains.WebServiceResult;
import com.doorcii.saas.utils.XStreamUtils;
import com.doorcii.saas.xstream.convertor.MapCustomConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.mapper.DefaultMapper;

public class XStreamTest {
	
	public static void main(String[] args) {
		
		XStream xstream = XStreamUtils.getDefaultXStream();
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("key1", "value1");
		map1.put("key2", "value2");
		map1.put("key3", "value3");
		
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("map2key1", "map2value1");
		map2.put("map2key2", "map2value2");
		map2.put("map2key3", "map2value2");
		
		list.add(map1);
		list.add(map2);
		
		xstream.alias("list", Map.class);
		xstream.registerConverter(new MapCustomConverter(new DefaultMapper(new ClassLoaderReference(XStreamTest.class.getClassLoader()))));
		WebServiceResult wsr = new WebServiceResult("0");
		wsr.setModelWrapperList(list);
		String xml = xstream.toXML(wsr);
		System.out.println(xml);
		
		
	}
}
