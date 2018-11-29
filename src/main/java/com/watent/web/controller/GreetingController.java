package com.watent.web.controller;

import com.watent.web.bean.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@Api(value = "测试类", tags = "test")
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "greeting方法", notes = "greeting")
    @ApiImplicitParam(name = "name", value = "打招呼", required = true, dataType = "String", paramType = "query")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}