package com.preethi.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Expose a REST API
//A hello world
@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String sendHelloWorld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean sendHelloWorldBean() {
		return new HelloWorldBean("Hello World From Bean");
	}

	@GetMapping("/hello-world/{name}")
	public HelloWorldBean sendHelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
