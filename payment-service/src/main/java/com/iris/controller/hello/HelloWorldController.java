package com.iris.controller.hello;

import com.iris.springboot.starter.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/hello")
@Api(value = "Hello World")
public class HelloWorldController extends BaseController {

	@ApiOperation(value = "HelloWorld", notes = "HelloWorld")
	@RequestMapping(value = "/world", method = RequestMethod.POST)
	public String helloWorld() {
		return "Hello world !";
	}

}
