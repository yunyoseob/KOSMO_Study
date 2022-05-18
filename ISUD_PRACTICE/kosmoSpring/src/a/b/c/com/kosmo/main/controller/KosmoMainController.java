package a.b.c.com.kosmo.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.login.controller.KosmoLoginController;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

@Controller
public class KosmoMainController {
	Logger logger = LogManager.getLogger(KosmoLoginController.class);
	
	@RequestMapping(value="kosmoMainPage", method=RequestMethod.GET)
	public String kosmoMainPage(HttpServletRequest req, KosmoMemberVO kmvo, Model model) {
		logger.info("KosmoMainController kosmoMainPage 함수 진입 >>> : ");	
		
		return "main/kosmoMainPage";
	}
	
	@RequestMapping(value="kosmoPopup", method=RequestMethod.GET)
	public String kosmoPopup(HttpServletRequest req, KosmoMemberVO kmvo, Model model) {
		logger.info("KosmoMainController kosmoMainPage 함수 진입 >>> : ");	
		
		return "main/kosmoPopup";
	}

}
