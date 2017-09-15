package com.answern.claimsChannel;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.didispace.swagger.EnableSwagger2Doc;

 
@EnableSwagger2Doc 
@SpringBootApplication 
@EnableDiscoveryClient
//@ImportResource(locations={"classpath:config/application-dubbon.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	
}
