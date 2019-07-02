package com.ecoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author crazy-xu
 * @Description //TODO
 * @Date 10:45 2019-07-02
 * @Param
 * @return
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableSwagger2
@EnableWebSocket
public class EcoopQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoopQueryServiceApplication.class, args);
	}

}
