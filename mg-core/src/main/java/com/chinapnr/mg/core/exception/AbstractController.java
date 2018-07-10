package com.chinapnr.mg.core.exception;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @ClassName:  AbstractController   
 * @Description: 统一异常处理, 将controller继承该类, 即可.
 * @author: lifei.xu 
 * @date:   2018年6月20日 下午2:21:08   
 *     
 * @Copyright: 2018 www.hfrongzi.com Inc. All rights reserved. 
 * 注意：本内容仅限于慧釜融资租赁（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public abstract class AbstractController {
	
	private  Logger logger = Logger.getLogger(this.getClass());

	@ExceptionHandler({Exception.class})
    public Map<String, String> exceptionHandler(Exception e, WebRequest req) {
		logger.error("=================");
		logger.error(req.toString());
		logger.error(req.getRemoteUser());
		logger.error(req.getContextPath());
		logger.error("=============");
		logger.error(e);
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "999");
        map.put("msg", e.getMessage());
        return map;
    }
}
