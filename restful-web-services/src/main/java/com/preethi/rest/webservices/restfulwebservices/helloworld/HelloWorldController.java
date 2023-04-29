package com.preethi.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Expose a REST API
//A hello world
@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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

	@GetMapping("/hello-world-internationalized/{name}")
	public String sendHelloWorldPathVariableI18n(@PathVariable String name) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", new Object[] {name}, "Default Message", locale);
	}

}
