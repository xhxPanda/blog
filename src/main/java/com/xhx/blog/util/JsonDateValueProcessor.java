package com.xhx.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.xhx.blog.constant.Constants;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

//
public class JsonDateValueProcessor implements JsonValueProcessor {  
    private String format = Constants.DATE_FORMAT;
    
    public JsonDateValueProcessor() {  
        super();  
    }  
      
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    } 
    
	public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
      
	private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);    
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    }  
  
}  
