package cn.jiyun.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //配置类
@EnableSwagger2// 开启Swagger2的自动配置
public class SwaggerConfig {


    //1、Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket(Environment environment) {
     // 设置要显示swagger的环境
       // Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        //boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                //3、Docket 实例关联上 apiInfo()
                //一阶段
                .apiInfo(apiInfo())
                .groupName("你好") // 配置分组
                // .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问 http://localhost:8080/swagger-ui.html
                //二阶段 配置扫描接口及开关
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口  还会扫描别的
                                            //.any()扫描全部
                                            // basePackage 指定要扫描的包
                                            // none 不扫描
                                            // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                                            //withMethodAnnotation(final Class<? extends Annotation> annotation)
                                            // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                                            //withClassAnnotation(final Class<? extends Annotation> annotation)

                .apis(RequestHandlerSelectors.basePackage("cn.jiyun.swagger.controller")) //basePackage 指定要扫描的包 一般用这个
                // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
                //.paths(PathSelectors.ant("/hello/**"))
                .build(); //工厂模式

    }

    //1、Swagger实例Bean是Docket，所以通过配置Docket实例来配置Swaggger。
    @Bean //配置docket以配置Swagger具体参数
    public Docket docket2(Environment environment) {
        // 设置要显示swagger的环境
        // Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        //boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                //3、Docket 实例关联上 apiInfo()
                //一阶段
                .apiInfo(apiInfo())
                .groupName("哈哈") // 配置分组
                // .enable(b) //配置是否启用Swagger，如果是false，在浏览器将无法访问 http://localhost:8080/swagger-ui.html
                //二阶段 配置扫描接口及开关
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口  还会扫描别的
                //.any()扫描全部
                // basePackage 指定要扫描的包
                // none 不扫描
                // 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
                //withMethodAnnotation(final Class<? extends Annotation> annotation)
                // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
                //withClassAnnotation(final Class<? extends Annotation> annotation)

                .apis(RequestHandlerSelectors.basePackage("cn.jiyun.swagger.controller")) //basePackage 指定要扫描的包 一般用这个
                // 配置如何通过path过滤,即这里只扫描请求以/kuang开头的接口
                //.paths(PathSelectors.ant("/hello/**"))
                .build(); //工厂模式

    }



    //一阶段
    //2、可以通过apiInfo()属性配置文档信息
    //配置文档信息
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("张祺", "https://blog.csdn.net/Mrzhangqi126", "1261553384@qq.com");
        return new ApiInfo(
                "Swagger学习api文档", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "https://blog.csdn.net/Mrzhangqi126", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }



}
