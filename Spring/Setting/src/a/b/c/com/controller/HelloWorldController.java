package a.b.c.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Controller
public class HelloWorldController {
	Logger logger = LogManager.getLogger(HelloWorldController.class);
	// index.jsp의 앵커 태그 내의 링크로 찾아오게 하기 위해 쓴다.
	@RequestMapping(value="hello_spring")
	public String HelloWord(Model model){
		logger.info("HelloWorldController.helloWorld() 함수 진입 >>> : ");
		
		model.addAttribute("msg", "Hello World Spring !!!! ");
		logger.info("model >>>> : "+model);
		
		// return 뒤에 jsp 파일의 이름을 적는다.
		return "hello_spring_returnjsp";
		// 확장자는 쓰지 않는다.
	}
}
