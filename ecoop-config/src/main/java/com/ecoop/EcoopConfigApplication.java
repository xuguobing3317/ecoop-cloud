package com.ecoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName EcoopConfigApplication
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 01:16
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class EcoopConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcoopConfigApplication.class);
    }
}
