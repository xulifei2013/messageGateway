package com.chinapnr.mg.dd.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
public class DdController {
	
	private  Logger logger = Logger.getLogger(this.getClass());
	@RequestMapping("/send/message")
	public String sendMag(@RequestParam Map<String, Object> reqParas) {
		setreceivelog(reqParas);
		return setresponselog(reqParas);
		
	}
	private void setreceivelog(Map<String, Object> req){
		logger.info("dd receive :" + JSON.toJSONString(req));
	}
	
	private String setresponselog(Map<String,Object> map){
		String rspStr = JSON.toJSONString(map);
		logger.info("dd response :" + rspStr);
		return rspStr;
	}

}
