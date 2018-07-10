package com.chinapnr.mg.sms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.chinapnr.mg.api.util.Utils;
import com.chinapnr.mg.sms.service.SmsService;

@RestController
public class SmsController {
	
	private  Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	SmsService smsService;
	
	@RequestMapping("/send/message")
	public String sendMag(@RequestParam Map<String, Object> reqParas) {
		setreceivelog(reqParas);
		Map<String,Object> map=new HashMap<String, Object>();
		 String msgContent=Utils.getObjToStr(reqParas.get("msgContent"));
		 List<String> telList=(List<String>) reqParas.get("telList");
		 String result=smsService.sendSms(msgContent, telList);
		 if("00".equals(result)){
			 map.put("code", "000");
			 map.put("mag", "短信发送成功");
		 }else{
			 map.put("code", "001");
			 map.put("mag", "短信发送失败");
		 }
		return setresponselog(map);
		
	}
	private void setreceivelog(Map<String, Object> req){
		logger.info("sms receive :" + JSON.toJSONString(req));
	}
	
	private String setresponselog(Map<String,Object> map){
		String rspStr = JSON.toJSONString(map);
		logger.info("sms response :" + rspStr);
		return rspStr;
	}

}
