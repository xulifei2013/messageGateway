package com.chinapnr.mg.api.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json处理
 * 
 * @author jian.fan
 *
 */
@SuppressWarnings(value={"unchecked"})  
public class JsonProcessUtil {
	private static ObjectMapper mapper;
	private static Logger logger =LoggerFactory.getLogger(JsonProcessUtil.class);
	/**
     * 
     * 
     * @param createNew 是否创建一个新的Mapper  
     * @return  
     */
    private static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper ==null) {
            mapper =new ObjectMapper();
        }
        return mapper;
    }
	
	public static String listToJson(List<?> list){
		String jsonStr =null;
		
		try{
			ObjectMapper objectMapper =new ObjectMapper();
			jsonStr =objectMapper.writeValueAsString(list);
			
		}catch(Exception e){
			
		}
		
		return jsonStr;
	}
	
	public static Map<String, Object> jsonToMap(String str) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();  
		//允许使用未带引号的字段名
		mapper.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
		//允许使用单引号
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String,Object> map = mapper.readValue(str, HashMap.class);//转成map
		return map;
	}
	public static Object mapToObjectN(Map<String, Object> map, Class<?> beanClass) throws Exception {    
		if (map == null)  
			return null;  
		
		Object obj = beanClass.newInstance();  
		
		org.apache.commons.beanutils.BeanUtils.populate(obj, map);  
		
		return obj;  
	}    
	public static Object mapToObjectN1(Map<String, String> map, Class<?> beanClass) throws Exception {    
	    if (map == null)  
	        return null;  

	    Object obj = beanClass.newInstance();  

	    org.apache.commons.beanutils.BeanUtils.populate(obj, map);  

	    return obj;  
	}    
    
	public static Object mapToObjectN2(Map<String, Object> map, Class<?> beanClass, String... ignoreProperties) throws Exception {    
	    if (map == null)  
	        return null;  

	    Object obj = beanClass.newInstance();  

	    BeanUtil.copyPropertiesToObj(map,obj,ignoreProperties);

	    return obj;  
	}    
	  
	public static Map<?, ?> objectToMapN(Object obj) {  
	    if(obj == null)  
	        return null;   

	    return new org.apache.commons.beanutils.BeanMap(obj);  
	}    
	
	public static Map<String, Object> objectToMap(Object obj) throws Exception {    
        if(obj == null){    
            return null;    
        }   
        Map<String, Object> map = new HashMap<String, Object>();    
        Field[] declaredFields = obj.getClass().getDeclaredFields();    
        for (Field field : declaredFields) {    
            field.setAccessible(true);  
            map.put(field.getName(), field.get(obj));  
        }    
        return map;  
    }  

	public static String beanToJson(Object object){
		String jsonStr =null;
		try{
			ObjectMapper objectMapper =new ObjectMapper();
			jsonStr =objectMapper.writeValueAsString(object);
		}catch(Exception e){
			
		}
		return jsonStr;
	}
	
	/**
     * 解析json为Object
     * 
     * @param jsonStr
     * @return
     */
    public static Object jsonToObject(String jsonStr, Class<?> clazz) {
        Object obj =null;
        ObjectMapper objectMapper =getMapperInstance(false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            obj =objectMapper.readValue(jsonStr, clazz);
        } catch (JsonParseException e) {
            logger.error("jsonToObject：JsonParseException", e);
        } catch (JsonMappingException e) {
            logger.error("jsonToObject：JsonMappingException", e);
        } catch (IOException e) {
            logger.error("jsonToObject：IOException", e);
        }
        return obj;
    }
    
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null)  
            return null;    
  
        Object obj = beanClass.newInstance();  
  
        Field[] fields = obj.getClass().getDeclaredFields();   
        for (Field field : fields) {    
            int mod = field.getModifiers();    
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }    
  
            field.setAccessible(true);    
            field.set(obj, map.get(field.getName()));   
        }   
  
        return obj;    
    }    
    
    public static Map<String, Object> convertMsgToMap(String msg) {
		Map<String, Object> transMsg = new LinkedHashMap<String, Object>();
		try {
			transMsg = JsonProcessUtil.jsonToMap(msg);
			if(null!=transMsg.get("reqVo")){
				Map<String, Object> reqVo = (Map<String, Object>) transMsg.get("reqVo");
				if(null!=reqVo){
					for (Object tmp : reqVo.keySet()) {
						logger.debug("key=" + tmp + " value=" + reqVo.get(tmp));
					   if(null!=tmp&&null!=reqVo.get(tmp)&&!"".equals(reqVo.get(tmp))){
						   transMsg.put((String)tmp, (String)reqVo.get(tmp));
					   }
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transMsg;
	}

  
}