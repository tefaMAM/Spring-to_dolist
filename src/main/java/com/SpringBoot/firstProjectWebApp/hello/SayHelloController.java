package com.SpringBoot.firstProjectWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//bean that handle request we will call it controller
@Controller
public class SayHelloController {
	@RequestMapping("ahmed")
	@ResponseBody
	public String ahmed() {
		return"Ahmed is here";
	}

	///src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	///src/main/resources/META-INF/resources/WEB-INF/jsp/goodWoek.jsp
	///src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
	
	//http://localhost:8080/login?name=mostafa
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}
