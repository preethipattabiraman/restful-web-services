package com.preethi.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// Implement the v1
	@GetMapping("/v1/persons")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("John Doe");
	}

	// Implement the v2
	@GetMapping("/v2/persons")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("John", "Doe"));
	}

	// Implement the v3
	@GetMapping("/v3/persons")
	public PersonV3 getThirdVersionOfPerson() {
		return new PersonV3("John", "Doe");
	}

	// Implement the v1 - request parameter
	@GetMapping(path = "/persons", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParams() {
		return new PersonV1("John Doe");
	}

	// Implement the v2 - request parameter
	@GetMapping(path = "/persons", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParams() {
		return new PersonV2(new Name("John", "Doe"));
	}

	// Implement the v1 - custom header
	@GetMapping(path = "/persons", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonCustomHeader() {
		return new PersonV1("John Doe");
	}

	// Implement the v2 - custom header
	@GetMapping(path = "/persons", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonCustomHeader() {
		return new PersonV2(new Name("John", "Doe"));
	}

	// Implement the v1 - Accept Header - custom
	@GetMapping(path = "/persons", produces = "application/preethi.company-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("John Doe");
	}

	// Implement the v2 - Accept Header - custom
	@GetMapping(path = "/persons", produces = "application/preethi.company-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("John", "Doe"));
	}
}
