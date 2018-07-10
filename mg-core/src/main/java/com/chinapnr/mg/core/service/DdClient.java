package com.chinapnr.mg.core.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinapnr.mg.core.service.impl.DdClientImpl;


/**
 * 
 * @ClassName:  DdClient   
 * @Description:TODO  
 * @author: lifei.xu 
 * @date:   2018年6月20日 下午3:02:31   
 *     
 * @Copyright: 2018 www.hfrongzi.com Inc. All rights reserved. 
 * 注意：本内容仅限于慧釜融资租赁（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "mg-dd")
public interface DdClient {

	@RequestMapping(method = RequestMethod.POST, path = "send/message")
    String sendMessage(@RequestParam Map<String, Object> reqParas);
}
