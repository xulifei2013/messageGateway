package com.chinapnr.mg.core.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.chinapnr.mg.core.service.WxClient;

/**
 * 超出设置的指标后,调用指定的fallback方法,进行失败回调处理
 * 
 * @ClassName: WxClientImpl
 * @Description:TODO
 * @author: lifei.xu
 * @date: 2018年6月20日 下午3:07:12
 * 
 * @Copyright: 2018 www.hfrongzi.com Inc. All rights reserved.
 *             注意：本内容仅限于慧釜融资租赁（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Component
public class WxClientImpl implements WxClient {

	private static Logger logger = Logger.getLogger(WxClientImpl.class);

	@Override
	public String sendMessage(Map<String, Object> reqParas) {
		logger.info("进入fallback方法");
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "998");
		map.put("msg", "create fallback:" + JSON.toJSONString(reqParas));
		return JSON.toJSONString(map);
	}

}
