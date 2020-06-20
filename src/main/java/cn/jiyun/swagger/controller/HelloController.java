package cn.jiyun.swagger.controller;

import cn.jiyun.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //测试项目启动是否成功
    @RequestMapping("hello")
    public String hello(){

        return "你好世界";
    }
    //测试项目启动是否成功
    @ApiOperation("给方法加注释")
    @RequestMapping("hello/www")
    public String hellowww(@ApiParam("参数注释") String username){

        return "你好世界";
    }
    //测试项目启动是否成功
    @PostMapping("hello")
    public User user(){

        return new User();
    }


    //访问 http://localhost:8080/swagger-ui.html


}
