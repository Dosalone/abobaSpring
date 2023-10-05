package ru.kubajan.aboba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AbobaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbobaApplication.class, args);
	}

}
