package com.doorcii.saas.xstream.convertor;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class MapCustomConverter extends AbstractCollectionConverter {

	public MapCustomConverter(Mapper mapper) {  
        super(mapper);  
    } 
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
	      return type.equals(HashMap.class)  
	                || type.equals(Hashtable.class)  
	                || type.getName().equals("java.util.LinkedHashMap")  
	                || type.getName().equals("sun.font.AttributeMap") ;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Map map = (Map) source;  
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {  
            Entry entry = (Entry) iterator.next();  
            ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);  
            writer.addAttribute("value", entry.getValue().toString());  
            writer.endNode();  
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		 Map<String,String> map = (Map<String,String>) createCollection(context.getRequiredType());  
	     populateMap(reader, context, map);  
	     return map;  
	}

	protected void populateMap(HierarchicalStreamReader reader, UnmarshallingContext context, Map<String,String> map) {  
        while (reader.hasMoreChildren()) {  
            reader.moveDown();  
            String key = reader.getNodeName();  
            String value = reader.getAttribute("value");  
            map.put(key, value);  
            reader.moveUp();  
        }  
    }  
}
