package egovframework.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping(value = "/hello.do")
	public String helloWorld() throws Exception {
		return "hello/helloworld";
	}
}
