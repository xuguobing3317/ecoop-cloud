package com.ecoop.ecoopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName EcoopGatewayApplication
 * @Description TODO
 * @Author crazy
 * @Date 2019-08-06 16:07
 * @Version 1.0
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class EcoopGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoopGatewayApplication.class, args);
    }

}
