package a.b.c.com.kosmo.main.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.kosmo.login.controller.KosmoLoginController;
import a.b.c.com.kosmo.main.vo.KosmoMainVO;
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
	
	@RequestMapping(value="kosmoPopupCookie", method=RequestMethod.GET)
	@ResponseBody
	public String kosmoPopupCookie(HttpServletRequest req, HttpServletResponse res, KosmoMainVO kmainvo) {
		logger.info("KosmoMainController kosmoPopupCookie 함수 진입 >>> : ");	
		
		String chkpop = kmainvo.getChkpop();
		
		if (chkpop !=null && chkpop.equals("01")) {
			logger.info("KosmoMainController kosmoPopupCookie 함수 진입  chkpop >>> : " + chkpop);
			
			Cookie ck = new Cookie("onedayPopup", "off");
			ck.setPath(req.getContextPath());
			ck.setMaxAge(24*60*60);
			res.addCookie(ck);
			logger.info("KosmoMainController kosmoPopupCookie  >>> : 팝업이 하루 동안 열리지 않음");
		};
		
		return chkpop;
	}

}
