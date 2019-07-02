package com.ecoop;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EcoopEurekaApplication
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 23:16
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaServer
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class EcoopEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoopEurekaApplication.class);
    }
}
