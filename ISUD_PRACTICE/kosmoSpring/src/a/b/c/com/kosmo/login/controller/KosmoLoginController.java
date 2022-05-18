package a.b.c.com.kosmo.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.common.K_Session;
import a.b.c.com.kosmo.login.service.KosmoLoginService;
import a.b.c.com.kosmo.mem.vo.KosmoMemberVO;

@Controller
public class KosmoLoginController {
	Logger logger = LogManager.getLogger(KosmoLoginController.class);
	
	// 필드 오토와이어드 
	@Autowired(required=false)
	private KosmoLoginService kosmoLoginService;
	
	// 로긴 폼
	@RequestMapping(value="kosmoLoginForm", method=RequestMethod.GET)
	public String kosmoLoginForm() {
		logger.info("KosmoLoginController kosmoLoginForm 함수 진입 >>> : ");	
		return "login/kosmoLoginForm";
	}
	
	@RequestMapping(value="kosmoLoginCheck", method=RequestMethod.GET)
	public String kosmoLoginCheck(HttpServletRequest req, KosmoMemberVO kmvo, Model model) {
		logger.info("KosmoLoginController kosmoLoginCheck 함수 진입 >>> : ");	
		
		// 서비스 호출
		List<KosmoMemberVO> listLogin = kosmoLoginService.kosmoLoginCheck(kmvo);
				
		if (listLogin.size() == 1) { 
			logger.info("KosmoLoginController loginCheck listLogin.size() >>> : " + listLogin.size());
			
			K_Session ks = K_Session.getInstance();			
			String kID = ks.getSession(req);
			
			if (kID !=null && kID.equals(listLogin.get(0).getKmid())){				
				logger.info("KosmoLoginController login >>> : 로그인 중 >>> : 다른 페이지로 이동 하기 >>> : " + kID);
				model.addAttribute("listLogin", listLogin);
				return "main/kosmoMainPage";
			}else {
				ks.setSession(req, kmvo.getKmid());
				logger.info("KosmoLoginController login >>> : 세션부여 하기  >>> : " + kmvo.getKmid());
				
				model.addAttribute("listLogin", listLogin);
				return "main/kosmoMainPage";
			}
		}		
		return "login/kosmoLoginForm";
	}
	
	@RequestMapping(value="kosmoLogout", method=RequestMethod.GET)
	public String kosmoLogout(HttpServletRequest req, KosmoMemberVO mvo, Model model) {	
		logger.info("KosmoLoginController kosmoLogout() 함수 진입 >>> : ");		
								
		K_Session ks = K_Session.getInstance();			
		ks.killSession(req);
		return "login/kosmoLogout";
	}
}
