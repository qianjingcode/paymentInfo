package com.iris.api;

import com.iris.common.vo.RestReturnObject;
import com.iris.vo.DemoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * demoApi
 * 
 * @author qianjing
 *
 */
@FeignClient(value = "demoApi",url = "${payment_service}")
@ConditionalOnProperty(name="iris.payment.api.enabled",havingValue="true")
public interface DemoApi {

	@ApiOperation(value = "HelloWorldApi", notes = "HelloWorldApi")
	@RequestMapping(value = "/v2/hello/HelloWorld", method = RequestMethod.POST)
	public RestReturnObject notify(@RequestBody DemoVo demoVo);
	
}