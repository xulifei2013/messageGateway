package com.chinapnr.mg.core.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.chinapnr.mg.core.exception.AbstractController;
import com.chinapnr.mg.core.service.DdClient;
import com.chinapnr.mg.core.service.SmsClient;
import com.chinapnr.mg.core.service.WxClient;

/**
 * 
 * @ClassName:  MessageController   
 * @Description:提供消息发送服务,请求参数为Map键值对。
 * http://localhost:8762/mgcore/sendmg
 * @author: lifei.xu 
 * @date:   2018年6月20日 下午2:33:39   
 *     
 * @Copyright: 2018 www.hfrongzi.com Inc. All rights reserved. 
 * 注意：本内容仅限于慧釜融资租赁（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@RestController
public class MessageController extends AbstractController {
	private  Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
    SmsClient smsClient;
	@Autowired
    DdClient ddClient;
	@Autowired
    WxClient wxClient;
	
	/**
	 * 
	 * @Title: sendmg   
	 * @Description: 消息网关整合短信，微信，钉钉消息发送
	 * MediaType.APPLICATION_JSON_UTF8_VALUE 解决FASTJSON乱码问题
	 * @param: @param reqParas
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value ="/mgcore/sendmg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String sendmg(@RequestParam Map<String, Object> reqParas) {
		reqParas = new HashMap<String, Object>();
		reqParas.put("code", "000");
		reqParas.put("msg", "来自消息网关的消息");
		
		smsClient.sendMessage(reqParas);
		ddClient.sendMessage(reqParas);
		wxClient.sendMessage(reqParas);
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "000");
        map.put("msg", "消息发送成功");
        String result=JSON.toJSONString(map);
        logger.info(result);
		return result;
	}

}
