package org.drout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverMain implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(DriverMain.class);

	public static void main(String[] mains) {
		SpringApplication.run(DriverMain.class, mains);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("DriverMain.CommandLineRunner.Run()");
	}

}
