package com.chnghx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@Value("${server.port}")
	int port;
	
	/**
	 * 
	 * config-client从config-server获取了cfg的属性，而config-server是从git仓库读取的
	 * 
	 * 返回从配置中心读取的cfg变量的值
	 */
	@Value("${cfg}")
    String cfg;
    @RequestMapping(value = "/c", produces="text/plain;charset=UTF-8")
    public String hi(){
        return cfg + ", port : " + port;
    }
}
