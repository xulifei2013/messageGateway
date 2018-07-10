package com.chinapnr.mg.api.util;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

public class BeanUtil extends org.springframework.beans.BeanUtils {
	
	public static void copyPropertiesHump(Object source, Object target, Class<?> editable, String... ignoreProperties)
			throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		if (editable != null) {
			if (!editable.isInstance(target)) {
				throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
						"] not assignable to Editable class [" + editable.getName() + "]");
			}
			actualEditable = editable;
		}
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

		for (PropertyDescriptor targetPd : targetPds) {
			Method writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), getUnderlineName(targetPd.getName()));
				if (sourcePd != null) {
					Method readMethod = sourcePd.getReadMethod();
					if (readMethod != null &&
							ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							Object value = readMethod.invoke(source);
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
						catch (Throwable ex) {
							throw new FatalBeanException(
									"Could not copy property '" + targetPd.getName() + "' from source to target", ex);
						}
					}
				}
			}
		}
	}
	public static void copyPropertiesToObj(Map<String, Object> source, Object target, String... ignoreProperties)
			throws BeansException {

		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		Class<?> actualEditable = target.getClass();
		List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

		for (PropertyDescriptor targetPd : targetPds) {
			if (ignoreList == null || !ignoreList.contains(targetPd.getName())) {
			Method writeMethod = targetPd.getWriteMethod();
			try {
				Object value = source.get(getUnderlineName(targetPd.getName()));
				if(value!=null){
					if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
						writeMethod.setAccessible(true);
					}
					writeMethod.invoke(target, value);
					
				}
				
			}
			catch (Throwable ex) {
				throw new FatalBeanException(
						"Could not copy property '" + targetPd.getName() + "' from source to target", ex);
			}
			}
		}
	}
	/**
     * covert field name to column name userName --> user_name
     * covert class name to column name UserName -- > user_name
     * */
    public static String getUnderlineName(String propertyName) {
        if (null == propertyName) {
            return "";
        }
        
        StringBuilder sbl = new StringBuilder(propertyName);
        sbl.setCharAt(0, Character.toLowerCase(sbl.charAt(0)));
        propertyName = sbl.toString();
        
        char[] chars = propertyName.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (CharUtils.isAsciiAlphaUpper(c)) {
                sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * covert field name to column name
     * covert field name to column name user_name --> userName
     * */
    public static String getHumnName(String fieldName) {
        if (null == fieldName) {
            return "";
        }
        fieldName = fieldName.toLowerCase();
        char[] chars = fieldName.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
	public static Map<String, String> parseMap(Map<String, Object> objectToMap) {
		Map<String, String> resultMap=new HashMap<String, String>();
		for (Map.Entry<String, Object> entry : objectToMap.entrySet()) {  
		    resultMap.put(entry.getKey(), entry.getValue()==null?null:entry.getValue().toString());
		}  
		return resultMap;
	}
	public static Map<String, String> mapUrlEncode(Map<String, String> objectToMap) {
		Map<String, String> resultMap=new HashMap<String, String>();
		for (Map.Entry<String, String> entry : objectToMap.entrySet()) {  
		    resultMap.put(entry.getKey(), entry.getValue()==null?null:(hasChinese(entry.getValue())?getUrlEncode(entry.getValue()):entry.getValue()));
		}  
		return resultMap;
	}
	
	public static Boolean hasChinese(String str) {
		Boolean result=false;
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		if (str != null) {
			Matcher aMatcher = pattern.matcher(str);
			result=aMatcher.find();
		}
		return result;
	}
	public static String getUrlEncode(String str)
    {
        if (str == null || "".equals(str))
        {
            return "";
        }
        try
        {
            str = URLEncoder.encode(str, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public static String getUrlDecode(String str)
    {
        if (str == null || "".equals(str))
        {
            return "";
        }
        try
        {
            str = URLDecoder.decode(str, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
