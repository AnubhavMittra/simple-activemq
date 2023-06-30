package com.invenico.simpleactivemq;

import com.invenico.simpleactivemq.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SimpleActivemqApplication implements ApplicationRunner {
	@Autowired
	Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(SimpleActivemqApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 0; i < 10; i++) {
			producer.produceMessage("Message " + (i+1));
			TimeUnit.SECONDS.sleep(5);
		}
	}
}
