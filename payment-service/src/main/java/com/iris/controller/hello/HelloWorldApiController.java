package com.iris.controller.hello;

import com.iris.common.vo.RestReturnObject;
import com.iris.springboot.starter.web.controller.BaseController;
import com.iris.vo.DemoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块健康监测
 * 
 * @author qianjing
 *
 */
@RestController
@RequestMapping("/v2/hello")
@Api(value = "Hello World Api")
public class HelloWorldApiController extends BaseController {

	@ApiOperation(value = "HelloWorldApi", notes = "HelloWorldApi")
	@RequestMapping(value = "/world", method = RequestMethod.POST)
	public RestReturnObject helloWorld(@RequestBody DemoVo demoVo) {
		return RestReturnObject.generateSuccessObject("Hello world !");
	}

}
