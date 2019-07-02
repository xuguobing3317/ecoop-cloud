package com.ecoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName EcoopZuulApplication
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 08:50
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2
public class EcoopZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoopZuulApplication.class);
    }

}
