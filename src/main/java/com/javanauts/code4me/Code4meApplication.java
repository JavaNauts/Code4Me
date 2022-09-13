package com.javanauts.code4me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Code4meApplication {

	public static void main(String[] args) {
		SpringApplication.run(Code4meApplication.class, args);
	}

}
