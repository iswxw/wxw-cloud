package com.wxw.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author ：wxw.
 * @ Date ： 10:06 2020/9/30
 * @ Description：Docker整合测试
 * @ Version:   v_0.0.1
 */
@Slf4j
@RestController
public class DockerController {

    /**
     * 日志测试
     * @return
     */
    @GetMapping("/")
    public String defaultClass() {
        log.info("INFO：测试日志");
        return "运行成功，GOOD LUCK!";
    }

    /**
     * 异常日志测试
     * @return
     */
    @GetMapping("/docker")
    public String test_exception() {
        log.error("测试出现异常时，日志打印状况！");
        int num = 1/0;
        return "运行失败，Come On!";
    }
}
