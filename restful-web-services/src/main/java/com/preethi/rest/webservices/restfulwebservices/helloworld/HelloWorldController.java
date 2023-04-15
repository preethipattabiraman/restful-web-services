package com.preethi.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Expose a REST API
//A new world
@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String sendHelloWorld() {
		return "Hello World";
	}
}
