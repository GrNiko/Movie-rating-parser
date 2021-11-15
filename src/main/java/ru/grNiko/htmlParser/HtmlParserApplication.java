package ru.grNiko.htmlParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HtmlParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlParserApplication.class, args);
	}

}
