package org.drout.spring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeResource {
	private static final Logger log = LoggerFactory.getLogger(HomeResource.class);

	@RequestMapping("/index")
	public String init() {
		log.error("/api/v1/home/index");
		return "<h3>Welcome, To IndexHomePage !!!</h3>";
	}

}
