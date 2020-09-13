package org.drout.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/service")
public class SecuredResource {
	private static final Logger log = LoggerFactory.getLogger(SecuredResource.class);

	@RequestMapping("/user")
	public String user() {
		log.error("/api/v1/service/user");
		return "<h3>Welcome, To UserPage !!!";
	}

	@RequestMapping("/admin")
	public String admin() {
		log.error("/api/v1/service/admin");
		return "<h3>Welcome, To AdmimPage !!!</h3>";
	}
}
