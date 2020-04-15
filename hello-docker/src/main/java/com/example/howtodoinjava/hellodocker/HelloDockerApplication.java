package com.example.howtodoinjava.hellodocker;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloDockerApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(HelloDockerApplication.class, args);
	}
}

@RestController
class HelloDockerRestController {
	
	private static Log log = LogFactory.getLog(HelloDockerRestController.class);
	@RequestMapping("/hello/{name}")
	public String helloDocker(@PathVariable(value = "name") String name) {
		
		log.info("Executing the method Hellodocker with input : "+name);
		String response = "Hello " + name + " Response received on : " + new Date();
		System.out.println(response);
		return response;

	}
}
