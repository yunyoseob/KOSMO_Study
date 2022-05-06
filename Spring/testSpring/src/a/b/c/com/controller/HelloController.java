package a.b.c.com.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {
	Logger logger = LogManager.getLogger(HelloController.class);

	@RequestMapping(value="spring_hello")
	public String hello_spring(Model model) {
		logger.info("HelloController.hello_spring() 함수 진입 >>> : ");
		
		model.addAttribute("msg", "Hello Spring !!!");
		logger.info("model >>> : " + model);
		
		return "spring_hello_return";
	}
			
	@RequestMapping(value="spring_hello_get", method=RequestMethod.GET)
	public String hello_spring_get(Model model_get) {
		logger.info("HelloController.hello_spring_get() 함수 진입 >>> : ");
		
		model_get.addAttribute("model_get", "Hello Spring model_get !!!");
		logger.info("model >>> : " + model_get);
		
		return "spring_hello_get_return";
	}
	
	@RequestMapping(value="spring_hello_post", method=RequestMethod.POST)
	public String hello_spring_post(Model model_post) {
		logger.info("HelloController.hello_spring_get() 함수 진입 >>> : ");
		
		model_post.addAttribute("model_post", "Hello Spring model_post !!!");
		logger.info("model >>> : " + model_post);
		
		return "spring_hello_post_return";
	}
}
