package com.chinapnr.mg.sms.service;

import java.io.StringReader;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.chinapnr.mg.sms.config.SmsProperties;


@Service
public class SmsService {
	
	private  Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	SmsProperties properties;
	
	public String sendSms( String msgContent, List<String> telList){
		try {
			HttpClient client = new HttpClient(); 
			PostMethod postMethod = new PostMethod(properties.getSMS_URL());
			postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			NameValuePair[] data = { 
					new NameValuePair("userid",properties.getSMS_USERID()),
					new NameValuePair("account",properties.getSMS_USERNAME()),
					new NameValuePair("password",properties.getSMS_PASSWORD()),
					new NameValuePair("mobile",StringUtils.strip(telList.toString(),"[]").replace(" ", "")),
					new NameValuePair("content",msgContent),
					new NameValuePair("sendTime",""),
					new NameValuePair("action","send"),
					new NameValuePair("checkcontent","0"),
					new NameValuePair("taskName",""),
					new NameValuePair("countnumber",telList.size()+""),
					new NameValuePair("mobilenumber",telList.size()+""),
					new NameValuePair("telephonenumber","0")};
			postMethod.setRequestBody(data);
			logger.info(new Date().toGMTString()+"send masage mobile number:"+StringUtils.strip(telList.toString(),"[]").replace(" ", "")+" content:"+msgContent);
			client.executeMethod(postMethod);
			String result =new String(postMethod.getResponseBodyAsString().getBytes( "utf-8"));
			logger.info("http response:"+result);
			String parseResult =null;
			try{
				SAXReader sAXReader =new SAXReader();
				Document document =sAXReader.read(new InputSource(new StringReader(result)));
				Element root =document.getRootElement();
				if(root!=null){
					parseResult = root.element("returnstatus").getText();	
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			logger.info(new Date().toGMTString()+"send masage get respons:"+parseResult);
			
			return parseResult.split(",")[0].equals("Success")? "00" : parseResult.split(",")[0];
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "99";
		}
	}

}
